 import java.io.IOException;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Grafo miGrafo = GestionArchivo.leerArchivo("enunciado.in"); //O(N)
		Set<Integer> posiblesOrigenes = miGrafo.calculaPosibleOrigen();
		GestionArchivo.escribeArchivo("enunciado.out", posiblesOrigenes);
		
	}
}
