import java.io.IOException;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Grafo miGrafo = GestionArchivo.leeArchivo("fatiga.txt"); //O(n^2)
		
		PintorGrafos pintor = new PintorGrafos(); //O(1)
		
		Set<Nodo> mayorInconexo = pintor.grupoMaximoColoreado(miGrafo);
		
		System.out.println(mayorInconexo);
		System.out.println(mayorInconexo.size());
		
	}
	
}
