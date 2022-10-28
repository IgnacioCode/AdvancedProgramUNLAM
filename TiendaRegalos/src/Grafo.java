import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Grafo {
	
	private List<Nodo> nodos = new LinkedList<Nodo>();
	private int[][] adyacentes;
	private Map<Nodo,Integer> indices = new LinkedHashMap<Nodo,Integer>();
	
	public Grafo(List<Nodo> nodos, int[][] adyacentes) {
		
		super();
		if(nodos.size() != adyacentes.length)
			throw new IndexOutOfBoundsException("La cantidad de nodos y la dim de la matriz no es la misma");
		this.nodos = nodos;
		this.adyacentes = adyacentes;
		int c = 0;
		for (Nodo n : nodos) {
			indices.put(n, c);
			c++;
		}
		
		for (Nodo n : nodos) {
			int index = indices.get(n);
			for (int i = 0; i < adyacentes[index].length; i++) {
				if(adyacentes[index][i] == 1)
					n.addCantAdyacentes();
			}
			
		}
		
		
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public int[][] getAdyacentes() {
		return adyacentes;
	}

	public Map<Nodo, Integer> getIndices() {
		return indices;
	}
	
	
	
}
