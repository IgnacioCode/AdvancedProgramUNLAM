import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class BuscaEnRandom {

	public static void main(String[] args) throws IOException {

		File pfE = new File("numeros.txt");
		File pfS = new File("salida.txt");
		FileWriter miEscritor = new FileWriter(pfE);
		try (FileWriter escSalida = new FileWriter(pfS)) {
			try (Scanner miLector = new Scanner(pfE)) {
				Random rand = new Random();
				long sumaTotal=0;
				int maximo=0;
				int minimo=12000;
				
				int cantNumeros = rand.nextInt(10000, 20000);
				
				for(int i = 0;i<cantNumeros;i++) {
					miEscritor.write(rand.nextInt(12000) +"\n");
				}
				
				miEscritor.close();
				
				for(int i=0;i<cantNumeros;i++) {
					int nroLeido=miLector.nextInt();
					sumaTotal+=nroLeido;
					if(nroLeido>maximo)
						maximo=nroLeido;
					if(nroLeido<minimo)
						minimo=nroLeido;
				}
				
				long promedio = sumaTotal/cantNumeros;
				
				escSalida.write("+----------+-------+\n");
				escSalida.write(String.format("| Maximo   | %5d |\n", maximo));
				escSalida.write("+----------+-------+\n");
				escSalida.write(String.format("| Minimo   | %5d |\n", minimo));
				escSalida.write("+----------+-------+\n");
				escSalida.write(String.format("| Promedio | %5d |\n", promedio));
				escSalida.write("+----------+-------+\n");
				/*
				escSalida.write("+----------+-------+\n");
				escSalida.write(String.format("| Maximo   | %5d |\n", maximo));
				escSalida.write("+----------+-------+\n");
				escSalida.write(String.format("| Minimo   | %5d |\n", minimo));
				escSalida.write("+----------+-------+\n");
				escSalida.write(String.format("| Promedio | %5d |\n", promedio));
				escSalida.write("+----------+-------+\n");
				escSalida.write(String.format("| Cantidad | %5d |\n", cantNumeros));
				escSalida.write("+----------+-------+\n");
				
				System.out.println("+----------+-------+");
				System.out.println(String.format("| Maximo   | %5d |", maximo));
				System.out.println("+----------+-------+");
				System.out.println(String.format("| Minimo   | %5d |", minimo));
				System.out.println("+----------+-------+");
				System.out.println(String.format("| Promedio | %5d |", promedio));
				System.out.println("+----------+-------+");
				System.out.println(String.format("| Cantidad | %5d |", cantNumeros));
				System.out.println("+----------+-------+");
				*/
				
			}
			
		}
		
		
		

	}

}
