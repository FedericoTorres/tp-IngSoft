
import java.io.BufferedInputStream;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import javax.sound.midi.InvalidMidiDataException;

 

import javax.sound.midi.MidiSystem;

import javax.sound.midi.Sequencer;

 

public class SnakeModel {
    
    Sequencer sequencer;
    ArrayList   bfis;
    int indexOfSong = 0;
    
    public SnakeModel() throws Exception
    {
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        bfis = new ArrayList();
        this.defaultList();
        sequencer.setSequence((InputStream) bfis.get(0));
    }
 
    
    /*

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
    */
    public void on()
    {
        sequencer.start();
    }
    
    public void stop()
    {
        sequencer.stop();
    }

    private void defaultList() {
        
        try
            {
        
        InputStream is = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\yes-roundabout.mid")));
        this.addSong(is);
        InputStream is2 = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\shakeitoff.mid")));
        this.addSong(is2);
        InputStream is3 = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\muse.mid")));
        this.addSong(is3);
        InputStream is4 = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\articmonkeys.mid")));
        this.addSong(is4);
        
            }
        catch(FileNotFoundException o)
         {
             System.out.println("Cancion no localizada");
         }
    }
    
    private void addSong(InputStream inpS)
    {
        bfis.add(inpS);
    }
    
    public void nextSong() throws IOException, InvalidMidiDataException
    {
        int contador = bfis.indexOf(sequencer.getSequence());
        int externa = bfis.size();
        if (externa - 1 == contador)
        {
            sequencer.setSequence((InputStream)bfis.get(0));
        }
        else
        {
            sequencer.setSequence((InputStream)bfis.get(contador + 1));
        }
    }
    
    
    
    
    
    
    
}

