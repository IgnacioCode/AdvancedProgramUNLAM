import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionArchivo {
	
	public static List<Estacion> leerArchivo(String FileIn) throws IOException{ //O(P*log(P))
		Scanner lector = new Scanner(new File(FileIn));
		
		List<Estacion> listaEstaciones = new LinkedList<Estacion>();
		
		int cantEstaciones = lector.nextInt();
		for (int i = 0; i < cantEstaciones; i++) {	//O(P x R)
			int cantLecturas = lector.nextInt();
			int minActual = 60;
			int maxActual = -50;
			for (int j = 0; j < cantLecturas; j++) { //O(R)
				int minB = lector.nextInt();
				int maxB = lector.nextInt();
				if(minB < minActual)
					minActual = minB;
				if(maxB > maxActual)
					maxActual = maxB;
			}
			listaEstaciones.add(new Estacion(i+1,minActual,maxActual));
		}
		listaEstaciones.sort(null); //O(P*log(P))
		lector.close();
		return listaEstaciones;
	}
	
	public static void escribeArchivo(ServicioMetereologico sm,String FileOut) throws IOException{ //O(P)
		FileWriter escritor = new FileWriter(new File(FileOut));
		
		for (Estacion estacion : sm.getEstacionesPeores() ) { //O(P)
			escritor.write(String.format(estacion.getId() +" "+estacion.getCantIncomparables()+"\n"));
		}
		
		escritor.close();
		
	}
	
}
