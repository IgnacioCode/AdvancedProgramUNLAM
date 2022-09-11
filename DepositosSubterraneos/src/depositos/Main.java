package depositos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		File pf = new File("F:\\Github\\AdvancedProgramingUNLAM\\DepositosSubterraneos\\src\\depositos\\depositos.txt");
		File pfS = new File("depositosOut.txt");
		Scanner miScanner = new Scanner(pf);
		FileWriter miEscritor = new FileWriter(pfS);
		
		int cantDepos = miScanner.nextInt();
		int volumenTotal=0;
		
		Depositos[] vectorDepositos = new Depositos[cantDepos];
		for(int i=0;i<cantDepos;i++) {
			vectorDepositos[i] = new Depositos();
		}
		
		int[] vectorProfundidades = new int[cantDepos];
		vectorProfundidades[0] = 0;
		
 		int superficieLeida = miScanner.nextInt();
		int profundidadLeida = miScanner.nextInt();
		volumenTotal += ( superficieLeida * profundidadLeida );
		vectorDepositos[0].profundidad=profundidadLeida;
		vectorDepositos[0].superficie=superficieLeida;
		
		for(int i = 1;i<cantDepos;i++) {
			
			superficieLeida = miScanner.nextInt();
			profundidadLeida = miScanner.nextInt();
			vectorDepositos[i].profundidad=profundidadLeida;
			vectorDepositos[i].superficie=superficieLeida;
			
			volumenTotal+= ( superficieLeida * profundidadLeida );
		}
		
		int volPetro = miScanner.nextInt();
		
		if(volPetro > volumenTotal) {
			System.out.println("No alcanza el espacio, rebasan: "+ (volPetro - volumenTotal));
		}
		else {
			int sobrante = volumenTotal - volPetro;
			System.out.println("Alcanza el espacio, sobran: " + sobrante);
			
			for(int i=1;i<cantDepos;i++) {
				vectorProfundidades[i]=(vectorDepositos[i-1].profundidad-vectorDepositos[i].profundidad)*(sumatoriaSuper(vectorDepositos,i-1)+vectorProfundidades[i-1]);
			}
			
			int j=0;
			while(j<cantDepos && volPetro > vectorProfundidades[j]) {
				j++;
			}
			
			System.out.println("Se utilizaron "+j+" depositos");
			miEscritor.write(j);
		}
		
		
	}
	
	public static int sumatoriaSuper(Depositos[] vec,int pos) {
		int suma = 0;
		for(int i = 0;i<=pos;i++) {
			suma+=vec[i].superficie;
		}
		
		return suma;
		
	}
	
}
