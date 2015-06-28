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

    @Override
    public void updateGui() {
        for (int i = 0; i < matrizJuego.getAncho(); i++) {
			for (int j = 0; j < matrizJuego.getAlto(); j++) {
				if (!matrizJuego.esRecorrible(i, j)) {
					gui.setBorder(i, j);
				} else if (matrizJuego.getManzana(i, j) != null) {
					gui.setBoni(i, j);
				} else if (snake.estaEn(i, j)) {
					gui.setSnake(i, j);
				} else {
					gui.setEmpty(i, j);
				}
    
                        }
                        
                        gui.setScore(super.getPuntaje());
        }
    }
    

    @Override
    public void jugar() {

    while (super.estaJugando()) {
			super.jugarDurante();
                     // super.reproducirMusica();
			try {
				Thread.sleep(250);
			} catch (InterruptedException ex) {
			}
		}
    }
    
}
