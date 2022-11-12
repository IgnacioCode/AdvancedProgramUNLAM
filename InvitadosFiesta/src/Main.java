import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Grafo miGrafo = GestionArchivo.leerArchivo("enunciado.in");
		
		miGrafo.imprimeLista();
		
		System.out.println(miGrafo.calculaColoreo());
	}
}
