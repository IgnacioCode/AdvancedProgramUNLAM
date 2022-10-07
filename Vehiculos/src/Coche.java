
public class Coche extends Vehiculo{

	private int cantPuertas;
	
	public Coche(String mat, int cp) {
		super(mat);
		cantPuertas = cp;
	}

	public int getCantPuertas() {
		return cantPuertas;
	}
	
	
}

