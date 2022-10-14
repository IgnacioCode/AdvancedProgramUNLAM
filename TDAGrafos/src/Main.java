import java.util.LinkedHashMap;
import java.util.Map;

import grafo.ArrayGraph;
import grafo.Graph;

public class Main {
	public static void main(String[] args) {
		Map<String,Integer> indices = new LinkedHashMap<String,Integer>();
		indices.put("1",0);
		indices.put("2",1);
		indices.put("3",2);
		indices.put("4",3);
		indices.put("5",4);
		int inf = Integer.MAX_VALUE;
		/*
		int[][] conexiones = {{inf,3,4,4,inf},
							  {3,inf,inf,inf,3},
							  {4,inf,inf,inf,inf},
							  {4,inf,inf,inf,4},
							  {inf,3,inf,4,inf}};
		*/
		
		
		int[][] conexiones = {{inf,10,inf,30,100},
							  {inf,inf,50,inf,inf},
							  {inf,inf,inf,inf,10},
							  {inf,inf,20,inf,60},
							  {inf,inf,inf,inf,inf}};
		
		
		Graph<String> miGrafo = new ArrayGraph<String>(indices,conexiones);
		
		int[][] resultado = miGrafo.calculateDijkstra("5");
		for (int i = 0; i < resultado[0].length; i++) {
			System.out.print(resultado[0][i]+" ");
		}
		System.out.println();
		for (int i = 0; i < resultado[1].length; i++) {
			System.out.print(resultado[1][i]+" ");
		}
		System.out.println();
		System.out.println(miGrafo.size());
	}
}
