import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionArchivo {
	public static Equipo leerArchivo(String FileIn) throws FileNotFoundException {
		
		Scanner lector = new Scanner(new File(FileIn));
		int cantPre = lector.nextInt();
		int cantPar = lector.nextInt();
		List<String> listaRes = new LinkedList<String>();
		for (int i = 0; i < cantPar; i++) { //O(n)
			listaRes.add(lector.next());
		}
		
		lector.close();
		return new Equipo(cantPar,cantPre,listaRes);

	}
	
	public static void escribeArchivo(String FileOut,Equipo e) throws IOException {
		FileWriter escritor = new FileWriter(new File(FileOut));
		
		escritor.write(String.format(e.getAfinidad() +"\n"));
		escritor.write(e.getPatronMax());
		
		escritor.close();
	}
}
