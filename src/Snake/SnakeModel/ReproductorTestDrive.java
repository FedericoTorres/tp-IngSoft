/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake.SnakeModel;

/**
 *
 * @author Nacho
 */
public class ReproductorTestDrive {
    
    public static void main(String[] args) throws Exception 
    {
	ReproductorInterface model = new Reproductor();
        ControllerInterface controller = new ReproductorController(model);
    }
}
