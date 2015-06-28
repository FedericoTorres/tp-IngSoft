/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SnakeController;

import SnakeView.IGui;
import SnakeView.InterfaceEntradaController;

/**
 *
 * @author Leonardo
 */
public class SnakeGameController extends AbstractSnakeController {


    public SnakeGameController(IGui gui, InterfaceEntradaController input) {
        super(gui, input);
     
    }

    
    
    
    //ACTUALIZA LA INTERFAZ GRAFICA, SETEANDO LAS COORDENADAS DE LOS BORDES
    //DE LAS MANZANAS, Y DE LA VIBORA Y AQUELLOS CUADRADOS VACIOS
    @Override
    public void updateGui() {
        for (int i = 0; i < matrizJuego.getAncho(); i++) {
			for (int j = 0; j < matrizJuego.getAlto(); j++) {
				if (!matrizJuego.esRecorrible(i, j)) {
					gui.setBordes(i, j);
				} else if (matrizJuego.getManzana(i, j) != null) {
					gui.setManzanas(i, j);
				} else if (snake.estaEn(i, j)) {
					gui.setSnake(i, j);
				} else {
					gui.setVacio(i, j);
				}
    
                        }
                        
                        gui.setPuntaje(super.getPuntaje());//ACTUALIZA EL PUNTAJE
        }
    }
    
//METODO MAS IMPORTANTE DEL CONTROLLER, MEDIANTE UN LOOP QUE DETERMINE SI LA VARIABLE
    //JUGANDO ES TRUE, PERMITE JUGAR DURANTE ESA VARIABLE NO CAMBIE DE ESTADO TRUE A ESTADO FALSE
   
    @Override
    public void jugar() {

    while (super.estaJugando()) {
			super.jugarDurante();
			try {
				Thread.sleep(250); //DUERME EL THREAD POR 250MS REPRESENTARIA
                                                    //LA VELOCIDAD DE LA VIBORA
			} catch (InterruptedException ex) {
			}
		}
    }
    
}
