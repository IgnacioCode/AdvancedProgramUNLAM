import java.util.Objects;

public class Nodo implements Comparable<Nodo>{
	
	private int id;
	private int cantAdyacentes;
	
	
	public Nodo(int id) {
		super();
		this.id = id;
	}

	@Override
	public int compareTo(Nodo o) {
		return o.cantAdyacentes - this.cantAdyacentes;
	}
	
	
	@Override
	public String toString() {
		return "Nodo [id=" + id + "]";
	}

	public void addCantAdyacentes() {
		cantAdyacentes++;
	}

	public int getId() {
		return id;
	}
	
	
}
