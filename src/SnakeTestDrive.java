/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
public class SnakeTestDrive {
    


    public static void main(String[] args) throws Exception 
    {
	SnakeModelInterface model = new SnakeModel();
        ControllerInterface controller = new SnakeController(model);
    }
}

    
