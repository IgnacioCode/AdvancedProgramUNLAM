import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Grafo ciudad = GestionArchivo.leerArchivo("casoNormal.txt");
		System.out.println(ciudad.puentesNecesarios());
	}
}
