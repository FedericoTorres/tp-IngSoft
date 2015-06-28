package Libro;

import SnakeController.ReproductorController;
import SnakeModel.ReproductorModel;
import SnakeModel.ReproductorModelInterface;

/**
 *
 * @author Federico
 */
public class TestDriveTresVentanas
{
    public static void main(String[] args) throws Exception
    {
        BeatModelInterface beatModel = new BeatModel();
        ControllerInterface beatController = new BeatController(beatModel);
        HeartModel heartModel = HeartModel.getInstancia();
        ControllerInterface heartController = new HeartController(heartModel);
        ReproductorModelInterface model = new ReproductorModel();
        ControllerInterface controller = new ReproductorController(model);
    }
}
