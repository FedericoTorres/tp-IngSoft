package Snake.SnakeModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snake implements ObjetoConMovimientos {
    
    private direccion direccionActual;
    private int crecimiento;
    
    private final List<Cuadrado> cuadrados;
    
    private enum direccion {
	arriba, abajo, izquierda, derecha, ninguna
    }
    
    public Snake(int xStart, int yStart) {
	cuadrados = new ArrayList<Cuadrado>();
	cuadrados.add(new Cuadrado(xStart, yStart));
	direccionActual = direccion.ninguna;
    }
    
    public Snake() {
	this(0, 0);
    }
    
   public int eat(Manzana manzana) {
	crecer(manzana.getCrecimiento());
	manzana.setTiempoEnCero();
	return manzana.getPuntaje();
    }
   
   public Cuadrado getCabeza() {
	return cuadrados.get(0);
    }
   
    public void crecer() {
	crecimiento++;
    }
    
    public void crecer(int amount) {
	crecimiento += amount;
    }
    
    public void moverseEnLaDireccionActual() {
	addSquareToHead();
	if (cuadrados.size() > 1) {
		sacarUltimoCuadrado();
	}
    }
    
    private void addSquareToHead() {
	Cuadrado head = cuadrados.get(0);
	int newX = head.getX();
	int newY = head.getY();
	switch (direccionActual) {
	case arriba:
		newY--;
		break;
	case abajo:
		newY++;
		break;
	case izquierda:
		newX--;
		break;
	case derecha:
		newX++;
		break;
	case ninguna:
		return;
	default:
		return;
	}
	cuadrados.add(0, new Cuadrado(newX, newY));
    }    
    
public boolean seGolpea() {
    Iterator<Cuadrado> iterator = cuadrados.iterator();
    Cuadrado cabeza = iterator.next();
    while (iterator.hasNext()) {
            if (iterator.next().equals(cabeza)) {
                            return true;
                    }
            }
            return false;
    } 

    private void sacarUltimoCuadrado() {
            if (crecimiento > 0) {
                    crecimiento--;
                    return; // do not remove tail (grow)
            } else {
                    cuadrados.remove(cuadrados.size() - 1);
            }
    }
    
    @Override
    public void moverseArriba() {
            if (direccionActual != direccion.abajo) {
                  direccionActual = direccion.arriba;
            }
    }

    @Override
    public void moverseAbajo() {
            if (direccionActual != direccion.arriba) {
                    direccionActual = direccion.abajo;
            }
    }
    
    @Override
    public void moverseIzquierda() {
            if (direccionActual != direccion.derecha) {
                                                                                                  
                    direccionActual = direccion.izquierda;
            }
    }
    
    @Override
    public void moverseDerecha() {
            if (direccionActual != direccion.izquierda) { 
                                                                                               
                    direccionActual = direccion.derecha;
            }
    }  
    
    public boolean estaEn(int x, int y) {
            return cuadrados.contains(new Cuadrado(x, y));
    }

}
