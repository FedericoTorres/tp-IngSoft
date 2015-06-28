package Libro;

import SnakeController.ReproductorController;
import SnakeModel.ReproductorModel;
import SnakeModel.ReproductorModelInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
public class MyReproductorModelTestDrive {
    


    public static void main(String[] args) 
    {
	
        try {
           ReproductorModelInterface model = new ReproductorModel();
            ControllerInterface controller = new ReproductorController(model);
        } catch (Exception ex) {
            Logger.getLogger(MyReproductorModelTestDrive.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

    
