package mundo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRocnes {
	
	Rocnes c;
    Vanilla v;
	
	@Before
    public void setup() {
		 c = new Rocnes(0);
		 v = new Vanilla(5);
    }
    
    @Test
    public void testAtaqueFueraRango() {
    	v = new Vanilla(10);
        c.atacar(v);
        Assert.assertEquals(100, v.saludActual);
    }
    
    @Test
    public void testAtaqueEnRango() {
        c.atacar(v);
        Assert.assertEquals(19,v.saludActual);
    }
    
    @Test
    public void testAtaque3() {
    	Vanilla v2 = new Vanilla(5);
    	Vanilla v3 = new Vanilla(5);
        c.atacar(v);
        c.atacar(v2);
        c.atacar(v3);
        
        Assert.assertEquals(50,v3.saludActual);
    }

    @Test
    public void testRecibirAtaque() {
        v.atacar(c);
        Assert.assertEquals(118 - 10 * 2,c.saludActual);
    }

    @Test
    public void testDescansar() {
        c.descansar();
        Assert.assertEquals(2, c.getCantidadAtaquesBuffeados());
    }
	
	
}
