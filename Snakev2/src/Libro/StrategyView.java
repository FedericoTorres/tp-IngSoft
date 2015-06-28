/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libro;

import SnakeModel.ReproductorModelInterface;

/**
 *
 * @author Leonardo
 */
public class StrategyView extends DJView {

    BeatModelInterface beatModel, reproductorAdapter, heartAdapter;
    ReproductorModelInterface reproductorModel;
    HeartModelInterface heartModel;
    
    
    
    public StrategyView(ControllerInterface controller, BeatModelInterface model) {
        super(controller, model);
    }
    
}
