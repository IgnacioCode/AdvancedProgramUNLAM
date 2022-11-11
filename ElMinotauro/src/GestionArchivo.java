import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GestionArchivo {
	
	public static Grafo leerArchivo(String FileIn) throws IOException {//O(n^2)
		
		Scanner lector = new Scanner(new File(FileIn));
		
		int cantNodos = lector.nextInt();
		
		List<List<Arista>> adyacentes = new ArrayList<List<Arista>>();
		Set<Nodo> nodos = new LinkedHashSet<Nodo>();
		
		for (int i = 0; i < cantNodos; i++) {
			List<Arista> l = new LinkedList<Arista>();
			adyacentes.add(l);
		}
		
		for (int i = 0; i < cantNodos; i++) {
			int nodoOrigen = i+1;
			nodos.add(new Nodo(nodoOrigen));
			for (int j = 0; j < i; j++) {
				int nodoDestino = j+1;
				int peso = lector.nextInt();
				if(i!=j){
					adyacentes.get(i).add(new Arista(nodoOrigen,nodoDestino,peso));
				}	
			}
			for (int j = i; j < cantNodos; j++) {
				lector.nextInt();
			}
			
		}
		
		lector.close();
		return new Grafo(adyacentes,nodos);

	}
	
	
}
