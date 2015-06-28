package Libro;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeartModelTest {
    
    private HeartModel heartModel;
    
    public HeartModelTest() {
    }
    
    @Before
    public void setUp() {
        heartModel = HeartModel.getInstancia();
    }
    
    @Test
    public void testNuevaInstancia()
    {
        HeartModel nuevoHeartModel = HeartModel.getInstancia();
        assertSame(heartModel, nuevoHeartModel);
    }  
}

