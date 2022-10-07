import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionArchivo {
	
	public static List<Reina> leeArchivo(String FileIn) throws FileNotFoundException {
		
		Scanner lector = new Scanner(new File(FileIn));
		List<Reina> reinas = new LinkedList<Reina>();
		
		int dimension = lector.nextInt();
		int cantReinas = lector.nextInt();
		
		for (int i = 0; i < cantReinas; i++) {
			int x = lector.nextInt();
			int y = lector.nextInt();
			reinas.add(new Reina(x,y,i+1));
		}
		
		return reinas;
		
	}
	
}
