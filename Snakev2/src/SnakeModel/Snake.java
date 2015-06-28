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
    private int crece;
    
    private final ArrayList<CuadradoGeneral> largo;
    
    
    //el constructor crea una snake de un cuadrado
    
    
    public Snake(int xInicio,int yInicio)
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
    {
        setCrecer(manzana.getValorDeCrecimiento());
        manzana.setTiempoMuerACero();
        return manzana.getPuntosValor(); //esto es el score
    }
    
    
    public CuadradoGeneral getCabezaSnake()
    {
        return largo.get(0);
    }
    
    
    public void setCrecer()
    {
        this.crece++;
    }
    
    public void setCrecer(int crece)
    {
        this.crece += crece;
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
    private void agregarCuadradoEnLaCabeza() {
		CuadradoGeneral cabeza = largo.get(0);
		int newX = cabeza.getX();
		int newY = cabeza.getY();
		switch (direccionActual) {
		case ARRIBA:
			newY--;
			break;
		case ABAJO:
			newY++;
			break;
		case IZQUIERDA:
			newX--;
			break;
		case DERECHA:
			newX++;
			break;
		case NADA:
			return;
		default:
			return;
		}
		largo.add(0, new CuadradoGeneral(newX, newY));
	}
    
    private void removerCuadradoDeLaCola() {
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
    
    
    public boolean estaEn(int x, int y) { //cordenada de ese cuadrado
		return largo.contains(new CuadradoGeneral(x, y));
	}
    
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
