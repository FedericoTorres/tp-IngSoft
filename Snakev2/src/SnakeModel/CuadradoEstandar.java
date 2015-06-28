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

//Esta clase permite la creacion de cuadrados estandar,parte 
//principal de la matriz en donde se movera la serpiente
public class CuadradoEstandar extends CuadradoGeneral {
    
    private boolean esRecorrible;
    
    
    public CuadradoEstandar(int x,int y){
        
        super(x,y);
        esRecorrible = true;
        
    }
    
    
    public boolean getEsRecorrible()
    {
        return esRecorrible;
     
    }
    
    public void setEsRecorrible(boolean i)
    {
        esRecorrible = i;
    }
}
