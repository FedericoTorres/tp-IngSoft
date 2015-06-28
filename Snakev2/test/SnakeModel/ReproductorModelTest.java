package SnakeModel;

import Libro.BPMObserver;
import Libro.BeatObserver;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Sequence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReproductorModelTest {
    
    private ReproductorModel reproductorModel;
    
    public ReproductorModelTest() {
    }
    
    @Before
    public void setUp() {
        try {
            reproductorModel = new ReproductorModel();
        } catch (Exception ex) {
        }
    }
    
    @Test
    public void testNextSong() {
        reproductorModel.nextSong();
        assertSame(reproductorModel.bfis.get(1), reproductorModel.sequencer.getSequence());
    } 
    
    @Test
    public void testPreviousSong() {
        reproductorModel.nextSong();
        reproductorModel.previousSong();
        assertSame(reproductorModel.bfis.get(0), reproductorModel.sequencer.getSequence());
    }
    
    @Test
    public void testOn() {
        reproductorModel.on();
        assertTrue(reproductorModel.sequencer.isRunning());
    }
    
    @Test
    public void testStop() {
        reproductorModel.on();
        reproductorModel.stop();
        assertFalse(reproductorModel.sequencer.isRunning());
    }
    
    @Test
    public void testPreviousSongLimiteInferior() {
        reproductorModel.previousSong();
        assertSame(reproductorModel.bfis.get(3), reproductorModel.sequencer.getSequence());
    }
    
    @Test
    public void testNextSongLimiteSuperior() {
        reproductorModel.nextSong();
        reproductorModel.nextSong();
        reproductorModel.nextSong();
        reproductorModel.nextSong();
        assertSame(reproductorModel.bfis.get(0), reproductorModel.sequencer.getSequence());
    }
}