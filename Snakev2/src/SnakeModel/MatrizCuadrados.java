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
    
    
    //el constructor crea una matriz de cuadrados estandar que serian el mapa de juego
    //tambien crea un arreglo de manzanas
    
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
                                //agrega cuadrados estandar siguiendo la estructura de matriz
        mapaDeCuadrados = new CuadradoEstandar[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                 mapaDeCuadrados[i][j] = new CuadradoEstandar(i, j);         
            }            
        }
    }
   
   
   public void setBordes() // a los cuadrados del borde los establece como no recorribles llamando al metodo
                                //setEsRecorrible de CuadradoEstandar
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
   
   private void crearListaManzanas() //crea arrayDeManzanas
   {
       listaDeManzanas = new ArrayList<>();
   }
   
   private boolean estaFueraDelMapa(int x, int y) //devuelve true si la coordenada esta fuera del mapa
                                                    //se verifica que no sean negativas
   {
       return x < 0 || y < 0 || x > ancho - 1 || y > alto - 1;

   }
   
   public boolean esRecorrible(int x,int y) // Devuelve true si la coordenada esta dentro del mapap y 
           //es recorrible
   {
       return estaFueraDelMapa(x,y) ? false : mapaDeCuadrados[x][y].getEsRecorrible();
   }
   
   
   public void agregarManzanas(Manzanas manzana)    //agrega una manzana al arreglo de manzanas
   {
       listaDeManzanas.add(manzana);
   }
   
   public Manzanas getManzana(int x, int y) //obtiene las coordenadas de una manza recorriendo el arreglo
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
           
       public void actualizarManzanas()  //Recorre el arregleo de manzanas y reduce eltiempo de vida en una unidad
                                        //si una de las manzanas tiene la variable tiempo en un valor menor o igual a 0
                                         //es eliminada del arreglo por lo tanto del mapa
       {
        for (Iterator<Manzanas> it = listaDeManzanas.iterator(); it.hasNext();) {
            Manzanas manzana = it.next();
            manzana.reducirTiempoVida();
            if (!manzana.quedaTiempo()) {
                it.remove();
            }
        }
    }

    public void agregarManzanas(int i, int i0, int i1, Snake snake) { //el parametro de Snake es para determinar    
                                                                        //su posicion y colocar una manzana en otra

        Random r = new Random(); //Se crea un numero aleatorio
        boolean agregada = false;

        while (!agregada) {
            int x = r.nextInt(this.ancho);
            int y = r.nextInt(this.alto);
            if (this.esRecorrible(x, y) //si la coordedana obtenida es un cuadrado recorrible
                    && !snake.estaEn(x, y)  //si la vibora no esta ahi
                    && this.getManzana(x, y) == null) { //si no hay ninguna manzana ahi
                listaDeManzanas.add(new Manzanas(i, i0, i1, x, y)); //seagrega la manzana en esa coordenada
                agregada = true;
            }
        }
    
    
    }
   
   }
    
    

