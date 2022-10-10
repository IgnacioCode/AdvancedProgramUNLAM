import java.io.IOException;
import java.util.List;

public class Armador {

	public static void main(String[] args) throws IOException {
		
		Armador miArmador = new Armador();
		List<Mesada> listaMesadas = GestionArchivo.leerArchivo("enunciado.in"); //O(n)
		int salida = miArmador.armaPilaMesadas(listaMesadas); // O(n*log(n))
		GestionArchivo.escribeArchivo(salida, "enunciado.out"); //O(1)
		System.out.println(salida);
		
	}

	public int armaPilaMesadas(List<Mesada> lista) { // O(n*log(n))
		int pilas = 0;
		lista.sort(null); // O(n*log(n))
		
		for (Mesada mesada : lista) {
			System.out.println(mesada.getLargo() + " " + mesada.getAncho());
		}
		
		while(!lista.isEmpty()) {	//O(n)
			Mesada actual = lista.get(0);
			
			for (int j = 1; j < lista.size(); j++) {
				Mesada leida = lista.get(j);
				if(leida.getAncho() < actual.getAncho()) {
					lista.remove(j);
					j--;
				}
				else {
					break;
				}
					
			}
			pilas++;
			lista.remove(0);
		}
		return pilas;

	}
}
