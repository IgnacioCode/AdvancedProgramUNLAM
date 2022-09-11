
public class Circulo {
	private Punto p0;
	private double radio;
	
	public Circulo(Punto p0,double radio) {
		this.p0 = p0;
		this.radio = radio;
	}
	
	boolean intersectaCon(Circulo c2) {
		 if(this.p0.distanciaCon(c2.p0) > this.radio + c2.radio) {
			 return false;
		 }
		 return true;
	}
}
