import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class GestionArchivo {
	
	public static Grafo leerArchivo(String FileIn) throws IOException, FaltanSegmentosException {
		Scanner lector = new Scanner(new File(FileIn));
		List<Segmento> listaSegmentos = new LinkedList<Segmento>();
		List<Integer> listaFinales = new LinkedList<Integer>();
		
		int cantSegmentos = lector.nextInt();
		int escenaFinal = lector.nextInt();
		int[][] adyacentes = new int[cantSegmentos][cantSegmentos];
		final int inf = Integer.MAX_VALUE;
		
		for (int i = 0; i < adyacentes.length; i++) {
			for (int j = 0; j < adyacentes.length; j++) {
				adyacentes[i][j] = inf;
			}
		}
		
		for (int i = 0; i < cantSegmentos; i++) {
			int id = lector.nextInt();
			int inicio = lector.nextInt();
			int fin = lector.nextInt();
			listaSegmentos.add(new Segmento(id,inicio,fin));
		}
		
		listaSegmentos.sort(null);
		boolean llegaAlFinal = false;
		
		for (int i = 0; i < listaSegmentos.size()-1; i++) {
			Segmento actual = listaSegmentos.get(i);
			int solapa = 0;
			boolean estaConectado = false;
			int j = i+1;
			while(j<listaSegmentos.size() && solapa >= 0 ) {
				Segmento siguiente = listaSegmentos.get(j);
				
				
				if(actual.getFin() == escenaFinal) {
					llegaAlFinal = true;
					listaFinales.add(actual.getId());
				}
				if(siguiente.getFin() == escenaFinal) {
					llegaAlFinal = true;
					listaFinales.add(siguiente.getId());
				}
				
				solapa = actual.diferencia(siguiente);
				if(solapa>=0) {
					estaConectado = true;
					adyacentes[actual.getId()-1][siguiente.getId()-1] = solapa;
				}
				j++;
			}
			if(!estaConectado)
				throw new FaltanSegmentosException("NO ES POSIBLE");
		}
		
		if(!llegaAlFinal)
			throw new FaltanSegmentosException("NO ES POSIBLE");
		
		
		
		lector.close();
		return new Grafo(adyacentes,listaFinales);
	}
	
	public static void escribeArchivo(String FileOut,Grafo g, int[][] res) throws IOException {
		
		FileWriter escritor = new FileWriter(new File(FileOut));
		Stack<Integer> p = new Stack<Integer>();
		
		int posMin = buscarMinimo(res[0],g.getNodosFinales());
		
		p.add(posMin+1);
		while(res[1][posMin] != 0) {
			
			p.add(res[1][posMin]+1);
			posMin = res[1][posMin];
		}
		
		p.add(res[1][posMin]+1);
		
		while(!p.isEmpty()) {
			escritor.write(p.pop()+" ");
		}
		
		escritor.close();
		
		
	}
	
	private	static int buscarMinimo(int[] d, List<Integer> v_S) {
		
		int valMin = Integer.MAX_VALUE;
		int posMin = 0;
		for (Integer i : v_S) {
			if(d[i-1]<valMin) {
				valMin = d[i-1];
				posMin = i-1;
			}
		}
		
		return posMin;
	}
	
}
