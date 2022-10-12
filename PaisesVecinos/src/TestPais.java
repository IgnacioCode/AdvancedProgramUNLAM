import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestPais {
	
	@Test
	public void prueba_fatiga() throws IOException {
		creaArchivoFatiga();
		Map<String,Set<String>> paises = GestionArchivo.leerArchivo("fatiga.in"); // O(n)
		List<Pais> listaP = new LinkedList<Pais>(); //O(1)
		
		for (String llave : paises.keySet()) { //O(n)
			listaP.add(new Pais(llave,paises.get(llave)));
		}
		
		System.out.println("--------------------------------");
		
		for (Pais pais : listaP) { // O(n^2)
			pais.calculaTransLimitrofes(paises); // O(n)
			System.out.println(pais.getNombre()+": "+pais.getTransLimitrofes());
		}
		
		GestionArchivo.escribeArchivo("fatiga.out",listaP); //O(n^2)
	}

	private void creaArchivoFatiga() throws IOException {
		FileWriter escritor = new FileWriter(new File("fatiga.in"));
		
		escritor.write(String.format(40_000+"\n"));
		
		for (int i = 1; i <= 1000; i++) {
			escritor.write(String.format(i + " "+ (i+1) + "\n"));
		}
		/*
		for (int i = 1; i <= 19_999; i++) {
			escritor.write(String.format("A "+ i + "\n"));
		}
		
		escritor.write(String.format(19_999 + " "+ 1 + "\n"));
		*/
		
		escritor.close();
	}
}
