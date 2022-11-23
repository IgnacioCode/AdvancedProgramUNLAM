import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
	
	final static int inf = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException { //O(A^3/2)
		
		Grafo miGrafo = GestionArchivo.leerArchivo("enunciado.in"); //O(A)
		miGrafo.imprimeMatriz();
		
		System.out.println("----------------------------------------");
		
		int[][] res = miGrafo.calculaFloyd(); //O(A^3/2)
		
		int valorMax = buscaValorMaximo(res);//O(A)
		
		Set<String> involucrados = buscaInvolucrados(res,miGrafo,valorMax);//O(A)
		
		imprimeMatriz(res);
		
		GestionArchivo.escribeArchivo("enunciado.out", valorMax, involucrados); //O(A^1/2)
		
	}
	
	
	private static Set<String> buscaInvolucrados(int[][] res, Grafo miGrafo,int valMax) {
		Set<String> s = new LinkedHashSet<String>();
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				if(res[i][j] == valMax) {
					String nombre1 = miGrafo.getNombres().get(i);
					String nombre2 = miGrafo.getNombres().get(j);
					
					s.add(nombre1);
					s.add(nombre2);
					
				}
			}
		}
		
		return s;
	}


	private static int buscaValorMaximo(int[][] res) {
		int valMax = 0;
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				if(res[i][j]>valMax)
					valMax = res[i][j];
			}
		}
		
		return valMax;
	}


	public static void imprimeMatriz(int[][] adyacentes) {
		for (int i = 0; i < adyacentes.length; i++) {
			for (int j = 0; j < adyacentes.length; j++) {
				if(adyacentes[i][j] != inf)
					System.out.print(adyacentes[i][j]+" \t");
				else
					System.out.print("inf \t");
			}
			System.out.println();
		}
	}
}
