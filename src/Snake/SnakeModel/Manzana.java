package Snake.SnakeModel;

public class Manzana extends Cuadrado 
{
    private final int puntaje;
    private final int crecimiento;
    private int tiempo;

    public Manzana(int puntaje, int crecimiento, int tiempo, int x, int y) 
    {
            super(x, y);

            this.puntaje = puntaje;
            this.crecimiento = crecimiento;
            this.tiempo = tiempo;
    }

    public void disminuirTiempo()
    {
            if(tiempo > 0)
                tiempo--;
    }

    public boolean quedaTiempo() 
    {
        return tiempo > 0 || tiempo == -1;
    }

    public int getPuntaje() 
    {
        return puntaje;
    }

    public int getCrecimiento() 
    {
        return crecimiento;
    }

    public void setTiempoEnCero() 
    {
        tiempo = 0;
    }
}
