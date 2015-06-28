/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SnakeModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Leonardo
 */

//Permite manipular, las manzanas y cuadrados estandar
public class MatrizCuadrados {
    
    private CuadradoEstandar[][] mapaDeCuadrados;
    private ArrayList<Manzanas> listaDeManzanas;
    private int ancho;
    private int alto;
    
    
    //el constructor crea una matriz del tamano solicitado
    
    public MatrizCuadrados(int ancho, int alto)
    {
        this.alto = alto;
        this.ancho = ancho;
        crearMapa();
        crearListaManzanas();
    }
    
    public int getAlto() //Deuvelve el alto del mapa
    {
        return alto;
    }
    
    public int getAncho() //Devuelve el ancho del mapa
    {
        return ancho;
    }
    
    public boolean noHayManzanas() { //Devuelve  true si  no hay nada
        return listaDeManzanas.isEmpty();
    }
    
   private void crearMapa() { //Crea el mapa con ancho x alto cuadrados Estandar
        mapaDeCuadrados = new CuadradoEstandar[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                 mapaDeCuadrados[i][j] = new CuadradoEstandar(i, j);         
            }            
        }
    }
   
   
   public void setBordes() // a los cuadrados del borde los establece como no recorribles
   {
        for (int i = 0; i < ancho; i++) {
            mapaDeCuadrados[i][0].setEsRecorrible(false);
            mapaDeCuadrados[i][alto - 1].setEsRecorrible(false);
        }

        for (int j = 0; j < alto; j++) {
            mapaDeCuadrados[0][j].setEsRecorrible(false);
            mapaDeCuadrados[ancho - 1][j].setEsRecorrible(false);
        }
    }
   
   private void crearListaManzanas()
   {
       listaDeManzanas = new ArrayList<>();
   }
   
   private boolean estaFueraDelMapa(int x, int y) //devuelve true si la coordenada esta fuera del mapa
   {
       return x < 0 || y < 0 || x > ancho - 1 || y > alto - 1;

   }
   
   public boolean esRecorrible(int x,int y) // Devuelve true si la coordenada esta dentro del mapap y 
           //es recorrible
   {
       return estaFueraDelMapa(x,y) ? false : mapaDeCuadrados[x][y].getEsRecorrible();
   }
   
   
   public void agregarManzanas(Manzanas manzana)
   {
       listaDeManzanas.add(manzana);
   }
   
   public Manzanas getManzana(int x, int y)
   {
       if(!esRecorrible(x,y))
       {
           return null;
       }
       else
       {
           for (Manzanas manzana : listaDeManzanas)
           {
               if(manzana.getX() == x && manzana.getY()== y)
               {
                   return manzana;
               }
           }
       return null;
       }
   }
           
       public void actualizarManzanas() 
       {
        for (Iterator<Manzanas> it = listaDeManzanas.iterator(); it.hasNext();) {
            Manzanas manzana = it.next();
            manzana.reducirTiempoVida();
            if (!manzana.quedaTiempo()) {
                it.remove();
            }
        }
    }
   
   
   
   
   
   
   
   
   
   
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
      @Override
    public String toString() {
       StringBuffer sb = new StringBuffer();

        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                 if (mapaDeCuadrados[i][j].getEsRecorrible()) {
//                     if (snake.isAt(i, j)) {
//                        sb.append("@");
//                     } else 
                         if (getManzana(i, j) != null) {
                         sb.append('*');
                     } else {
                        sb.append(' ');
                     }
                 } else {
                     sb.append('#');
                 }
            }
            sb.append('\n');
        }
       return sb.toString();
    }

    public void agregarManzanas(int i, int i0, int i1, Snake snake) {

            Random r = new Random();
        boolean added = false;
        // TODO it is not guaranteed that this loop will ever end
        while (!added) {
            int x = r.nextInt(this.ancho);
            int y = r.nextInt(this.alto);
            if (this.esRecorrible(x, y)
                    && !snake.estaEn(x, y)
                    && this.getManzana(x, y) == null) {
                listaDeManzanas.add(new Manzanas(i, i0, i1, x, y));
                added = true;
            }
        }
    
    
    }
   
   }
    
    

