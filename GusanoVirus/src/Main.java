import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
	
	// A --> Cantidad de Enlaces
	// I --> Cantidad de Infectadas
	// N --> Cantidad de Nodos
	// N = sqrt(2A) --> N = sqrt(A) <--> N^2 = A
	// O(I) = O(N) = O(sqrt(A))
	
	public static void main(String[] args) throws IOException {	//O(A*sqrt(A)) <---> O(N^3)
		Main.generaFatiga();
		Grafo red = GestionArchivo.leerArchivo("fatiga.in");	// O(A)
		Set<Nodo> origenPosible = new LinkedHashSet<Nodo>();
		origenPosible.addAll(red.getIndices().keySet()); 
		
		for (Nodo n : red.getInfectados().keySet()) { //O(A*sqrt(A))
			int primeraLLegada = red.getInfectados().get(n);	//O(1)
			int[] distancias = red.calculaDijkstra(n);	// O(A)
			for (int i = 0; i < distancias.length; i++) {	//O(sqrt(A))
				if(distancias[i]!=primeraLLegada){
					origenPosible.remove(red.getNodosMapa().get(i)); //O(1)
				}
			}
		}
		
		System.out.println(origenPosible);
	}
	
	private static void generaFatiga() throws IOException {
		FileWriter escritor = new FileWriter(new File("fatiga.in"));
		
		escritor.write(String.format(29646+"\n"));
		for (int i = 1; i <= 244; i++) {
			for (int j = i+1; j <= 244; j++) {
				escritor.write(String.format(i + " " + 1 + " "+ j + "\n"));
			}
		}
		
		escritor.write(String.format(1+"\n"));
		escritor.write(String.format(1 + " " + 1 + "\n"));
		
		/*
		escritor.write(String.format(243+"\n"));
		for (int i = 1; i <= 243; i++) {
			escritor.write(String.format(i+" "+1+"\n"));
		}
		*/
		escritor.close();
	}
}
