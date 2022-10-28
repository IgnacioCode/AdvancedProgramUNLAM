import java.util.Objects;

public class Nodo implements Comparable<Nodo>{
	
	private int id;
	private int color;
	private int cantAdyacentes;
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getId() {
		return id;
	}
	
	public Nodo(int id) {
		super();
		this.id = id;
		this.color = -1;
	}

	@Override
	public int compareTo(Nodo o) {
		return o.cantAdyacentes - this.cantAdyacentes;
	}
	
	public void addCantAdyacentes() {
		cantAdyacentes++;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantAdyacentes, color, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		return cantAdyacentes == other.cantAdyacentes && color == other.color && id == other.id;
	}

	@Override
	public String toString() {
		return "Nodo [id=" + id + ", color=" + color + "]";
	}
	
	
	
}
