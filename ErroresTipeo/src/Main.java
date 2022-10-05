
public class Main {

	public static void main(String[] args) {
		
	String texto = "Estamos pintando!";
	String prueba = "ostant!Em inpados";
	
	procesador(texto,prueba);
		

	}

	private static int procesador(String texto, String prueba) {
		
		for(int i = 0;i<texto.length();i++) {
			
			if(texto.charAt(i) != prueba.charAt(i)) {
				int pos = buscaPos(texto.charAt(i),prueba,i);
				intercambia(texto,prueba,pos);
			}
			
		}
		
		return 0;
	}

	private static void intercambia(String texto, String prueba, int pos) {
		
		char aux = texto.charAt(pos);
			
	}

	private static int buscaPos(char charAt, String prueba,int inicial) {
		int i = inicial;
		char aux = prueba.charAt(i);
		while(aux != charAt) {
			i++;
			aux = prueba.charAt(i);
		}
		
		return i;
	}

}
