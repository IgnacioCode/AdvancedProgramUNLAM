import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PintorGrafos {
	
	public Set<Nodo> grupoMaximoColoreado(Grafo g){
		
		List<Nodo> listaOriginal = g.getNodos();
		List<Nodo> listaOrdenada = new LinkedList<Nodo>();
		
		for (Nodo nodo : listaOriginal) { //O(n)
			listaOrdenada.add(nodo);
		}

		int[][] adyacentes = g.getAdyacentes();
		listaOrdenada.sort(null); //O(n*log(n))
		int colorMaximo = 0;
		
		for (Nodo nodo : listaOrdenada) {
			int index = nodo.getId()-1;
			int color = nodo.getColor();
			
			if(color == -1) {
				color = verificaColorAdyacentes(nodo,index,adyacentes,listaOriginal); //O(A x n)
				if(color>colorMaximo)
					colorMaximo = color;
				nodo.setColor(color);
			}
			
			for (int i = 0; i < adyacentes[index].length; i++) { //O(A x n^2)
				if(adyacentes[index][i] == 1) {
					Nodo vecino = listaOriginal.get(i);
					int colorVecino = vecino.getColor();
					if(colorVecino == -1) {
						colorVecino = verificaColorAdyacentes(vecino,vecino.getId()-1,adyacentes,listaOriginal); //O(A x n)
						if(colorVecino > colorMaximo)
							colorMaximo = colorVecino;
						vecino.setColor(colorVecino);
					}
				}
					
			}
			
		}
		
		int[] cantColor = new int[colorMaximo+1];
		
		for (Nodo n : listaOriginal) { //O(n)
			int color = n.getColor();
			cantColor[color]++;
		}
		
		int colorMax = 0;
		int cantMax = 0;
		for (int i = 0; i < cantColor.length; i++) { //O(n)
			if(cantColor[i] > cantMax) {
				colorMax = i;
				cantMax = cantColor[i];
			}
				
		}
		
		Set<Nodo> grupoFinal = new LinkedHashSet<Nodo>();
		for (Nodo nodo : listaOriginal) { //O(n)
			if(nodo.getColor() == colorMax)
				grupoFinal.add(nodo);
		}
		
		return grupoFinal;
		
	}

	private int verificaColorAdyacentes(Nodo nodo, int index, int[][] adyacentes, List<Nodo> listaOriginal) {//O(A x n)
		
		int colorActual = -1;
		boolean valido = true;
		
		do{
			valido = true;
			colorActual++;
			for (int i = 0; i < adyacentes[index].length; i++) { //O(n)
				if(adyacentes[index][i] == 1 && listaOriginal.get(i).getColor() == colorActual){
					valido = false;
				}
			}
			
		}while(!valido); //O(A x n)
		
		return colorActual;
	}

	private void coloreaNodo(Nodo nodo) {
		int colorMaximo = 0;
		
		
		
	}
	
}
