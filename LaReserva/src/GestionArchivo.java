import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestionArchivo {
	
	public static Grafo leerArchivo(String FileIn) throws IOException {
		Scanner lector = new Scanner(new File(FileIn));
		
		int cantNodos = lector.nextInt();
		int cantAristas = lector.nextInt();
		
		int[][] adyacentes = new int[cantNodos][cantNodos];
		final int inf = Integer.MAX_VALUE;
		
		for (int i = 0; i < adyacentes.length; i++) {
			for (int j = 0; j < adyacentes.length; j++) {
				adyacentes[i][j] = inf;
			}
		}
		
		for (int i = 0; i < cantAristas; i++) {
			int origen = lector.nextInt();
			int destino = lector.nextInt();
			adyacentes[origen-1][destino-1] = 1;
		}
		
		lector.close();
		return new Grafo(adyacentes);
	}
	
	public static void escribeArchivo(String FileOut,int val) throws IOException {
		FileWriter escritor = new FileWriter(new File(FileOut));
		
		escritor.write(val+"");
		
		escritor.close();
		
	}
	
}
