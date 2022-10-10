import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionArchivo {

	public static List<Mesada> leerArchivo(String FileIn) throws FileNotFoundException{
		
		Scanner lector = new Scanner(new File(FileIn));
		
		List<Mesada> listaMesadas = new LinkedList<Mesada>();
		int cantMesadas = lector.nextInt();
		
		for (int i = 0; i < cantMesadas; i++) {
			int v1 = lector.nextInt();
			int v2 = lector.nextInt();
			
			listaMesadas.add(new Mesada(v1,v2));
		}
		
		return listaMesadas;
		
	}
	
	public static void escribeArchivo(int v,String FileOut) throws IOException {
		FileWriter escritor = new FileWriter(new File(FileOut));
		
		escritor.write(v+"");
		
		escritor.close();
	}
	
}
