package punto;

import java.util.Objects;

public class Punto2D {
	
	private int x;
	private int y;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto2D other = (Punto2D) obj;
		return x == other.x && y == other.y;
	}
	
}
