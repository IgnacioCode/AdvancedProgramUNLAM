import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestionArchivo {

	
	public static Plano leerArchivo(String FileIn) throws FileNotFoundException {
		
		Scanner lector = new Scanner(new File(FileIn));
		
		int dx = lector.nextInt();
		int dy = lector.nextInt();
		int f = lector.nextInt();
		int l = lector.nextInt();
		int cantPiedras = lector.nextInt();
		int[][] mapita = new int[dy][dx];
		
		for (int i = 0; i < cantPiedras; i++) {
			int actualX = lector.nextInt()-1;
			int actualY = lector.nextInt()-1;
			
			mapita[actualY][actualX] = 1;
			
		}
		
		for (int i = 0; i < mapita.length; i++) {
			for (int j = 0; j < mapita[0].length; j++) {
				System.out.print(mapita[i][j]+"\t");
			}
			System.out.println();
		}
		
		return new Plano(dx,dy,new Casa(f,l),mapita);
		
	}
	
	public static void escribeArchivo(Plano p,String FileOut) throws IOException {
		FileWriter escritor = new FileWriter(new File(FileOut));
		
		if(p.getCasita().getPosX()==-1) {
			escritor.write("NO");
		}
		else {
			escritor.write(String.format("SI\n"));
			escritor.write(String.format(p.getCasita().getPosX() + " " + p.getCasita().getPosY() + "\n"));
			escritor.write(p.getCasita().getOrientacion() + "");
		}
		
		escritor.close();
	}
	

}
