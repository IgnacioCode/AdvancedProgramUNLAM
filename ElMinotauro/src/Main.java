import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Grafo miGrafo = GestionArchivo.leerArchivo("caso2.in");
		miGrafo.verListaAristas();
		System.out.println("------------------------------------");
		Grafo res = miGrafo.calculaKruskal();
		System.out.println("------------------------------------");
		res.verListaAristas();
		
		/*
		List<String> palabras = new LinkedList<String>();
		
		palabras.add("zorro");
		palabras.add("bala");
		palabras.add("hoola");
		palabras.add("amo");
		
		Queue<String> colaAristas = new PriorityQueue<String>(palabras);
		
		for (String string : colaAristas) {
			System.out.println(string);
		}
		*/
	}
}
