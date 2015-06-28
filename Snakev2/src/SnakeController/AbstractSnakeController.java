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
    
    	protected MatrizCuadrados matrizJuego; //El controlador va  atener una matriz
	protected Snake snake;                  //Una Vibora
	private final InterfaceEntradaController input; //Representa al metodo getInput de la interfaz grafica, traduce
                                                //la entrada por teclado de letras  a un numero determinado
	protected final IGui gui;
	private boolean jugando = true; //Variable que en false parara el juego
	private int puntaje;            //puntaje obtenido, se obtiene del metodo comerManzana de Snake que devuelve el puntaje
        private boolean seEscucha = true; //Determina si la musica se escucha o no
        protected ReproductorModelInterface musica; //Un Modelo de Musica
      
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
	entradaTeclado(getInput()); //obtiene la entrada por teclado seteada en la GUI y dependiendo de cual
                                            //se cambia la direccion de la vibora

	moverSnake(); //Como se modifico la  direccion de la vibora hay que llamar al metodo MoverseEnDireccionActual
	agregarManzanas();  //Se agrega una manzana, utilizando el metodo agregar manzanas de la matriz de juego
	chequearManzanas(); //Se chequea que la vibora se haya comido una manzana
	matrizJuego.actualizarManzanas(); //se disminiye el tiempo de vida de la manzana
        if (seEscucha)
        {
               reproducirMusica(); 
        }
        else
        {
            stopMusica();
        }
              

	if (this.esGameOver())   //Si la vibora se choco con si misma o si esta en una coordenada no recorri
                                  //ble se para el juego
            {
		jugando = false;
                gui.perdiste(); //Se abre una formulario en la interfaz informando de gameover
            }

		updateGui(); //Se updatea la interfazGrafica
	}
        
        
        
        
        
        
        public void resetJuego() //esto iniciaria el juego
        {
            matrizJuego = new MatrizCuadrados(20,20);//Se crea por defecto una matriz de 40/40
            matrizJuego.setBordes();
            snake = new Snake(10,10);//COLOCA LA VIBORA EN LA MITAD
            puntaje  =  0; //el puntaje se establece en 0
            seEscucha = true; //Hace que en el siguiente ciclo la musica se prenda
        }
        
        private void agregarManzanas()//agrega manzanas sino hay ninguna
        {
            if(matrizJuego.noHayManzanas())
                matrizJuego.agregarManzanas(100,1,30, snake);
        }
        
        private void chequearManzanas()//verifica que la vibora este en la misma coordenada que una manzana
        {
            CuadradoGeneral cabeza = snake.getCabezaSnake();
            Manzanas manzana =  matrizJuego.getManzana(cabeza.getX(), cabeza.getY());
            if (manzana != null)
            {
                puntaje += snake.comerManzana(manzana); //aumenta el puntaje obteniendo el puntaje que tiene cada 
                                                        //objeto manzana
            }
        }
        
        private void moverSnake()
        {
            snake.moverseEnDireccionActual(); //mueve la snake
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
        public void reproducirMusicaPublic() //metodo publico para usar en la GUI para parar la musica
        {
            reproducirMusica();
        }
        
        public void  siguiente()//Metodo publico para usar en la GUI para ejecutar la cancion sig
        {
            musica.nextSong();
        }
        public void anterior() //Metodo publico para usar en la GUI para ejecutar la cancion anterior
        {
            musica.previousSong();
        }
        
        public abstract void updateGui();

	/**
	 * this method should be called to run the game.
	 */
	public abstract void jugar();


	public int getPuntaje() {
		return puntaje;
	}

	public boolean estaJugando() {
		return jugando;
	}

        //metodo que positibilita mediante loop la ejecucion del juego
        //IMPORTANTISIMO
	public void setEstaJugando() {
		jugando = true;
	}

	//para el juego y la musica
	public void stopJugar() {
		jugando = false;
                stopMusica();
	}
        
        public void stopMusicaPublic()
        {
            stopMusica();
        }
	//retorna el ancho
	public int getAncho() {
		return matrizJuego.getAncho();
	}

//retorna el alto dela matriz
	public int getAlto() {
		return matrizJuego.getAlto();
	}


        
            //obtiene el valor ingresado por teclado desde la GUI
	private int getInput() {
		return input.getEntrada();
	}



























}
