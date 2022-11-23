import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.junit.Test;

public class TestMain {
	
	@Test
	public void caso01() throws IOException{
		
		Grafo miGrafo = GestionArchivo.leerArchivo("enunciado.in");
		Set<Integer> posiblesOrigenes = miGrafo.calculaPosibleOrigen();
		GestionArchivo.escribeArchivo("enunciado.out", posiblesOrigenes);
		
	}
	
	@Test
	public void caso02Fatiga() throws IOException{
		
		generaArchivoFatiga();
		
		Grafo miGrafo = GestionArchivo.leerArchivo("fatiga.in");
		Set<Integer> posiblesOrigenes = miGrafo.calculaPosibleOrigen();
		GestionArchivo.escribeArchivo("fatiga.out", posiblesOrigenes);
		
	}
	
	private void generaArchivoFatiga() throws IOException {
		FileWriter e = new FileWriter(new File("fatiga.in"));
		
		int cantEnlaces = 29890;
		e.write(String.format(cantEnlaces+"\n"));
		for (int i = 1; i < 245; i++) {
			for (int j = i+1; j <= 245; j++) {
				e.write(String.format(i + " 1 " + j+"\n"));
			}
		}
		
		int cantInfectados = 100;
		e.write(String.format(cantInfectados+"\n"));
		for (int i = 1; i <= cantInfectados; i++) {
			e.write(String.format(i + " 1 \n"));
		}
		e.close();
	}

	@Test
	public void caso03DirectoCompuesto() throws IOException{
		
		Grafo miGrafo = GestionArchivo.leerArchivo("caso03.in");
		Set<Integer> posiblesOrigenes = miGrafo.calculaPosibleOrigen();
		GestionArchivo.escribeArchivo("caso03.out", posiblesOrigenes);
		
	}
	
	@Test
	public void caso04CaminoLineal() throws IOException{
		
		Grafo miGrafo = GestionArchivo.leerArchivo("caso04.in");
		Set<Integer> posiblesOrigenes = miGrafo.calculaPosibleOrigen();
		GestionArchivo.escribeArchivo("caso04.out", posiblesOrigenes);
		
	}
	
	@Test
	public void caso05TodosPosibles() throws IOException{
		
		Grafo miGrafo = GestionArchivo.leerArchivo("caso05.in");
		Set<Integer> posiblesOrigenes = miGrafo.calculaPosibleOrigen();
		GestionArchivo.escribeArchivo("caso05.out", posiblesOrigenes);
		
	}
	
	@Test
	public void caso06NingunoPosible() throws IOException{
		
		Grafo miGrafo = GestionArchivo.leerArchivo("caso06.in");
		Set<Integer> posiblesOrigenes = miGrafo.calculaPosibleOrigen();
		GestionArchivo.escribeArchivo("caso06.out", posiblesOrigenes);
		
	}
	
}
