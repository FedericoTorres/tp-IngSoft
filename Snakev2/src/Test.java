
import SnakeController.SnakeGameController;
import SnakeView.SwingGui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
public class Test {
    
    public static void main (String[] args)
    {
                SwingGui gui = new SwingGui();
		SnakeGameController c = new SnakeGameController(gui, gui);
		gui.setController(c);
		gui.setVisible(true);
	}
    }

