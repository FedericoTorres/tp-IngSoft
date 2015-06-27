package Snake;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */

import Snake.SnakeController.*;
import Snake.SnakeView.*;


public class TestSnake {
    
    public static void main(String[] args)
    {
     SnakeView interfaz = new SnakeView();
     SnakeController controller = new SnakeController(interfaz,interfaz);
     interfaz.setController(controller);
     interfaz.setVisible(true);       
    }
    
}
