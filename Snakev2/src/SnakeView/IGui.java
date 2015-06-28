package SnakeView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
public interface IGui {
    
    
    
	
	void setSnake(int x, int y);  //Establece las coordenadas de la snake en la gui

	void setManzanas(int x, int y); //Establece las coordenadas de la manzana en la gui


	void setBordes(int x, int y); //Establece los bordes de la matriz en la gui

	void setVacio(int x, int y); //Establece los cuadrados vacios recorribles


	void setPuntaje(int score); //actualiza el puntaje


        
        void perdiste();


    
    
    
    
    
    
    
    
}
