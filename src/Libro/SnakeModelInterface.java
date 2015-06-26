package Libro;

import java.io.IOException;
import java.io.InputStream;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;

public interface SnakeModelInterface 
{
    void on();
    void stop();
    void addSong(Sequence inpS);
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);

    public void nextSong() ;
    public void previousSong();
}
