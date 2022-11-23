import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GestionArchivo {
	public static Grafo leerArchivo(String FileIn) throws IOException{
		Scanner s2 = new Scanner(new File(FileIn));
		int cantAristas = s2.nextInt();
		int cantNodos = 0;
		for (int i = 0; i < cantAristas; i++) {
			int origen = s2.nextInt();
			int peso = s2.nextInt();
			int destino = s2.nextInt();
			if(origen>cantNodos)
				cantNodos = origen;
			if(destino>cantNodos)
				cantNodos = destino;
		}
		s2.close();
		Scanner s = new Scanner(new File(FileIn));
		int cantAristas2 = s.nextInt();
		final int inf = Integer.MAX_VALUE;
		int[][] adyacentes = new int[cantNodos][cantNodos];
		
		int[] infAux = new int[cantNodos];
		for (int i = 0; i < infAux.length; i++) {
			infAux[i] = inf;
		}
		
		for (int i = 0; i < infAux.length; i++) {
			adyacentes[i] = infAux.clone();
		}
		
		
		for (int i = 0; i <cantAristas2; i++) {
			int origen = s.nextInt();
			int peso = s.nextInt();
			int destino = s.nextInt();
			
			adyacentes[origen-1][destino-1] = peso;
			adyacentes[destino-1][origen-1] = peso;
		}
		
		int cantInfectados = s.nextInt();
		
		Map<Integer,Integer> infectados  = new LinkedHashMap<Integer,Integer>();
		
		for (int i = 0; i < cantInfectados; i++) {
			int nodo = s.nextInt();
			int tiempo = s.nextInt();
			infectados.put(nodo, tiempo);
		}
		
		s.close();
		return new Grafo(adyacentes,infectados);
	}
	
	public static void escribeArchivo(String FileOut,Set<Integer> s) throws IOException{
		FileWriter e = new FileWriter(new File(FileOut));
		
		for (Integer val : s) {
			e.write(String.format(val+ " \n"));
		}
		
		
		e.close();
	}
}
