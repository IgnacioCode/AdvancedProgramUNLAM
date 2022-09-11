
public class TestPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int j = 0; j < 5; j++) {
			
		
			int iteraciones = 1000000000;
			
			double distancias=0;
			
			for (int i = 0; i < iteraciones; i++) {
				
				Punto puntoP = new Punto(Math.random(),Math.random());
				Punto puntoQ = new Punto(Math.random(),Math.random());
				
				//System.out.println(puntoQ.distanciaCon(puntoP));
				
				distancias+=puntoQ.distanciaCon(puntoP);
				
			}
			
			System.out.println(distancias/iteraciones);
			
		}
		
	}

}
