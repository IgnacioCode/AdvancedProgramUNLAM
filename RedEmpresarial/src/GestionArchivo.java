import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GestionArchivo {

	public static Grafo leerArchivo(String FileIn) throws IOException { //O(A)
		
		Scanner l = new Scanner(new File(FileIn));
		Map<String,Integer> indices = new LinkedHashMap<String,Integer>();
		Map<Integer,String> nombres = new LinkedHashMap<Integer,String>();
		List<Arista> aristas = new LinkedList<Arista>();
		
		final int inf = Integer.MAX_VALUE;
		int cantAristas = l.nextInt();
		
		int cantNodos = 0;
		
		for (int i = 0; i < cantAristas; i++) {
			String origen = l.next();
			String destino = l.next();
			
			if(!indices.keySet().contains(origen)) {
				indices.put(origen, cantNodos);
				nombres.put(cantNodos,origen);
				cantNodos++;
			}
			
			if(!indices.keySet().contains(destino)) {
				indices.put(destino, cantNodos);
				nombres.put(cantNodos,destino);
				cantNodos++;
			}
			
			aristas.add(new Arista(origen,destino));
			
		}
		int[] infAux = new int[cantNodos];
		int[][] adyacentes = new int[cantNodos][cantNodos];
		
		for (int i = 0; i < infAux.length; i++) {
			infAux[i] = inf;
		}
		
		for (int i = 0; i < adyacentes.length; i++) {
			adyacentes[i] = infAux.clone();
		}
		
		for (Arista a : aristas) {
			int indOrigen = indices.get(a.getOrigen());
			int indDest = indices.get(a.getDestino());
			
			adyacentes[indOrigen][indDest] = 1;
			adyacentes[indDest][indOrigen] = 1;
		}
		
		
		l.close();
		return new Grafo(adyacentes,nombres,indices);
	}
	
	public static void escribeArchivo(String FileOut,int valMax,Set<String> s) throws IOException {
		FileWriter e = new FileWriter(new File(FileOut));
		
		e.write(String.format(valMax+"\n"));
		for (String string : s) {
			e.write(String.format(string+"\n"));
		}
		
		e.close();
	}
}
