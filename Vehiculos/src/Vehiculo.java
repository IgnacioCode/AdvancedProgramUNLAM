
public abstract class Vehiculo {
	
	protected String matricula;
	protected int velocidad;
	
	public Vehiculo(String mat) {
		matricula = mat;
		velocidad = 0;
	}

	@Override
	public String toString() {
		return "matricula=" + matricula + ", velocidad=" + velocidad;
	}
	
	public void acelerar(int vel) throws DemasiadoRapidoException {
		velocidad += vel;
	}
	
	public static void main(String[] args){
		Vehiculo auto = new Coche("AAAA",4);
		Camion cam = new Camion("BBBB");
		cam.ponRemolque(new Remolque(20));
		//cam.quitaRemolque();
		System.out.println(auto);
		System.out.println(cam);
		
		try {
			cam.acelerar(80);
			System.out.println(cam);
			cam.acelerar(80);
			System.out.println(cam);
		} catch (DemasiadoRapidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
