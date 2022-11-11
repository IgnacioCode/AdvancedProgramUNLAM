
public class Segmento implements Comparable<Segmento>{
	
	private int id;
	private int inicio;
	private int fin;
	
	

	public Segmento(int id, int inicio, int fin) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
	}

	public int diferencia(Segmento s2) {
		return fin-s2.inicio+1;
	}

	@Override
	public int compareTo(Segmento o) {
		if(inicio>o.inicio) {
			return 1;
		}
		else if(inicio<o.inicio) {
			return -1;
		}
		else if(inicio == o.inicio && fin > o.fin) {
			return 1;
		}
		else if(inicio == o.inicio && fin < o.fin) {
			return -1;
		}
		else {
			return 0;
		}
		
	}

	public int getId() {
		return id;
	}

	public int getInicio() {
		return inicio;
	}

	public int getFin() {
		return fin;
	}
	
	
	
}
