import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionArchivo {
	
	public static Grafo leeArchivo(String FileIn) throws IOException { //O(n^2)
		
		Scanner lector = new Scanner(new File(FileIn));
		int cantNodos = lector.nextInt();
		int[][] adyacentes = new int[cantNodos][cantNodos];
		List<Nodo> nodos = new LinkedList<Nodo>();
		
		for (int i = 0; i < cantNodos; i++) { // O(n^2)
			int id = lector.nextInt();
			
			do { //O(n)
				int leido = lector.nextInt();
				if(leido==-1)
					break;
				adyacentes[i][leido-1] = 1;
				adyacentes[leido-1][i] = 1;
			}while(true);
			
			nodos.add(new Nodo(id));
			
		}
		
		
		return new Grafo(nodos,adyacentes); //O(n^2)
		
	}
	
}
