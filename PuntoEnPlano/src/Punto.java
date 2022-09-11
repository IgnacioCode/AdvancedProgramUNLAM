
public class Punto {
	private double x;
	private double y;
	
	public Punto(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public double distanciaCon(Punto p1) {
		return Math.sqrt(Math.pow(this.x-p1.x,2) + Math.pow(this.y-p1.y,2));
	}
	
}

