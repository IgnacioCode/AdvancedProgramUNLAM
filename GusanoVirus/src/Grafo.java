import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private Set<Nodo> nodos;
	private int[][] adyacentes;
	private Map<Nodo,Integer> infectados;
	private Map<Nodo,Integer> indices;
	private Map<Integer,Nodo> nodosMapa;

	

	public Grafo(Set<Nodo> nodos, int[][] adyacentes, Map<Nodo, Integer> infectados, Map<Nodo, Integer> indices,Map<Integer, Nodo> nodosMapa) {
		super();
		this.nodos = nodos;
		this.adyacentes = adyacentes;
		this.infectados = infectados;
		this.indices = indices;
		this.nodosMapa = nodosMapa;
	}

	public Set<Nodo> getNodos() {
		return nodos;
	}

	public int[][] getAdyacentes() {
		return adyacentes;
	}

	public Map<Nodo, Integer> getIndices() {
		return indices;
	}
	
	public Map<Nodo, Integer> getInfectados() {
		return infectados;
	}

	public Map<Integer, Nodo> getNodosMapa() {
		return nodosMapa;
	}

	public int[] calculaDijkstra(Nodo origen) { //O(A)
		
		Set<Nodo> S = new LinkedHashSet<Nodo>();
		Set<Nodo> V_S = new LinkedHashSet<Nodo>();
		int[] D = new int[nodos.size()];
		
		V_S.addAll(nodos);
		V_S.remove(origen);
		S.add(origen);
		
		int indexOrigen = indices.get(origen);
		
		for (int i = 0; i < D.length; i++) { //O(sqrt(A))
			D[i] = adyacentes[indexOrigen][i];
		}
		
		while(!V_S.isEmpty()) {	//O(A)
			
			int wMinimo = buscaMinimo(D,V_S); //O(sqrt(A))
			Nodo W = nodosMapa.get(wMinimo);
			V_S.remove(W);
			S.add(W);
			
			for (Nodo n : V_S) {	//O(sqrt(A))
				int indexActual = indices.get(n);
				if(adyacentes[wMinimo][indexActual] != Integer.MAX_VALUE) {
					D[indexActual] = Math.min(D[indexActual], D[wMinimo] + adyacentes[wMinimo][indexActual]);
				}
				
			}
			
		}
		
		
		
		return D;
		
	}

	private int buscaMinimo(int[] d, Set<Nodo> v_S) {
		int valMinimo = Integer.MAX_VALUE;
		int posMin = 0;
		
		for (Nodo nodo : v_S) {	//O(sqrt(A))
			int index = indices.get(nodo);
			if(d[index]<valMinimo) {
				valMinimo = d[index];
				posMin = index;
			}
		}
		return posMin;
	}
	
}
