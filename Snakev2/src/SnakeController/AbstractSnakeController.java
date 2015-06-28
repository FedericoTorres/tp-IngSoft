/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SnakeController;

/**
 *
 * @author Leonardo
 */

import SnakeView.IGui;
import SnakeView.InterfaceEntradaController;
import SnakeModel.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class  AbstractSnakeController {
    
    	protected MatrizCuadrados matrizJuego;
	protected Snake snake;
	private final InterfaceEntradaController input;
	protected final IGui gui;
	private boolean jugando = true;
	private int puntaje;
        private boolean seEscucha = true;
        protected ReproductorModelInterface musica;
      
        public AbstractSnakeController(IGui gui, InterfaceEntradaController input) {
		resetJuego();
		this.gui = gui;
		this.input = input;
                try {
                    this.musica = new ReproductorModel();
                } catch (Exception ex) {
                    Logger.getLogger(AbstractSnakeController.class.getName()).log(Level.SEVERE, null, ex);
                }
	}

        
       
       protected void jugarDurante() {
	entradaTeclado(getInput());

	moverSnake();
	agregarManzanas();
	chequearManzanas();
	matrizJuego.actualizarManzanas();
        if (seEscucha)
        {
               reproducirMusica();
        }
        else
        {
            stopMusica();
        }
              

	if (this.esGameOver()) 
            {
		jugando = false;
                gui.perdiste();
		//saveHighScore();
            }

		updateGui();
	}
        
        
        
        
        
        
        public void resetJuego() //esto iniciaria el juego
        {
            matrizJuego = new MatrizCuadrados(40,40);
            matrizJuego.setBordes();
            snake = new Snake(20,20);//COLOCA LA VIBORA EN LA MITAD
            puntaje  =  0;
            seEscucha = true;
        }
        
        private void agregarManzanas()//agrega manzanas sino hay ninguna
        {
            if(matrizJuego.noHayManzanas())
                matrizJuego.agregarManzanas(100,3,30, snake);
        }
        
        private void chequearManzanas()//verifica que la vibora este en la misma coordenada que una manzana
        {
            CuadradoGeneral cabeza = snake.getCabezaSnake();
            Manzanas manzana =  matrizJuego.getManzana(cabeza.getX(), cabeza.getY());
            if (manzana != null)
            {
                puntaje += snake.comerManzana(manzana);
            }
        }
        
        private void moverSnake()
        {
            snake.moverseEnDireccionActual();
        }
        
        
        
        
        private void entradaTeclado(int inputMove) {
		switch (inputMove) {
		case 1:
			snake.moverArriba();
			break;
		case 2:
			snake.moverDerecha();
			break;
		case 3:
			snake.moverAbajo();
			break;
		case 4:
			snake.moverIzquierda();
			break;      
		default:
			break;
		}
	}

        //Retorna verdadero si se choco una pared o a si misma
        private boolean esGameOver() {
            CuadradoGeneral cabeza = snake.getCabezaSnake();
            boolean recorrible = matrizJuego.esRecorrible(cabeza.getX(), cabeza.getY());
            return !recorrible || snake.seChoco();
	}

	protected void stopMusica()
        {
            musica.stop();
            this.seEscucha = false;
        }
        
        protected void reproducirMusica()
        {
            musica.on();
            this.seEscucha= true;
        }
        public void reproducirMusicaPublic()
        {
            reproducirMusica();
        }
        
        public void  siguiente()
        {
            musica.nextSong();
        }
        public void anterior()
        {
            musica.previousSong();
        }
        
        public abstract void updateGui();

	/**
	 * this method should be called to run the game.
	 */
	public abstract void jugar();

	/**
	 * returns the current score.
	 * 
	 * @return current score
	 */
	public int getPuntaje() {
		return puntaje;
	}

	public boolean estaJugando() {
		return jugando;
	}

	/**
	 * enables the game loop.
	 */
	public void setEstaJugando() {
		jugando = true;
	}

	/**
	 * stops the current game.
	 */
	public void stopJugar() {
		jugando = false;
                stopMusica();
	}
        
        public void stopMusicaPublic()
        {
            stopMusica();
        }
	/**
	 * returns width of game field.
	 * 
	 * @return width of game field
	 */
	public int getAncho() {
		return matrizJuego.getAncho();
	}

	/**
	 * returns height of game field.
	 * 
	 * @return height of game field
	 */
	public int getAlto() {
		return matrizJuego.getAlto();
	}

	/**
	 * reads input from <code>Inputcontroller</code>.
	 */
	private int getInput() {
		return input.getEntrada();
	}



























}
