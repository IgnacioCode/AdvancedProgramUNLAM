import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Aplicacion {
	
	int peso;
	
	public Aplicacion(int p) {
		peso = p;
	}
	
	public static void main(String[] args) throws IOException {
		almacenamiento("enunciado.in");
		almacenamiento("almacenamiento.in");
		almacenamiento("prueba.in");
	}

	public static void almacenamiento(String FileIn) throws IOException {
		
		Scanner lector = new Scanner(new File(FileIn));
		FileWriter escritor = new FileWriter(new File(FileIn.split(Pattern.quote("."))[0] + ".out"));
		
		int cantAplicaciones = lector.nextInt();
		int tam = lector.nextInt();
		
		int[] memoria = new int[cantAplicaciones];
		int[] memoriaAcum = new int[cantAplicaciones+1];
		
		for(int i = 0;i<cantAplicaciones;i++) {
			memoria[i] = lector.nextInt();
		}
		for (int i = 0; i < memoria.length; i++) {
			memoriaAcum[i+1] = memoriaAcum[i] + memoria[i]; 
		}
		
		int i = 0;
		int j = 1;
		int tamGrupo = 0;
		int sumaParcial = 0;
		
		while(sumaParcial < tam) {
			
			i = 0;
			j = 1 + tamGrupo;
			tamGrupo++;
			
			if(j > memoriaAcum.length) {
				System.out.println("No hay MB suficiente");
				escritor.write("No hay MB suficiente");
				escritor.close();
				return;	
			}

			while(j<memoriaAcum.length && sumaParcial < tam) {
				sumaParcial = memoriaAcum[j] - memoriaAcum[i];
				i++;
				j++;
			}
			
		}
		
		System.out.println("La cantidad de apps necesarias a borrar son : " + tamGrupo);
		System.out.println("Borrando desde la app " + (i) + " hasta la app " + (j-1) + " se liberan " + sumaParcial + " MB de espacio.");
		escritor.write(tamGrupo+"");
		escritor.close();
	}
}

// v1
// v2[0] = v1[0]
// v2[1] = 5 + 