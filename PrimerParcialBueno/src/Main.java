import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		ServicioMetereologico calculador = new ServicioMetereologico(GestionArchivo.leerArchivo("enunciado.in")); //O(P*log(P))
		calculador.calculaMasHostil(); //O(P^2)
		GestionArchivo.escribeArchivo(calculador, "enunciado.out"); //O(P)
		
	}
	
}
