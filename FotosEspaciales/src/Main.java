import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		procesaImagenes("entradas\\unaLetraIn.txt","salidas\\unaLetraOut.txt"); 
		
		
	}

	public static void procesaImagenes(String nameIn, String nameOut){
		
		File archIn = new File(nameIn);
		File archOut = new File(nameOut);
		Scanner lector;
		try{
			
			lector = new Scanner(archIn);
			FileWriter escritor = new FileWriter(archOut);
			
			Queue<Nodo> cola = new LinkedList<Nodo>();
			
			lector.useDelimiter("\r\n");
			
			String linea1 = lector.next();
			String linea2 = lector.next();
			
			lector.close();
			
			generaCola(linea1,cola);
			
			imprimeResultados(cola,linea2,escritor);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}catch (IOException e) {
			e.printStackTrace();
			return;
		}
		catch(NoSuchElementException e ) {
			e.printStackTrace();
			return;
		}
	
		
	}

	private static void imprimeResultados(Queue<Nodo> cola, String linea2,FileWriter escritor) throws IOException {
		
		while(!cola.isEmpty()){
			Nodo siguiente = cola.poll();
			if(siguiente.cantidad>1) {
				escritor.write("(" + siguiente.letra + siguiente.cantidad + ")");
			}
			else {
				escritor.write(siguiente.letra);
			}
		}
		
		escritor.write(String.format("\r\n"));
		
		for(int i = 0;i<linea2.length();i++) {
			char letraLeida = linea2.charAt(i);
			
			if(letraLeida == '(') {
				
				char letra = linea2.charAt(i+1);
				int cantidad =atoi(linea2.charAt(i+2));
				int desplazamiento = 3;
				
				if(linea2.charAt(i+3) != ')') {
					cantidad *=10;
					cantidad += atoi(linea2.charAt(i+3));
					desplazamiento++;
					if(linea2.charAt(i+4)!=')') {
						cantidad*=10;
						cantidad+=atoi(linea2.charAt(i+4));
						desplazamiento++;
					}
				}
				
				i+=desplazamiento;
				
				for (int j = 0; j < cantidad; j++) {
					escritor.write(letra);
				}
			}
			else {
				escritor.write(letraLeida);
			}
		}

		escritor.close();
		
		
	}

	private static void generaCola(String linea1, Queue<Nodo> cola) {
		
		String linea = "X" + linea1 + "X";
		int iguales = 1;
		
		for (int i = 1; i < linea.length()-1; i++) {
			
			char leido = linea.charAt(i);
			char siguiente = linea.charAt(i+1);
			
			if(siguiente == leido) {
				iguales++;
			}
			else {
				Nodo nuevo = new Nodo(leido,iguales);
				cola.add(nuevo);
				iguales = 1;
			}
			
		}
		
	}

	public static int atoi(char c)
	{
		String cn = ""+c;
	    try{
	        return Integer.parseInt(cn);
	    }catch(NumberFormatException ex){
	        return -1;   
	    }
	}
}
