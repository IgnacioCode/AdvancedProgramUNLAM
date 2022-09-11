import org.junit.Test;
import junit.framework.Assert;

public class FedeTests {
	
	@Test //Annotation --> descriptor semantico, sirve para que eclipse interprete este codigo para las pruebas
	public void saludoSimple() {
		// Arrange --> preparar un escenario
		Fede miFede = new Fede();
		// Act	--> hacer la prueba
		String saludo = miFede.saludar();
		// Assert --> verificar que la salida fue correcta
		Assert.assertEquals("Hola!",saludo);
		// Annihilate
		miFede = null;
	}
	
	@Test
	public void saludoConNomrbe() {
		Fede miFede = new Fede();
		
		String saludo = miFede.saludar("Franco");
		Assert.assertEquals("Hola, Franco!",saludo);

	}
	
	@Test
	public void saludoNombreVacio() {
		Fede miFede = new Fede();
		String saludo = miFede.saludar(" ");
		
		Assert.assertEquals("Hola!",saludo);
	}
	
}

