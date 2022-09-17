package mundo;

public class Erseanian extends Raza{
	
	
	
	public Erseanian(int x) {
		this.saludActual=63;
		this.danioBasico=99;
		this.danioActual=99;
		this.rangoMinimo=0;
		this.rangoMaximo=5;
		this.posicion=x;
		
	}
	

	@Override
	public void atacar(Raza enemigo) {
		if(this.calcularDistancia(enemigo) <= this.rangoMaximo && this.calcularDistancia(enemigo) >= this.rangoMinimo) {
			enemigo.saludActual-=this.danioBasico;
			this.saludActual*=1.02;
		}
		
	}
	
	@Override
	public void recibirAtaque(int danio) {
		this.saludActual-=danio;
		this.danioActual = this.danioBasico;
	}

	@Override
	public void descansar() {

	}



}
