import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionArchivo {
	
	public static Grafo leerArchivo(String FileIn) throws IOException {
		
		Scanner lector = new Scanner(new File(FileIn));
		List<Nodo> nodos = new LinkedList<Nodo>();
		
		int cantNodos = lector.nextInt();
		int[][] adyacentes = new int[cantNodos][cantNodos];
		
		int cantTuneles = lector.nextInt();
		lector.nextInt();
		
		for (int i = 0; i < cantNodos; i++) {
			nodos.add(new Nodo(i+1));
		}
		
		for (int i = 0; i < cantTuneles; i++) {
			int origen = lector.nextInt();
			int destino = lector.nextInt();
			
			adyacentes[origen-1][destino-1] = 1;
			adyacentes[destino-1][origen-1] = 1;
		}
		
		
		
		
		return new Grafo(nodos,adyacentes);
		
	}
	
}
