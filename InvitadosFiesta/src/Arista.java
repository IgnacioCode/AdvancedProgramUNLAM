
public class Arista {
	private int origen;
	private int destino;
	
	public Arista(int origen, int destino) {
		super();
		this.origen = origen;
		this.destino = destino;
	}
	public int getOrigen() {
		return origen;
	}
	public int getDestino() {
		return destino;
	}
	@Override
	public String toString() {
		return "A [origen=" + origen + ", destino=" + destino + "]";
	}
	
	
}
