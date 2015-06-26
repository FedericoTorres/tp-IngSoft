package Snake.SnakeModel;

public class Celda extends Cuadrado 
{
    private boolean libre;

    public Celda(int x, int y) 
    {
        super(x, y);
        
        libre = true;
    }

    public boolean isLibre() 
    {
        return libre;
    }

    public void setLibre(boolean libre) 
    {
        this.libre = libre;
    }
}
