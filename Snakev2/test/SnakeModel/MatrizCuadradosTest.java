package SnakeModel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrizCuadradosTest {
    
    private MatrizCuadrados matrizCuadrados;
    
    public MatrizCuadradosTest() {
    }
    
    @Before
    public void setUp() {
        matrizCuadrados = new MatrizCuadrados(20, 20);
    }
    
    @Test
    public void testNoEsRecorrible() {
        boolean esRecorrible = matrizCuadrados.esRecorrible(20, 19);
        assertFalse(esRecorrible);   
    }
    
    @Test
    public void testEsRecorrible() {
        boolean esRecorrible = matrizCuadrados.esRecorrible(19, 19);
        assertTrue(esRecorrible);
    }
}

