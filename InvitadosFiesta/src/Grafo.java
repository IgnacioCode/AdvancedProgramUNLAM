import java.math.MathContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
	
	List<List<Arista>> adyacentes;
	
	public Grafo(List<List<Arista>> adyacentes) {
		super();
		this.adyacentes = adyacentes;
	}

	public List<List<Arista>> getAdyacentes() {
		return adyacentes;
	}
	
	public int calculaColoreo() {
		
		int[] visitados = new int[adyacentes.size()];
		int[] colores = new int[adyacentes.size()];
		
		for (int i = 0; i < visitados.length; i++) {
			int colorPosible = colorAdyacentes(i,visitados);
			visitados[i] = colorPosible;
			colores[colorPosible-1]++;
		}
		
		for (int i = 0; i < visitados.length; i++) {
			System.out.print(visitados[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < colores.length; i++) {
			System.out.print(colores[i]+" ");
		}
		
		int res = buscaMaximo(colores);
		
		return res;
		
	}
	
	private int buscaMaximo(int[] colores) {
		int valMax = 0;
		int colMax = 0;
		
		for (int i = 0; i < colores.length; i++) {
			if(colores[i] > valMax) {
				valMax = colores[i];
				colMax = i;
			}
		}
		
		return valMax;
	}

	private int colorAdyacentes(int i,int[] visitados) {
		
		List<Arista> l = adyacentes.get(i);
		int colorDisponible = 1;
		boolean noHayColor = true;
		
		while(noHayColor) {
			noHayColor = false;
			for (Arista arista : l) {
				int indice = arista.getDestino()-1;
				if(visitados[indice] == colorDisponible) {
					noHayColor = true;
				}
			}
			colorDisponible++;
		}
		
		
		
		return colorDisponible-1;
	}

	public void imprimeLista() {
		
		for (List<Arista> list : adyacentes) {
			for (Arista arista : list) {
				System.out.print(arista+" ");
			}
			System.out.println();
		}
	}
	
}
