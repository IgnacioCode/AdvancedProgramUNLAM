import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private int[][] adyacentes;
	private Map<Integer,Integer> infectados;
	private Set<Integer> posiblesOrigenes;
	final int inf = Integer.MAX_VALUE;
	

	public Grafo(int[][] adyacentes, Map<Integer,Integer> infectados) {
		super();
		this.adyacentes = adyacentes;
		this.infectados = infectados;
		this.posiblesOrigenes = new LinkedHashSet<Integer>();
		for (int i = 0; i < adyacentes.length; i++) {
			posiblesOrigenes.add(i+1);
		}
	}

	public int[][] getAdyacentes() {
		return adyacentes;
	}
	
	public int[] calculaDijkstra(int inicio){//O(N2)
		
		Set<Integer> S = new HashSet<Integer>();
		Set<Integer> V_S = new HashSet<Integer>();
		int[] D = new int[adyacentes.length];
		
		for (int i = 0; i < D.length; i++) {
			V_S.add(i);
		}
		
		S.add(inicio-1);
		//V_S.addAll(infectados.keySet());
		V_S.remove(inicio-1);
		
		D = adyacentes[inicio-1].clone();
		
		while(!V_S.isEmpty()){ //O(N2)
			
			int w = buscaMinimo(D,V_S); //O(N)
			if(V_S.contains(w))
				V_S.remove(w);
			S.add(w);
			
			for (int i = 0; i < D.length; i++) { //O(N)
				if(adyacentes[w][i]!=inf)
					D[i] = Math.min(D[i],D[w]+adyacentes[w][i]);
			}
			
		}
		
		return D;
	}
	
	private int buscaMinimo(int[] d, Set<Integer> v_S) {
		int valMin = Integer.MAX_VALUE;
		int posMin = 0;
		
		for (int i = 0; i < d.length; i++) {
			if(d[i]<=valMin && v_S.contains(i)){
				valMin = d[i];
				posMin = i;
			}
				
		}
		
		return posMin;
	}

	public Set<Integer> calculaPosibleOrigen(){
		// I = DATOS DE INFECTADOS
		//O(I)
		for (int infecActual : infectados.keySet()) {
			
			int tiempo = infectados.get(infecActual);
			int[] res = calculaDijkstra(infecActual); //O(N2)
			
			for (int i = 0; i < res.length; i++) {	//O(N)
				if(res[i]!=tiempo)
					posiblesOrigenes.remove(i+1);
			}
			
			if(posiblesOrigenes.size()==1)
				break;
			
			
		}
		
		
		
		return posiblesOrigenes;
	}
	
}
