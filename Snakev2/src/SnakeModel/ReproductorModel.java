package SnakeModel;

import Libro.BeatObserver;
import Libro.BPMObserver;


import java.io.File;

import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;

 

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

import javax.sound.midi.Sequencer;

 

public class ReproductorModel implements ReproductorModelInterface {
    
    Sequencer sequencer;
    ArrayList   bfis;
    int indexOfSong = 0;
    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    private  int songsCounter = 0;

    
    public ReproductorModel() throws Exception
    {
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        bfis = new ArrayList();
        this.defaultList();
        sequencer.setSequence((Sequence) bfis.get(0));
        sequencer.setLoopCount(10);
    }
    
    public int getSongsCounter()
    {
        return songsCounter;
    }
    
 
  
    public void on()
    {
        sequencer.start();
        notifyBeatObservers();
        notifyBPMObservers();
    }
    
    public void stop()
    {
        sequencer.stop();
        notifyBeatObservers();
        notifyBPMObservers();
    }

    private void defaultList() {
        File file1 = new File(getClass().getResource("Sonic1.mid").getFile());
        File file2 = new File(getClass().getResource("Sonic2.mid").getFile());
        File file3 = new File(getClass().getResource("evangelion.mid").getFile());
        File file4 = new File(getClass().getResource("smwwd1.mid").getFile());
        File file5 = new File(getClass().getResource("PowerRangers.mid").getFile());
        File file6 = new File(getClass().getResource("Contra1.mid").getFile());
        File file7 = new File(getClass().getResource("Dragonborn.mid").getFile());

        try {
            // MidiFileFormat mff1 = MidiSystem.getMidiFileFormat(file1);
            Sequence s1=MidiSystem.getSequence(file1);
            Sequence s2=MidiSystem.getSequence(file2);
            Sequence s3=MidiSystem.getSequence(file3);
            Sequence s4=MidiSystem.getSequence(file4);
            Sequence s5=MidiSystem.getSequence(file5);
            Sequence s6=MidiSystem.getSequence(file6);
            Sequence s7=MidiSystem.getSequence(file7);
            this.addSong(s1);
            this.addSong(s2);
            this.addSong(s3);
            this.addSong(s4);
            this.addSong(s5);
            this.addSong(s6);
            this.addSong(s7);

            
            //Es mejor trabajar con sequences, no hay errores de casteo.
            
            /*

        */  } catch (InvalidMidiDataException ex) {
            Logger.getLogger(ReproductorModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReproductorModel.class.getName()).log(Level.SEVERE, null, ex);
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
        if(cont < 6)
            {
            try {
                sequencer.setSequence((Sequence) bfis.get(cont+1));
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(ReproductorModel.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se pudo leer el Midi");
            }
            
            notifyBeatObservers();
            notifyBPMObservers();
            }
        else
        {
            System.out.println("No mas temas");
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
                Logger.getLogger(ReproductorModel.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se pudo leer el Midi");
            }
            
            notifyBeatObservers();
            notifyBPMObservers();
        }
        else
        {
            System.out.println("No mas temas");
        }
                  
    }
    
    public int getTempo()
    {
        return (int)sequencer.getTempoInBPM();
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

