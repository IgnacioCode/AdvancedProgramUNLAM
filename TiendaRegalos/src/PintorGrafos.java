import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PintorGrafos {
	
	public Set<Nodo> grupoMaximoColoreado(Grafo g){
		
		List<Nodo> listaOriginal = g.getNodos();
		List<Nodo> listaOrdenada = new LinkedList<Nodo>();
		
		for (Nodo nodo : listaOriginal) {
			listaOrdenada.add(nodo);
		}

		int[][] adyacentes = g.getAdyacentes();
		listaOrdenada.sort(null);
		int colorMaximo = 0;
		
		for (Nodo nodo : listaOrdenada) {
			int index = nodo.getId()-1;
			int color = nodo.getColor();
			
			if(color == -1) {
				color = verificaColorAdyacentes(nodo,index,adyacentes,listaOriginal);
				if(color>colorMaximo)
					colorMaximo = color;
				nodo.setColor(color);
			}
			
			for (int i = 0; i < adyacentes[index].length; i++) {
				if(adyacentes[index][i] == 1) {
					Nodo vecino = listaOriginal.get(i);
					int colorVecino = vecino.getColor();
					if(colorVecino == -1) {
						colorVecino = verificaColorAdyacentes(vecino,vecino.getId()-1,adyacentes,listaOriginal);
						if(colorVecino > colorMaximo)
							colorMaximo = colorVecino;
						vecino.setColor(colorVecino);
					}
				}
					
			}
			
		}
		
		int[] cantColor = new int[colorMaximo+1];
		
		for (Nodo n : listaOriginal) {
			int color = n.getColor();
			cantColor[color]++;
		}
		
		int colorMax = 0;
		int cantMax = 0;
		for (int i = 0; i < cantColor.length; i++) {
			if(cantColor[i] > cantMax) {
				colorMax = i;
				cantMax = cantColor[i];
			}
				
		}
		
		Set<Nodo> grupoFinal = new LinkedHashSet<Nodo>();
		for (Nodo nodo : listaOriginal) {
			if(nodo.getColor() == colorMax)
				grupoFinal.add(nodo);
		}
		
		return grupoFinal;
		
	}

	private int verificaColorAdyacentes(Nodo nodo, int index, int[][] adyacentes, List<Nodo> listaOriginal) {
		
		int colorActual = -1;
		boolean valido = true;
		
		do{
			valido = true;
			colorActual++;
			for (int i = 0; i < adyacentes[index].length; i++) {
				if(adyacentes[index][i] == 1 && listaOriginal.get(i).getColor() == colorActual){
					valido = false;
				}
			}
			
		}while(!valido);
		
		return colorActual;
	}

	private void coloreaNodo(Nodo nodo) {
		int colorMaximo = 0;
		
		
		
	}
	
}
