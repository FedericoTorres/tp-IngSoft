
import java.io.BufferedInputStream;

import java.io.File;

import java.io.FileInputStream;

import java.io.InputStream;
import java.util.ArrayList;

 

import javax.sound.midi.MidiSystem;

import javax.sound.midi.Sequencer;

 

public class SnakeModel {

 

    public static void main(String[] args) throws Exception {


        // Obtains the default Sequencer connected to a default device.

        Sequencer sequencer = MidiSystem.getSequencer();
        ArrayList   bfis = new ArrayList();
        File	midiFile = new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\shakeitoff.mid");

        // Opens the device, indicating that it should now acquire any
  // system resources it requires and become operational.
        sequencer.open();
        // create a stream from a file

        InputStream is = new BufferedInputStream(new FileInputStream(midiFile));
        InputStream is2 = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\yes-roundabout.mid")));
     
        bfis.add(is);
        bfis.add(is2);
        
        
     // Sets the current sequence on which the sequencer operates
        // The stream must point to MIDI file data
        sequencer.setSequence((InputStream) bfis.get(1));
        // Starts playback of the MIDI data in the currently loaded sequence.
        sequencer.start();
        
        

 

    }


}

