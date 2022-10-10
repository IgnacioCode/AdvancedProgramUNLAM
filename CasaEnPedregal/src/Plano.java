import java.io.IOException;

public class Plano {

	private int dx;
	private int dy;
	private int[][] mapa;
	private Casa casita;
	
	public static void main(String[] args) throws IOException { //O(n^2 * m^2)
		
		Plano miPlano =  GestionArchivo.leerArchivo("casaGrande.in"); // O(n)
		Arquitecto constructor = new Arquitecto(); //O(1)
		constructor.posicionaCasa(miPlano); //O(n^2 * m^2)
		System.out.println(miPlano.getCasita().getPosX()+" "+miPlano.getCasita().getPosY() + " "+ miPlano.getCasita().getOrientacion());
		GestionArchivo.escribeArchivo(miPlano, "casaGrande.out"); //O(1)
		
	}

	public Plano(int dx, int dy, Casa casita,int[][] mapita) {
		super();
		this.dx = dx;
		this.dy = dy;
		this.casita = casita;
		mapa = mapita;
	} 

	public Casa getCasita() {
		return casita;
	}

	public void setCasita(Casa casita) {
		this.casita = casita;
	}

	public int[][] getMapa() {
		return mapa;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}
	
	
	
}
