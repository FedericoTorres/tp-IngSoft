package Snake.SnakeModel;

public class ReproductorAdapter implements BeatModelInterface 
{
    ReproductorInterface snake;
    
    public ReproductorAdapter(ReproductorInterface snake)
    {
        this.snake = snake;
    }
    
    public void initialize() {}
    
    public void on()
    {
        snake.on();
    }
    
    public void off()
    {
        snake.stop();
    }
    
    public int getBPM() 
    {
        return 0;
    }
    
    public void setBPM(int bpm) {}
    
    public void registerObserver(BeatObserver o) 
    {
	snake.registerObserver(o);
    }
    
    public void removeObserver(BeatObserver o) 
    {
	snake.removeObserver(o);
    }
     
    public void registerObserver(BPMObserver o) 
    {
	snake.registerObserver(o);
    }
  
    public void removeObserver(BPMObserver o) 
    {
	snake.removeObserver(o);
    }
    
    
}
