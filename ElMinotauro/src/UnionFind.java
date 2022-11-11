
public class UnionFind {

	private int cantNodos;
	private int[] vector;

	public UnionFind(int cantNodos) {

		this.cantNodos = cantNodos;

		this.vector = new int[cantNodos+1];

		for (int i = 1; i <= cantNodos; i++)
			vector[i] = i;

	}

	public int find(int nodo) {

		while (vector[nodo] != nodo)
			nodo = vector[nodo];

		return nodo;
	}

	public void union(int representanteOrigen, int representanteDestino) {
		
		int repO = find(representanteOrigen);
		int repD = find(representanteDestino);
		
		if (repO < repD)
			vector[repD] = repO;
		else
			vector[repO] = repD;
	}
	
	public boolean mismoRepresentante(int origen,int destino) {
		if(find(origen) == find(destino))
			return true;
		return false;
	}
	
	public void mostrar() {

		for (int i = 0; i < cantNodos; i++)
			System.out.println(vector[i]);

	}
}

