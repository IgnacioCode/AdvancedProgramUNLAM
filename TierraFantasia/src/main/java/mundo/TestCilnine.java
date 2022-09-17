package mundo;

import org.junit.*;


public class TestCilnine {
    Cilnine c;
    Vanilla v;
    
    @Before
    public void setup() {
        c = new Cilnine(0);
        v = new Vanilla(10);
    }
    
    @Test
    public void testAtaqueFueraRango() {
        c.atacar(v);
        Assert.assertEquals(100,v.saludActual);
    }
    
    @Test
    public void testAtaqueEnRango() {
    	v = new Vanilla(22);
        c.atacar(v);
        Assert.assertEquals(34,v.saludActual);
    }
    
    @Test
    public void testSumaAtaques() {
    	v = new Vanilla(22);
    	Vanilla v2 = new Vanilla(22);
    	Vanilla v3 = new Vanilla(22);
        c.atacar(v);
        c.atacar(v2);
        c.atacar(v3);
        
        Assert.assertEquals( 30,v3.saludActual);
    }

    @Test
    public void testRecibirAtaque() {
        v.atacar(c);
        Assert.assertEquals( 76 - 10 * 2 / 3,c.saludActual);
    }

    @Test
    public void testDescansar() {
        c.saludActual = 10;
        c.descansar();
        Assert.assertEquals( 43,c.saludActual);
        Assert.assertFalse(c.isPuedeAtacar());
        Assert.assertEquals( 76 + 33,c.saludMaxima);
    }

} 
