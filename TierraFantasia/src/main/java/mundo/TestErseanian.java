package mundo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestErseanian {
	
	Erseanian c;
	Vanilla v;
	
	@Before
    public void setup() {
		 c = new Erseanian(0);
		 v = new Vanilla(5);
    }
    
    @Test
    public void testAtaqueFueraRango() {
    	v = new Vanilla(10);
        c.atacar(v);
        Assert.assertEquals(100,v.saludActual);
    }
    
    @Test
    public void testAtaqueEnRango() {
        v.atacar(c); //53
    	c.atacar(v);
        Assert.assertEquals(1,v.saludActual); // 54
        Assert.assertEquals(54, c.saludActual);
    }

    @Test
    public void testRecibirAtaque() {
        v.atacar(c);
        Assert.assertEquals( 63 - 10,c.saludActual);
        Assert.assertEquals(99, c.danioActual);
    }

	
}
