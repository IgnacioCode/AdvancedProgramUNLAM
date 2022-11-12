import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Grafo miGrafo = GestionArchivo.leerArchivo("caso1.in");
		
		miGrafo.imprimeMatriz();
		
		int[] res = miGrafo.calculaDFS(1);
		
		for (int i : res) {
			System.out.print(i+" ");
		}
		
		GestionArchivo.escribeArchivo("caso1.out", res[res.length-1]);
		
	}

}
