package operacionesMatrices;

public class TestBase {

	public static void main(String[] args) {
		int[] Entrada = {1,2,3,4,6};
		//
		int[] SalidaEsperada = {1,3,6,10};
		
		Base miBase = new Base(Entrada);
		
		System.out.println("Entrada: "+miBase);
		System.out.println("Salida: "+miBase.sumaPosiciones());

	}

}
