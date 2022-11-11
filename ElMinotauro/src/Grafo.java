import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Grafo {
	
	private List<List<Arista>> adyacentes;
	private Set<Nodo> nodos;
	
	public Grafo(List<List<Arista>> adyacentes, Set<Nodo> nodos) {
		super();
		this.adyacentes = adyacentes;
		this.nodos = nodos;
	}
	
	public Grafo calculaKruskal() {
		
		List<Arista> listaAristasCreciente = new LinkedList<Arista>();	// Lista de Costos crecientes
		
		//Parametros del nuevo grafo
		List<List<Arista>> nuevasUniones = new ArrayList<List<Arista>>();
		Set<Nodo> nuevosNodos = new LinkedHashSet<Nodo>();
		nuevosNodos.addAll(nodos);

		UnionFind uf = new UnionFind(nodos.size());
		
		for (int i = 0; i < nodos.size(); i++) {
			List<Arista> l = new LinkedList<Arista>();
			nuevasUniones.add(l);
		}
		
		for (List<Arista> l : adyacentes) {
			listaAristasCreciente.addAll(l);
		}
		
		listaAristasCreciente.sort(null);
		
		System.out.println(listaAristasCreciente);
		int i = 0;
		int costoAcum = 0;
		while(i>nodos.size()-1 || !listaAristasCreciente.isEmpty()) {
			
			Arista a = listaAristasCreciente.get(0);
			
			boolean estanConectados = uf.mismoRepresentante(a.getOrigen(), a.getDestino());
			
			if(!estanConectados) {
				uf.union(a.getOrigen(), a.getDestino());
				nuevasUniones.get(a.getOrigen()-1).add(a);
				costoAcum += a.getPeso();
			}
			else {
				i--;
			}
			
			listaAristasCreciente.remove(a);
			i++;
		}
		System.out.println(costoAcum);
		return new Grafo(nuevasUniones,nuevosNodos);
		
	}
	
	public void verListaAristas() {
		for (List<Arista> list : adyacentes) {
			System.out.println(list);
			System.out.println();
		}
	}
}
