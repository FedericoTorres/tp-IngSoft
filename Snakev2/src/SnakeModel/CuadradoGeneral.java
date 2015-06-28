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
public class CuadradoGeneral {
    private int  x;
    private int  y;
    
    
    public CuadradoGeneral(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
        
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
        
    }
    
    public boolean equals(Object obj)
    {
        if (obj== null)
        {
            return false;
        }
       
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        else
        {
            if (this.x != ((CuadradoGeneral)obj).getX() || this.y != ((CuadradoGeneral)obj).getY())
            {
                return false;
            }
        }
        return true;
    }
                    
    
}
