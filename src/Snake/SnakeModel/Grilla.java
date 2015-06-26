package Snake.SnakeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grilla 
{
    private Celda[][] grilla;
    private List<Manzana> manzanas;
    private int ancho;
    private int alto;

    public Grilla(int ancho, int alto) 
    {
        this.ancho = ancho;
        this.alto = alto;
        inicializarGrilla();
        inicializarManzanas();
    }
    
    public int getAncho() 
    {
        return ancho;
    }

    public int getAlto() 
    {
        return alto;
    }

    public Manzana getManzana(int x, int y) 
    {
        if(!isLibre(x, y))
            return null;
   
        for(Manzana manzana : manzanas) 
        {
            if(manzana.getX() == x && manzana.getY() == y) 
                return manzana;
        }
        
        return null;
    }

    public boolean isLibre(int x, int y) 
    {
        if(isFueraDeGrilla(x, y))
            return false;
        else
            return grilla[x][y].isLibre();
    }

    public boolean sinManzanas() 
    {
        return manzanas.isEmpty();
    }

    private void inicializarGrilla() 
    {
        grilla = new Celda[ancho][alto];
        
        for(int i = 0; i < ancho; i++) 
        {
            for(int j = 0; j < alto; j++)
                 grilla[i][j] = new Celda(i, j);                     
        }
    }

    public void setLimites() 
    {
        for (int i = 0; i < ancho; i++) 
        {
            grilla[i][0].setLibre(false);
            grilla[i][alto - 1].setLibre(false);
        }

        for (int j = 0; j < alto; j++) 
        {
            grilla[0][j].setLibre(false);
            grilla[ancho - 1][j].setLibre(false);
        }
    }

    private void inicializarManzanas() 
    {
        manzanas = new ArrayList<>();
    }

    public void agregarManzana(Manzana manzana) 
    {
        manzanas.add(manzana);
    }

    public void agregarManzana(int puntaje, int crecimiento, int tiempo, 
                               Snake snake) 
    {
        Random r = new Random();
        boolean agregado = false;
        
        // TODO it is not guaranteed that this loop will ever end
        while(!agregado) 
        {
            int x = r.nextInt(ancho);
            int y = r.nextInt(alto);
            
            if(isLibre(x, y) && !snake.estaEn(x, y) && getManzana(x, y) == null) 
            {
                manzanas.add(new Manzana(puntaje, crecimiento, tiempo, x, y));
                
                agregado = true;
            }
        }
    }

    private boolean isFueraDeGrilla(int x, int y) 
    {
        return x < 0 || y < 0 || x > ancho - 1 || y > alto - 1;
    }

    public void actualizarManzanas() 
    {
        for(Manzana manzana : manzanas)
        {
            manzana.disminuirTiempo();
            
            if(!manzana.quedaTiempo())
                manzanas.remove(manzana);
        }
    }

    @Override
    public String toString() 
    {
       StringBuilder sb = new StringBuilder();

       for(int j = 0; j < alto; j++) 
       {
            for(int i = 0; i < ancho; i++) 
            {
                if(grilla[i][j].isLibre()) 
                {
                    if(getManzana(i, j) != null) 
                        sb.append('*');
                    else
                        sb.append(' ');
                } 
                else
                    sb.append('#');
            }
            sb.append('\n');
        }
       
        return sb.toString();
    }
}
