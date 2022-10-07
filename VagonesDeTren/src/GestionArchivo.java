import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionArchivo {
	
	public static Tren cargaArchivo(String FileIn) throws FileNotFoundException{
		
		Scanner lector = new Scanner(new File(FileIn));
		
		List<Especie> listaEspecies = new LinkedList<Especie>();
		int cantEspecies = lector.nextInt();
		int maxAgresividad = lector.nextInt();
		
		for (int i = 0; i < cantEspecies; i++) { // O(n)
			String nom = lector.next();
			int agre = lector.nextInt();
			lector.nextInt();
			listaEspecies.add(new Especie(nom,agre));
		}
		
		return new Tren(listaEspecies,maxAgresividad);
		
	}
	
	public static void escribeArchivo(String FileOut,Tren tren) throws IOException {
		FileWriter escritor = new FileWriter(new File(FileOut));
		
		escritor.write(tren.getCantVagones() + " ");
		escritor.write(tren.getAgresividadMax() + " ");
		
		escritor.close();
	}
	
}
