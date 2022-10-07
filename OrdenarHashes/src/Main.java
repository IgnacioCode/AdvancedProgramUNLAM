import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) {
		String[] vec = {"Marta","Juan","Marta","pepe","Jose","Juan","Marta","Nacho"};
		
		Set<String> lista = new LinkedHashSet<String>();
		
		for (String elementoVector : vec) {
			lista.add(elementoVector);
		}
		
		String[] res = new String[lista.size()];
		int i = 0;
		
		for (String elementoLista : lista) {
			res[i] = elementoLista; 
			i++;
		}
		for (String elementoRes : res) {
			System.out.println(elementoRes);
		}
		
	}
	
	
}
