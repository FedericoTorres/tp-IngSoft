/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SnakeModel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Leonardo
 */
public class Snake implements InterfazObjetoMovible {

    private enum direccion {
        ARRIBA, ABAJO, DERECHA, IZQUIERDA, NADA
    }
    
    private direccion direccionActual;
    private int crece; //Esta variable aumenta al comer una manzana y decreceria con cada ciclo ver funcionamiento
                          //en metodo RemoverCuadradoDeLaCola
    
    private final ArrayList<CuadradoGeneral> largo; //Este array representa la serpiente
                                                    //la serpiente es un conjunto de cuadrados
    
    
    //el constructor crea una snake de un cuadrado
    
    
    public Snake(int xInicio,int yInicio) //crea una nueva snake DE UN CUADRADO DE LARGO
                                            //en la posicion x,y que se definan
    {
        largo = new ArrayList<>();
        largo.add(new CuadradoGeneral(xInicio,yInicio));
        direccionActual = direccion.NADA;
    }
   
    public Snake()
    {
        this(0,0);
    }
    
    public int comerManzana(Manzanas manzana)// Come la manzana, pone el tiempo a 0 asi se borra y 
                                                    //luego devuelve el score
                                                   //Aumenta la variable integer CRECER que establece cuantos
                                                   //cuadrados va a crecer
    {
        setCrecer(manzana.getValorDeCrecimiento());
        manzana.setTiempoMuerACero();
        return manzana.getPuntosValor(); //esto es el score
    }
    
    
    public CuadradoGeneral getCabezaSnake() //obtiene el cuadrado que se encentra primero en el array
                                                //representa la cabeza
    {
        return largo.get(0);
    }
    
    
    public void setCrecer()
    {
        this.crece++; 
    }
    
    public void setCrecer(int crece)
    {
        this.crece += crece; //aumenta el tamano de la vibora lo que valgan los puntos de crecimientos de la manzana
    }
    
    public void moverseEnDireccionActual() //Se mueve y se le agrega un cuadrado en la cabeza
            // y se borra uno de la cola
    {
         agregarCuadradoEnLaCabeza();
         if (largo.size() > 1) 
         {
		removerCuadradoDeLaCola();
         }
    }
    //Agrega un cuadrado en el frente de la cabeza 
    //depende de la direccion d ela vibora agrega un cuadrado en la coordenada que corresponda
    private void agregarCuadradoEnLaCabeza() {
		CuadradoGeneral cabeza = largo.get(0);
		int newX = cabeza.getX();
		int newY = cabeza.getY();
		switch (direccionActual) {
		case ARRIBA:
			newY--;
			break; //la cabeza ahora se moveria para arriba ya que las Y menos estan arriba
		case ABAJO:
			newY++;
			break; //aumenta solo y ya que en X no se movio y aumenta ya que se dirije a coordenadas mas 
                                //abajo v
		case IZQUIERDA:
			newX--; //las coordenada de x Disminuyen ya que se mueve hacia la izq
			break;
		case DERECHA:
			newX++;
			break;
		case NADA:
			return;
		default:
			return;
		}
		largo.add(0, new CuadradoGeneral(newX, newY)); //se agrega un nuevo cuadrado en esa coordenada y el
                                                                //anterior se empuja a la posicion siguiente
                                                                //quedando asi 2 cuadrados 
	}
    
    private void removerCuadradoDeLaCola() {//Verifica el valor de crecimiento, si la serpiente al moverse comio
                                              //una manzana la variable crece tendraun valor determinado
                                               //entonces ese cuadrado no se borra, si la variable crece no tiene
                                               //ningun valor se tiene que remover elcuadrado de la cola para que la 
                                               //viborasiga manteniendo su tamano original
		if (crece > 0) {
			crece--;
			return; // no borra la cola
		} 
                else {
			largo.remove(largo.size() - 1); // remove tail
                }
    }
    
    //Devuelve true si la un cuadrado de la vibora esta en la misma coordenada que otro cuadrado de la vibora
    public boolean seChoco() {
		Iterator<CuadradoGeneral> iterator = largo.iterator();
		CuadradoGeneral cabeza = iterator.next();
		while (iterator.hasNext()) {
			if (iterator.next().equals(cabeza)) {
				return true;
			}
		}
		return false;
	}
    
    
    public boolean estaEn(int x, int y) { //cordenada de algun cuadrado de la vibora
		return largo.contains(new CuadradoGeneral(x, y));
	}
    
    
    
    //cambia la direccion de la vibora
    @Override
    public void moverArriba() {
        if (direccionActual != direccion.ABAJO)
        {
            direccionActual = direccion.ARRIBA;
        }
    }

    @Override
    public void moverAbajo() {
        if (direccionActual != direccion.ARRIBA)
        {
            direccionActual = direccion.ABAJO;
        }
    }

    @Override
    public void moverDerecha() {
        if (direccionActual != direccion.IZQUIERDA)
        {
            direccionActual = direccion.DERECHA;
        }
    }

    @Override
    public void moverIzquierda() {
        if (direccionActual != direccion.DERECHA)
        {
            direccionActual = direccion.IZQUIERDA;
        }
    }   
    
    
    
}
