import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		resolucionFea();
	}
	
	//// SOLUCION BELLA
	
	public static void resolucionBella() throws FileNotFoundException {
		
		List<Reina> reinas = new LinkedList<Reina>();
		
		File pfIn = new File("entrada.in");
		File pfOut = new File("salida.out");
		
		cargaReinas(reinas,pfIn);
		
		calculaIntersecciones(reinas,pfOut);
	}
	
	private static void calculaIntersecciones(List<Reina> reinas, File pfOut) {
		
		for(int i = 0;i<reinas.size();i++) {
			Reina r = reinas.get(i);
			
		}
		
	}
	
	
	//// SOLUCION FEA
	
	

	public static void resolucionFea() throws IOException {
		
		List<Reina> reinas = new LinkedList<Reina>();
		
		File pfIn = new File("entrada.in");
		File pfOut = new File("salida.out");
		
		Tablero miTablero = cargaReinas(reinas,pfIn); // N 
		
		verificaEnfrentamientos(miTablero,reinas,pfOut);
		
	}

	private static Tablero cargaReinas(List<Reina> reinas, File pfIn) throws FileNotFoundException {
		
		Scanner lector = new Scanner(pfIn);
		
		int dimension = lector.nextInt();
		
		int[][] matriz = new int[dimension][dimension];
		
		int cantReinas = lector.nextInt();
		
		for(int i = 0;i<cantReinas;i++) {	//Se ejecuta N veces
			int x = lector.nextInt();
			int y = lector.nextInt();
			reinas.add(new Reina(x-1,y-1));
			matriz[x-1][y-1] = i+1;
		}
		
		lector.close();
		
		return new Tablero(matriz,dimension);
		
	}
	
	private static void verificaEnfrentamientos(Tablero tablero, List<Reina> reinas, File pfOut) throws IOException {
		
		FileWriter escritor = new FileWriter(pfOut);
		Posicion posEncontrada;
		int cantEncontradas=0;
		Queue<Posicion> colaEncontradas  = new LinkedList<Posicion>();
		
		for(int i = 0;i<reinas.size();i++) { //Se ejecuta N veces
			Reina actual = reinas.get(i);
			for(int j = 0 ; j<8;j++) {	//Se ejecuta 8 veces
				posEncontrada = barreRecta(tablero,actual,j); // N
				if(posEncontrada != null) {
					colaEncontradas.add(posEncontrada);
					cantEncontradas++;
				}
			}
			
			escritor.write(cantEncontradas + " ");
			for (int j = 0; j < colaEncontradas.size(); j++) {
				Posicion p = colaEncontradas.poll();
				
				int ordenReina = reinas.indexOf(new Reina(p.x,p.y));
				System.out.println("Buscando: " + p.x + " " + p.y + " Resultado: " + ordenReina);
				if( ordenReina != -1) {
					escritor.write(ordenReina + " ");
				}
			}
			
			escritor.write(String.format("\n"));
			cantEncontradas=0;
		}
		
		escritor.close();
		
	}

	private static Posicion barreRecta(Tablero tablero, Reina reinaActual, int direccion) {
		
		int desX = 0;
		int desY = 0;
		int posX = reinaActual.p.x;
		int posY = reinaActual.p.y;
		int tamaño = tablero.dimension;
		boolean reinaEncontrada = false;
		
		switch(direccion) {
			case 0: //NORTE
				desX = -1;
				break;
			case 1:	//NORESTE
				desX = -1;
				desY = 1;
				break;
			case 2: //ESTE
				desY = 1;
				break;
			case 3: //SURESTE
				desX = 1;
				desY = 1;
				break;
			case 4:	//SUR
				desX = 1;
				break;
			case 5:	//SUROESTE
				desX = 1;
				desY = -1;
				break;
			case 6:	//OESTE
				desY = -1;
				break;
			case 7: //NOROESTE 
				desX = -1;
				desY = -1;
				break;
		}
		
		posX+=desX;
		posY+=desY;
		
		while(posX >= 0 && posX <= tamaño-1 && posY >= 0 && posY <= tamaño-1 && !reinaEncontrada) { // 	N
			
			if(tablero.matPos[posX][posY] != 0 )
				reinaEncontrada = true;
			posX+=desX;
			posY+=desY;
		}
		
		return reinaEncontrada? new Posicion(posX-desX,posY-desY):null;
		
	}

}
