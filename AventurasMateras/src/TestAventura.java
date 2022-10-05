import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;

public class TestAventura {
	
	@Test
	public void prueba_enunciado() throws IOException {
		Aventura.calculaSebador("enunciado1.in");
		
	}
	
	@Test
	public void prueba_enunciado2() throws IOException {
		Aventura.calculaSebador("enunciado2.in");
		
	}
	
	@Test
	public void prueba_estres() throws IOException {
		armaArchivoEstres();
		Aventura.calculaSebador("pruebaEstres.in");
	}

	private void armaArchivoEstres() throws IOException {
		FileWriter escritor = new FileWriter(new File("pruebaEstres.in"));
		Random rm = new Random();
		int valor = 400000;
		int limite = 100_000_000;
		escritor.write(valor + "");
		escritor.write(String.format("\n"));
		for(int i = 0;i<valor-1; i++) {
			//escritor.write(rm.nextInt(1, 1) + " ");
			escritor.write(0 + " ");
		}
		escritor.close();
	}
	
}
