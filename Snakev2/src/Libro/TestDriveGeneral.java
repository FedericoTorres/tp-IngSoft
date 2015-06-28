/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libro;

import SnakeModel.ReproductorModel;
import SnakeModel.ReproductorModelInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class TestDriveGeneral   {

 
 
     
    public static void main(String[] args) throws Exception
    {
        
        DJView view;
        DJView view2;
        BeatModelInterface beat = new BeatModel();
        
       HeartModel heartModel = HeartModel.getInstancia();
       ControllerInterface model = new HeartController(heartModel); //1 ventana
        
        
        view = new DJView(model, new HeartAdapter(heartModel));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
        
        
        view.hacerInvisible();//Ventana Invisible de HEART
        
        
        ControllerInterface model2 = new BeatController(beat);
        
      //  ReproductorModelInterface modelR = new ReproductorModel();
        //ControllerInterface controller = new BeatController(beat);
        view.setController(model2);//3 ventana
        view.setModel(beat);
        view.hacerVisible();//se hizo beat
        
          
        
        
        

        
    }

    
        
    
 
    
    

}
