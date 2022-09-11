package punto;

import java.util.Objects;

public class Punto3D extends Punto2D {
	
	private int z;

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(z);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))	//Aca Compara los atributos de la clase padre entre los objetos
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto3D other = (Punto3D) obj;
		return z == other.z;
	}
	
}
