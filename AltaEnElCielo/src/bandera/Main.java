package bandera;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		File entrada = new File("F:\\Github\\AdvancedProgramingUNLAM\\AltaEnElCielo\\src\\bandera\\entrada.txt");
		try {
			
			int i=0,proximoRetaso=0,sigEscuela=0;
			
			Scanner lector = new Scanner(entrada);
			
			int cantTela = lector.nextInt();
			int cantEscuelas = lector.nextInt();
			
			Bandera[] escuelasBanderas = new Bandera[cantEscuelas];
			
			while(lector.hasNextInt()) {
				escuelasBanderas[i].setLargo(lector.nextInt());
				escuelasBanderas[i].setRetasos(1);
				cantTela-=escuelasBanderas[i].getLargo();
				i++;
			}
			
			while( proximoRetaso < cantTela && sigEscuela!=cantEscuelas-1) {
				
				
				
			}
			
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		

	}
	
	public static int sumaDigitos(int number)  {  
		
		int sum;      
		
		for(sum=0; number!=0; number=number/10)  {  
			sum = sum + number % 10;  
		}  
		
		return sum;  
	}  

}
