import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException { // O(n^2)
		
		Map<String,Set<String>> paises = GestionArchivo.leerArchivo("enunciado.in"); // O(n)
		List<Pais> listaP = new LinkedList<Pais>(); //O(1)
		
		for (String llave : paises.keySet()) { //O(n)
			listaP.add(new Pais(llave,paises.get(llave)));
		}
		
		System.out.println("--------------------------------");
		
		for (Pais pais : listaP) { // O(n^2)
			pais.calculaTransLimitrofes(paises); // O(n)
			System.out.println(pais.getNombre()+": "+pais.getTransLimitrofes());
		}
		
		GestionArchivo.escribeArchivo("enunciado.out",listaP); //O(n^2)
		
	}

}
