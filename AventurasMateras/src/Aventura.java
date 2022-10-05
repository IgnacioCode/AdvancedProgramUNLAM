import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Aventura {

	public static void main(String[] args) throws IOException {
		
		calculaSebador("pruebaEstres.in");
	}

	public static void calculaSebador(String FileIn) throws IOException {
		Scanner lector = new Scanner(new File(FileIn));
		FileWriter escritor = new FileWriter(new File("Out"+FileIn));
		int N = lector.nextInt();
		int[] pasajes = new int[N-1];
		
		for(int i = 0;i<N-1;i++) {
			pasajes[i] = lector.nextInt();
		}
		
		List<Amigo> rondaAmigos = new LinkedList<Amigo>();
		
		for(int i = 0;i<N;i++) {
			rondaAmigos.add(new Amigo(i+1));
		}
		int posAnterior = 0;
		for(int i = 0;i<N-1;i++) { // O(n)
			Amigo saliente = rondaAmigos.get((pasajes[i]%(N-i) + posAnterior)%(N-i)); // O(n)
			rondaAmigos.remove((pasajes[i]%(N-i) + posAnterior)%(N-i)); // O(1)
			posAnterior = (pasajes[i]%(N-i) + posAnterior)%(N-i); // O(1)
			System.out.println("Salio el OIA : "+ saliente.id); // O(1)
			escritor.write(String.format("Salio el OIA : "+ saliente.id+"\n"));
		}
		System.out.println("El sebador es el OIA : " + rondaAmigos.get(0).id);
		escritor.write("El sebador es el OIA : " + rondaAmigos.get(0).id);
		
		escritor.close();
	}

}
