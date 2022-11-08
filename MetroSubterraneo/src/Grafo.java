import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	List<Nodo> nodos = new LinkedList<Nodo>();
	int[][] adyacentes;
	Map<Nodo,Integer> indices = new LinkedHashMap<Nodo,Integer>();
	
	public Grafo(List<Nodo> nodos, int[][] adyacentes) { //O(n^2)
		
		super();
		if(nodos.size() != adyacentes.length)
			throw new IndexOutOfBoundsException("La cantidad de nodos y la dim de la matriz no es la misma");
		this.nodos = nodos;
		this.adyacentes = adyacentes;
		
		for (Nodo n : nodos) { //O(n)
			indices.put(n, indices.size());
		}
		
		for (Nodo n : nodos) { //O(n^2)
			int index = indices.get(n);
			for (int i = 0; i < adyacentes[index].length; i++) { //O(n)
				if(adyacentes[index][i] == 1)
					n.addCantAdyacentes();
			}
			
		}
		
		
	}
	
	public int puentesNecesarios() {
		
		List<Set<Nodo>> bosque = new LinkedList<Set<Nodo>>();
		
		for (Nodo n : nodos) {
			Set<Nodo> nuevo = new LinkedHashSet<Nodo>();
			nuevo.add(n);
			bosque.add(nuevo);
		}
		int setEliminado = 0;
		int tamBosque = bosque.size();
		
		
		for (int i = 0; i < bosque.size(); i++) {
			Set<Nodo> actual = bosque.get(i - setEliminado);
			Nodo nodoActual = nodos.get(i);
			
			for (int j = i+1; j < nodos.size(); j++) {
				if(areConnected(nodoActual,nodos.get(j))) {
					Set<Nodo> setABorrar = bosque.get(j - setEliminado);
					actual.addAll(setABorrar);
					bosque.remove( j - setEliminado);
					setEliminado++;
				}
				else {
					
				}
			}
		}
		
		return bosque.size()-1;
		
	}
	
	private boolean areConnected(Nodo n1,Nodo n2) {
		
		int index1 = indices.get(n1);
		int index2 = indices.get(n2);
		
		if(adyacentes[index1][index2] == 1)
			return true;
		
		return false;
		
	}
	
	
}
