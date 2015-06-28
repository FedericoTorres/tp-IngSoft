package Libro;

public class HeartTestDrive 
{
    public static void main(String[] args) 
    {
	HeartModel heartModel = HeartModel.getInstancia();
        ControllerInterface model = new HeartController(heartModel);
    }
}
