package mundo;

public abstract class Raza {
		
		protected int saludActual;
		protected int saludMaxima;
		
		//protected String arma;
		
		protected int rangoMaximo;
		protected int rangoMinimo;
		protected int danioBasico;
		protected int danioActual;
		
		protected int posicion;
		protected boolean envenenado;
		
		public  abstract void atacar(Raza raza);
		public abstract void recibirAtaque(int danio);
		public abstract void descansar();
		
		
		public int calcularDistancia(Raza enemigo){
	        return Math.abs(enemigo.posicion - this.posicion);
	    }
		//public abstract void activarEfecto(Raza raza);
	
}
