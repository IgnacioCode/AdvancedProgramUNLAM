import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Reina {
	
	Posicion p;
	List<Posicion> enfrentadas;
	
	public Reina(int x,int y) {
		p = new Posicion(x,y);
		enfrentadas = new LinkedList<Posicion>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(p);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reina other = (Reina) obj;
		return Objects.equals(p, other.p);
	}
	
}
