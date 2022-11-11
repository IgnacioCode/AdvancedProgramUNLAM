import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, FaltanSegmentosException {
		
		try {
			Grafo miGrafo = GestionArchivo.leerArchivo("enunciado.in");
			
			int[][] PRes = miGrafo.calculaDijkstra(1);
			for (int[] is : PRes) {
				for (int is2 : is) {
					System.out.print(is2+" ");
				}
				System.out.println();
			}
			
			GestionArchivo.escribeArchivo("enunciado.out", miGrafo, PRes);
		} catch (FaltanSegmentosException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
