import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionArchivo {
	
	public static Grafo leerArchivo(String FileIn) throws IOException {
		Scanner l = new Scanner(new File(FileIn));
		List<List<Arista>> adyacentes = new ArrayList<List<Arista>>();
		
		int cantNodos = l.nextInt();
		int cantAristas = l.nextInt();
		
		for (int i = 0; i < cantNodos; i++) {
			List<Arista> ls = new LinkedList<Arista>();
			adyacentes.add(ls);
		}
		
		for (int i = 0; i < cantAristas; i++) {
			int origen = l.nextInt();
			int destino = l.nextInt();
			
			adyacentes.get(origen-1).add(new Arista(origen,destino));	
			adyacentes.get(destino-1).add(new Arista(destino,origen));	
		}
		
		l.close();
		return new Grafo(adyacentes);
	}
	
}
