import java.io.InputStream;

public interface SnakeModelInterface 
{
    void on();
    void stop();
    void addSong(InputStream inpS);
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
}
