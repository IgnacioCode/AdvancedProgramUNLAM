
public class Arista implements Comparable<Arista>{
	
	private int origen;
	private int destino;
	private int peso;
	
	public Arista(int origen, int destino, int peso) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}

	@Override
	public int compareTo(Arista o) {
		return this.peso-o.peso;
	}

	@Override
	public String toString() {
		return "A [origen=" + origen + ", destino=" + destino + ", peso=" + peso + "]";
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}
	
	
	
}
