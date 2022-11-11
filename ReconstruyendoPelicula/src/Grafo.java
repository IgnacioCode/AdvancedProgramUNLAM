import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	
	private int[][]	adyacentes;
	List<Integer> nodosFinales;
	final int inf = Integer.MAX_VALUE;

	

	public Grafo(int[][] adyacentes, List<Integer> nodosFinales) {
		super();
		this.adyacentes = adyacentes;
		this.nodosFinales = nodosFinales;
	}

	public int[][] calculaDijkstra(int inicio) {
		
		Set<Integer> S = new LinkedHashSet<Integer>();
		Set<Integer> V_S = new LinkedHashSet<Integer>();
		
		int[] D = new int[adyacentes.length];
		int[] P = new int[adyacentes.length];
		
		for (int i = 0; i < adyacentes.length; i++) {
			V_S.add(i+1);
		}
		
		for (int i = 0; i < adyacentes.length; i++) {
			D[i] = adyacentes[inicio-1][i];
			P[i] = inicio-1;
		}
		
		S.add(inicio);
		V_S.remove(inicio);
		
		while(!V_S.isEmpty()) {
			
			int posMin = buscarMinimo(D,V_S);
			
			for (int i = 0; i < D.length; i++) {
				int anteriorD = D[i];
				
				if(adyacentes[posMin][i]!=inf && D[posMin]!=inf) {
					D[i] = Math.min(D[i],D[posMin] + adyacentes[posMin][i]);
					P[i] = D[i]!=anteriorD? posMin:P[i];
				}
				
			}
			
			V_S.remove(posMin+1);
			S.add(posMin+1);
		}
		int[][]	res = new int[2][D.length];
		res[0] = D;
		res[1] = P;
		
		return res;
	}
	
	private static int buscarMinimo(int[] d, Set<Integer> v_S) {
		
		int valMin = Integer.MAX_VALUE;
		int posMin = 0;
		for (int i = 0; i < d.length; i++) {
			if(v_S.contains(i+1) && d[i] < valMin) {
				valMin = d[i];
				posMin = i;
			}
		}
		
		return posMin;
	}

	public void imprimeMatriz() {
		for (int i = 0; i < adyacentes.length; i++) {
			for (int j = 0; j < adyacentes.length; j++) {
				System.out.print(adyacentes[i][j]+" \t");
			}
			System.out.println();
		}
	}

	public List<Integer> getNodosFinales() {
		return nodosFinales;
	}
	
	
}
