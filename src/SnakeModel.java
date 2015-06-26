
import java.io.BufferedInputStream;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiFileFormat;

 

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;

import javax.sound.midi.Sequencer;

 

public class SnakeModel implements SnakeModelInterface {
    
    Sequencer sequencer;
    ArrayList   bfis;
    int indexOfSong = 0;
    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    private  int songsCounter = 0;
    
    public SnakeModel() throws Exception
    {
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        bfis = new ArrayList();
        this.defaultList();
        sequencer.setSequence((Sequence) bfis.get(0));
    }
    
    public int getSongsCounter()
    {
        return songsCounter;
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
        File file1 = new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\yes-roundabout.mid");
        File file2 = new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\shakeitoff.mid");
        File file3 = new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\articmonkeys.mid");
        File file4 = new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\muse.mid");


        try {
            // MidiFileFormat mff1 = MidiSystem.getMidiFileFormat(file1);
            Sequence s1=MidiSystem.getSequence(file1);
            Sequence s2=MidiSystem.getSequence(file2);
            Sequence s3=MidiSystem.getSequence(file3);
            Sequence s4=MidiSystem.getSequence(file4);
            this.addSong(s1);
            this.addSong(s2);
            this.addSong(s3);
            this.addSong(s4);
            
            //Es mejor trabajar con sequences, no hay errores de casteo.
            
            /*
            InputStream is = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\yes-roundabout.mid")));
            this.addSong(is);
            InputStream is2 = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\shakeitoff.mid")));
            this.addSong(is2);
            InputStream is3 = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\muse.mid")));
            this.addSong(is3);
            InputStream is4 = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\articmonkeys.mid")));
            this.addSong(is4);
            songsCounter = 4;
            
        */  } catch (InvalidMidiDataException ex) {
            Logger.getLogger(SnakeModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SnakeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void addSong(Sequence inpS)
    {
        bfis.add(inpS);
        this.songsCounter = this.songsCounter + 1;
    }
    
    @Override
    public void nextSong()
    {
        int cont = bfis.indexOf(sequencer.getSequence());
        System.out.println(cont);
        if(cont < 3)
            {
            try {
                sequencer.setSequence((Sequence) bfis.get(cont+1));
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(SnakeModel.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se pudo leer el Midi");
            }
            }
        else
        {
            System.out.println("Te pasaste de rosca");
        }
  
    }
    
        @Override
    public void previousSong() {
        int cont = bfis.indexOf(sequencer.getSequence());
        System.out.println(cont);
        if(cont>0)
        {
            try {
                sequencer.setSequence((Sequence)bfis.get(cont-1));
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(SnakeModel.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se pudo leer el Midi");
            }
            
        }
        else
        {
            System.out.println("Te pasaste de Rosca");
        }
                  
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        	int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
    }

    public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}
    
    
    
    
   public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}

    
    @Override
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
    
    }


    
    
    
    
    
    
    
}

