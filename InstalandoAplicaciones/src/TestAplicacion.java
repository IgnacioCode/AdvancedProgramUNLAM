import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class TestAplicacion {
	
	@Before
	public void crea_archivo_desgaste() throws IOException {
		FileWriter es = new FileWriter(new File("desgaste.in"));
		
		es.write(50_000 + " " + 1000);
		es.write(String.format("\n"));
		for (int i = 0; i < 50_000; i++) {
			es.write(1 +" ");
		}
		es.close();
	}
	
	@Test
	public void prueba_archivo_desgaste() throws IOException {
		Aplicacion.almacenamiento("desgaste.in");
	}
}
