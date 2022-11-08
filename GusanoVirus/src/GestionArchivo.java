import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GestionArchivo {
	
	public static Grafo leerArchivo(String FileIn) throws IOException {	// O(A) 
		

		Scanner lector = new Scanner(new File(FileIn));
		
		int cantEnlaces = lector.nextInt();
		int cantNodos = 1;
		
		for (int i = 0; i < cantEnlaces; i++) { // O(A)
			int origen = lector.nextInt();
			int peso = lector.nextInt();
			int destino = lector.nextInt();
			
			cantNodos = Math.max(cantNodos, Math.max(origen, destino));
		}
		
		lector.close();
		Scanner lector2 = new Scanner(new File(FileIn));
		
		int[][] nodos = new int[cantNodos][cantNodos];
		Set<Nodo> setNodos = new LinkedHashSet<Nodo>();
		Map<Nodo,Integer> infectados = new LinkedHashMap<Nodo,Integer>();
		Map<Nodo,Integer> indices = new LinkedHashMap<Nodo,Integer>();
		Map<Integer,Nodo> nodosMapa = new LinkedHashMap<Integer,Nodo>();
		
		lector2.next();
		// N --> Cantidad de Nodos
		// O(sqrt(A))
		for (int i = 0; i < cantNodos; i++) {	// O(sqrt(A))
			Nodo n = new Nodo(i+1);
			setNodos.add(n);
			indices.put(n, i);
			nodosMapa.put(i, n);
		}
		
		for (int i = 0; i < cantEnlaces; i++) {	// O(A)
			int origen = lector2.nextInt();
			int peso = lector2.nextInt();
			int destino = lector2.nextInt();
			
			nodos[origen-1][destino-1] = peso;
			nodos[destino-1][origen-1] = peso;
		}
		
		int cantInfectados = lector2.nextInt();
		
		for (int i = 0; i < cantInfectados; i++) {	// O(sqrt(A))
			
			int infec = lector2.nextInt();
			int tiempo = lector2.nextInt();
			
			infectados.put(new Nodo(infec), tiempo);
			
		}
		
		for (int i = 0; i < nodos.length; i++) {	// O(sqrt(A))
			for (int j = 0; j < nodos[0].length; j++) {
				if(nodos[i][j]==0)
					nodos[i][j] = Integer.MAX_VALUE;
			}
		}
		
		return new Grafo(setNodos, nodos, infectados, indices, nodosMapa);
		
	}
}
