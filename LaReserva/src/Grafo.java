import java.util.Stack;

public class Grafo {
	
	private int[][]	adyacentes;
	
	final int inf = Integer.MAX_VALUE;
	
	public Grafo(int[][] adyacentes) {
		super();
		this.adyacentes = adyacentes;
	}

	public int[][] getAdyacentes() {
		return adyacentes;
	}

	public int[] calculaDFS(int nodoInicial) {
		
		int[] visitas = new int[adyacentes.length];
		Stack<Integer> p = new Stack<Integer>();
		
		int nodoActual = nodoInicial;
		p.add(nodoInicial);
		
		do {
			
			visitas[nodoActual-1]++;	//ESTO ES VISITAR
			agregaAdyacentesPila(p,nodoActual);	//AGREGA TODOS SUS ADYACENTES
			
			nodoActual = p.pop();	//SACA EL TOPE DE PILA
			
		}while(!p.isEmpty());
		
		
		return visitas;	
		
	}
	
	private void agregaAdyacentesPila(Stack<Integer> p, int nodoActual) {

		for (int i = 0; i < adyacentes[nodoActual-1].length; i++) {
			if(adyacentes[nodoActual-1][i]==1)
				p.add(i+1);
		}
		
		
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
