/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SnakeModel;

/**
 *
 * @author Leonardo
 */

//Clase que determina elcomportamiento de aquellos cuadrados que sean manzanas
public class Manzanas  extends CuadradoGeneral
{
    private final int puntosValor;          //puntaje que aumenta comer esta manzana
    private final int valorDeCrecimiento; //lo que la snake crezca al comer una manzana
    
    private int tiempoMuerte; //tiempo de vida de la manzana
    
    public Manzanas(int puntosVal, int valorDeC, int tiempoMuer, int x, int y)
    {
        super(x,y);
        this.puntosValor = puntosVal;
        this.valorDeCrecimiento = valorDeC;
        this.tiempoMuerte= tiempoMuer;
    }

    public int getPuntosValor() //Retorna los puntos de valor para aumentar el score
    {
        return this.puntosValor;
    }
    
    public int getValorDeCrecimiento() // Cuanto va  aaumentar la vibora si se consume una manzana
    {
        return this.valorDeCrecimiento;
    }
    
    public void reducirTiempoVida() //Reduce en 1 unidad el tiempo de vida de la manzana, asi desaparece
    {
        if (this.tiempoMuerte > 0)
        {
            tiempoMuerte--;
        }
    }
    
    public boolean quedaTiempo()
    {
        return tiempoMuerte > 0;
    }
    
    public void setTiempoMuerACero()
    {
        this.tiempoMuerte = 0;
    }
 }
