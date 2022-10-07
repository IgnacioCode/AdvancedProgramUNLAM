import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Tablero {
	
	private List <Reina> reinas;
	
	public Tablero(String FileIn) throws FileNotFoundException {
		reinas = GestionArchivo.leeArchivo(FileIn); // O(n)
	}
	
	public void resuelveConflictos(String FileOut) throws IOException {
		FileWriter escritor = new FileWriter(new File("salida.out"));
		
		for (int i = 0; i < reinas.size(); i++) {	// O(n^2)
			
			Reina actual = reinas.get(i);
			
			for (int j = 0; j < reinas.size(); j++) { // O(n)
				
				if(j!=i) {
					Reina leida = reinas.get(j);
					actual.verificaChoque(leida);
				}		
			}
		}
		
		
		for (int i = 0; i < reinas.size(); i++) {	// O(n)
			Reina actual = reinas.get(i);
			escritor.write(actual.flancos.size()+" ");
			
			if(actual.flancos.containsKey("N"))
				escritor.write(actual.flancos.get("N").id +" ");
			if(actual.flancos.containsKey("NE"))
				escritor.write(actual.flancos.get("NE").id +" ");
			if(actual.flancos.containsKey("E"))
				escritor.write(actual.flancos.get("E").id +" ");
			if(actual.flancos.containsKey("SE"))
				escritor.write(actual.flancos.get("SE").id +" ");
			if(actual.flancos.containsKey("S"))
				escritor.write(actual.flancos.get("S").id +" a");
			if(actual.flancos.containsKey("SO"))
				escritor.write(actual.flancos.get("SO").id +" ");
			if(actual.flancos.containsKey("O"))
				escritor.write(actual.flancos.get("O").id +" ");
			if(actual.flancos.containsKey("NO"))
				escritor.write(actual.flancos.get("NO").id +" ");
			
			escritor.write(String.format("\n"));
		}
		
		escritor.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		Tablero miTablero = new Tablero("enunciado.in");
		miTablero.resuelveConflictos("enunciado.out");
	}

}
