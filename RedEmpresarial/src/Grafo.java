import java.util.Map;

public class Grafo {
	
	private int[][] adyacentes;
	private Map<Integer,String> nombres;
	private Map<String,Integer> indices;
	final int inf = Integer.MAX_VALUE;
	
	
	public Grafo(int[][] adyacentes, Map<Integer, String> nombres, Map<String, Integer> indices) {
		super();
		this.adyacentes = adyacentes;
		this.nombres = nombres;
		this.indices = indices;
	}

	public int[][] getAdyacentes() {
		return adyacentes;
	}

	public Map<Integer, String> getNombres() {
		return nombres;
	}

	public Map<String, Integer> getIndices() {
		return indices;
	}
	
	public int[][] calculaFloyd(){ //O(A^3/2)
		
		int[][] FK_1 = new int[adyacentes.length][adyacentes.length];
		int[][] FK = new int[adyacentes.length][adyacentes.length];
		
		FK_1 = adyacentes.clone();
		
		for (int i = 0; i < FK.length; i++) {
			FK_1[i][i] = 0;
		}
		
		FK = FK_1.clone();
		
		for (int K = 0; K < FK.length; K++) {
			
			for (int i = 0; i < FK.length; i++) {
				for (int j = 0; j < FK.length; j++) {
					if(i!=K && j!=K && i!=j) {
						if(FK_1[i][K]!=inf && FK_1[K][j]!=inf)
							FK[i][j] = Math.min(FK_1[i][j], FK_1[i][K] + FK_1[K][j]);
					}
				}
			}
			
			FK_1 = FK.clone();
		}
		
		
		
		return FK_1;
	}
	
	public void imprimeMatriz() {
		for (int i = 0; i < adyacentes.length; i++) {
			for (int j = 0; j < adyacentes.length; j++) {
				if(adyacentes[i][j] != inf)
					System.out.print(adyacentes[i][j]+" \t");
				else
					System.out.print("inf \t");
			}
			System.out.println();
		}
	}
	
}
