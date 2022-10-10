import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GestionArchivo {
	
	public static Map<String,Set<String>> leerArchivo(String FileIn) throws FileNotFoundException {
		
		Scanner lector = new Scanner(new File(FileIn));
		lector.nextInt();

		Map<String,Set<String>> conjuntoPaises = new TreeMap<String,Set<String>>();
		
		while(lector.hasNext()) { // O(n)
			String actual = lector.next();
			String vecino = lector.next();
			
			Set<String> conjuntoActual = conjuntoPaises.getOrDefault(actual, new TreeSet<String>());
			Set<String> conjuntoVecino = conjuntoPaises.getOrDefault(vecino, new TreeSet<String>());
			
			conjuntoActual.add(vecino);
			conjuntoVecino.add(actual);
			conjuntoPaises.put(actual,conjuntoActual);
			conjuntoPaises.put(vecino,conjuntoVecino);
			
		}
		
		for (String llave : conjuntoPaises.keySet()) {
			System.out.println(llave + ": " + conjuntoPaises.get(llave));
		}
		
		return conjuntoPaises;
		
	}
	
	public static void escribeArchivo(String FileOut, List<Pais> listaP) throws IOException {

		FileWriter escritor = new FileWriter(new File(FileOut));
		List<String> lineasTrans = new LinkedList<String>();

		for (Pais pais : listaP) { // O(n)
			escritor.write(pais.getNombre() + " " + pais.getLimitrofes().size());
			escritor.write(String.format("\n"));
		}
		for (Pais pais : listaP) { // O(n)
			for (String transV : pais.getTransLimitrofes()) {
				lineasTrans.add(pais.getNombre() + " " + transV);
			}
		}

		if (!lineasTrans.isEmpty()) {
			borrarParesRepetidos(lineasTrans); // O(n^2)

			for (String string : lineasTrans) { // O(n)
				escritor.write(String.format(string + "\n"));
			}
		} else {
			escritor.write("No hay Paises translimitrofes");
		}

		escritor.close();
	}

	private static void borrarParesRepetidos(List<String> l) {
		
		for (int i = 0; i < l.size(); i++) {
			String actual = l.get(i);
			for (int j = 0; j < l.size(); j++) {
				String leido = l.get(j);
				if(parIgual(actual,leido))
					l.remove(j);
			}
		}
	}

	private static boolean parIgual(String actual, String leido) {
		String p1 = actual.split(" ")[0];
		String p2 = actual.split(" ")[1];
		String p3 = leido.split(" ")[0];
		String p4 = leido.split(" ")[1];
		
		if((p1.equals(p4)) && (p2.equals(p3)) )
			return true;
		
		return false;
	}
	
}
