import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class TestEquipo {
	@Test
	public void prueba_fatiga() throws IOException {
		creaArchivoFatiga();
		Equipo miEquipo = GestionArchivo.leerArchivo("fatiga.in");
		miEquipo.calculaAfinidad();
		GestionArchivo.escribeArchivo("fatiga.out", miEquipo);
		Assert.assertEquals(1_250_000_000, miEquipo.getAfinidad());
	}

	private void creaArchivoFatiga() throws IOException {
		
		FileWriter escritor = new FileWriter(new File("fatiga.in"));
		
		escritor.write(String.format("500\n"));
		escritor.write(String.format("5000\n"));
		
		for (int i = 0; i < 5000; i++) {
			escritor.write(String.format("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n"));
		}
		
		escritor.close();
		
	}
}
