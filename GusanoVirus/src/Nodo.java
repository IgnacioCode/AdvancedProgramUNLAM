import java.util.Objects;

public class Nodo {
	
	private int id;

	public Nodo(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Nodo: " + id ;
	}
	
	
	
}
