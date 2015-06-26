
package Snake.SnakeModel;
 import Libro.ControllerInterface;

public class ReproductorTestDrive {
    
    public static void main(String[] args) throws Exception 
    {
	ReproductorInterface model = new Reproductor();
        ControllerInterface controller = new ReproductorController(model);
    }
}
