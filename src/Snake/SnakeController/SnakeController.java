package Snake.SnakeController;

import Snake.SnakeModel.*;

public class SnakeController
{
    protected Grilla grilla;
    protected Snake snake;
    private final IInputcontroller input;
    protected final IGui gui;
    private boolean jugando = true;
    private int puntuacion;

    public SnakeController(IGui gui, IInputcontroller input) 
    {
        resetear();

        this.gui = gui;
        this.input = input;
    }

    public void resetear() 
    {
        grilla = new Grilla(20, 20);

        grilla.setLimites();

        snake = new Snake(10, 10);
        puntuacion = 0;
    }

    protected void unMovimiento() 
    {
        procesarInput(getInput());
        moverSnake();
        agregarManzanas();
        chequearManzanas();
        grilla.actualizarManzanas();

        if(isGameOver()) 
        {
            jugando = false;
            gui.sendMessage("Game over");
            //saveHighScore();
        }

        actualizarGui();
    }

    /**private void saveHighScore() {
            HighScore.getInstance().addAndSave(
                            Utilities.getInstance().getPlayerName(), score);
    }*/

    private boolean isGameOver() 
    {
        Cuadrado cabeza = snake.getCabeza();
        boolean libre = grilla.isLibre(cabeza.getX(), cabeza.getY());

        return !libre || snake.seGolpea();
    }

    private void moverSnake() 
    {
        snake.moverseEnLaDireccionActual();
    }

    private void chequearManzanas() 
    {
        Cuadrado cabeza = snake.getCabeza();
        Manzana manzana = grilla.getManzana(cabeza.getX(), cabeza.getY());
        
        if(manzana != null)
            puntuacion += snake.comer(manzana);
    }

    private void agregarManzanas() 
    {
        if(grilla.sinManzanas()) 
            grilla.agregarManzana(100, 3, 30, snake);
    }

    public void actualizarGui()
    {
        for(int i = 0; i < grilla.getAncho(); i++) 
        {
            for(int j = 0; j < grilla.getAlto(); j++) 
            {
                if(!grilla.isLibre(i, j)) 
                {
                    gui.setBorder(i, j);
                } 
                else if(grilla.getManzana(i, j) != null) 
                {
                    gui.setBoni(i, j);
                } 
                else if(snake.estaEn(i, j)) 
                {
                    gui.setSnake(i, j);
                } 
                else 
                {
                    gui.setEmpty(i, j);
                }
            }
        }

        gui.setScore(getPuntuacion());
        gui.updateUI();
    }

    public void jugar()
    {
        while(isJugando()) 
        {
            unMovimiento();
            
            try 
            {
                Thread.sleep(250);
            } 
            catch(InterruptedException e) 
            {
            }
	}
    }

    public int getPuntuacion() 
    {
        return puntuacion;
    }

    public boolean isJugando() 
    {
        return jugando;
    }

    public void setIsJugando() 
    {
        jugando = true;
    }

    public void detenerJuego() 
    {
        jugando = false;
    }

    public int getAncho() 
    {
        return grilla.getAncho();
    }

    public int getAlto() 
    {
        return grilla.getAlto();
    }

    private int getInput() 
    {
        return input.getInput();
    }

    private void procesarInput(int movimientoInput) 
    {
        switch(movimientoInput) 
        {
            case 1:
                    snake.moverseArriba();
                    break;
            case 2:
                    snake.moverseDerecha();
                    break;
            case 3:
                    snake.moverseAbajo();
                    break;
            case 4:
                    snake.moverseIzquierda();
                    break;
            default:
                    break;
        }
    }
}