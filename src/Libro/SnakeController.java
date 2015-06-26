package Libro;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class SnakeController implements ControllerInterface{
        SnakeModelInterface model;
	DJView view;
    	public SnakeController(SnakeModelInterface model) {
		this.model = model;
		view = new DJView(this, new SnakeAdapter(model));
        view.createView();
        view.createControls();
		//view.disableStopMenuItem();
		//view.disableStartMenuItem();
	}
    	public void start(){
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
        }
        
	public void stop(){
        model.stop();
	view.disableStopMenuItem();
	view.enableStartMenuItem();
        }
        
	public void increaseBPM(){
            model.nextSong();
        }
        
	public void decreaseBPM(){
        model.previousSong();
        }
        
 	public void setBPM(int bpm){}
}
