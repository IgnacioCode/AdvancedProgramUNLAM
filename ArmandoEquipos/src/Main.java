import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException { // O(n^2)
		
		Equipo miEquipo = GestionArchivo.leerArchivo("casoEmpate.in"); // O(n)
		miEquipo.calculaAfinidad(); // O(n^2)
		GestionArchivo.escribeArchivo("casoEmpate.out", miEquipo); //O(1)
		
	}

}
