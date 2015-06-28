package SnakeModel;

import Libro.BeatModelInterface;
import Libro.BeatObserver;
import Libro.BPMObserver;

public class ReproductorAdapter implements BeatModelInterface 
{
    ReproductorModelInterface reproductor;
    
    public ReproductorAdapter(ReproductorModelInterface snake)
    {
        this.reproductor = snake;
    }
    
    public void initialize() {}
    
    public void on()
    {
        reproductor.on();
    }
    
    public void off()
    {
        reproductor.stop();
    }
    
    public int getBPM() 
    {
        return 0;
    }
    
    public void setBPM(int bpm) {}
    
    public void registerObserver(BeatObserver o) 
    {
	reproductor.registerObserver(o);
    }
    
    public void removeObserver(BeatObserver o) 
    {
	reproductor.removeObserver(o);
    }
     
    public void registerObserver(BPMObserver o) 
    {
	reproductor.registerObserver(o);
    }
  
    public void removeObserver(BPMObserver o) 
    {
	reproductor.removeObserver(o);
    }
    
}