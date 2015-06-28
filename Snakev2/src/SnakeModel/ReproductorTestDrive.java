
package SnakeModel;
 import Libro.ControllerInterface;
 import SnakeController.ReproductorController;

public class ReproductorTestDrive {
    
    public static void main(String[] args) throws Exception 
    {
	ReproductorModelInterface model = new ReproductorModel();
        ControllerInterface controller = new ReproductorController(model);
    }
}
