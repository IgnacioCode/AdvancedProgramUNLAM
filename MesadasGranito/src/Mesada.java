
public class Mesada implements Comparable<Mesada>{
	
	private int largo;
	private int ancho;

	@Override
	public int compareTo(Mesada o) {
			if(largo > o.largo) {
				return -1;
			}
			else if(largo == o.largo) {
				return -(ancho-o.ancho);
			}
			return 1;
	}
	
	public Mesada(int v1,int v2) {
		if(v1>v2) {
			largo = v1;
			ancho = v2;
		}
		else {
			largo = v2;
			ancho = v1;
		}
	}

	public int getLargo() {
		return largo;
	}

	public int getAncho() {
		return ancho;
	}
	
	
}
