import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Moviles {

	public static void main(String[] args) throws IOException {
		
		cuentaPares("entradas\\todosIgualesIn.txt","salidas\\todosIgualesOut.txt");
	}

	public static void cuentaPares(String nameIn, String nameOut) throws IOException {
		
		Map<Integer,Integer> mapaColgantes = new HashMap<Integer,Integer>();
		
		File archIn = new File(nameIn);
		File archOut = new File(nameOut);
		Scanner lector = new Scanner(archIn);
		FileWriter escritor = new FileWriter(archOut);
		int colgantes = lector.nextInt();
		int sumaTotal = 0;
		int sumaPares = 0;
		int llaveMaxima = 0;
		
		for(int i=0;i<colgantes;i++) {
			
			int leido = lector.nextInt();
			if(mapaColgantes.containsKey(leido)) {
				int anterior = mapaColgantes.get(leido);
				mapaColgantes.put(leido, anterior+1);
			}
			else {
				mapaColgantes.put(leido,1);
			}
			if(leido > llaveMaxima)
				llaveMaxima = leido;

		}
		
		for(int i=1;i<=llaveMaxima;i++) {
			if(mapaColgantes.containsKey(i) && mapaColgantes.get(i)%2==0){
				sumaTotal+= (mapaColgantes.get(i))*i;
				sumaPares+= (mapaColgantes.get(i)/2);
			}
			
		}
		
		System.out.println(mapaColgantes);
		System.out.println(sumaTotal + " " + sumaPares);
		
		if(sumaPares!=0) {
			escritor.write(sumaTotal + " " + sumaPares);
		}
		else {
			escritor.write("no se puede");
		}
		
		lector.close();
		escritor.close();
		
	}
	
	

}
