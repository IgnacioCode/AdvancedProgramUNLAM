package mundo;

public class Rocnes extends Raza {

    private int cantidadAtaquesBuffeados;

	private int cantidadAtaques;

    public Rocnes(int x) {
        this.posicion = x;
        this.saludMaxima = 118;
        this.saludActual = 118;
        this.danioBasico = 81;
        this.rangoMinimo = 0;
        this.rangoMaximo = 6;
        this.danioActual = 81;
        this.cantidadAtaquesBuffeados = 0;
        this.cantidadAtaques = 0;
    }

    @Override
    public void atacar(Raza enemigo) {
        cantidadAtaques++;
        if(this.calcularDistancia(enemigo) <= this.rangoMaximo && this.calcularDistancia(enemigo) >= this.rangoMinimo) {
        	
		    if (cantidadAtaques % 3 == 0) {
		        enemigo.recibirAtaque(danioActual * 5 / 8);
		        cantidadAtaques = 0;
		    } else {
		        enemigo.recibirAtaque(danioActual);
		    }
		    if (cantidadAtaquesBuffeados > 0) {
		        cantidadAtaquesBuffeados--;
		        if (cantidadAtaquesBuffeados == 0) {
		            danioActual = danioBasico;
		        }
		    }
        }

    }

    @Override
    public void recibirAtaque(int dmg) {
        this.saludActual -= 2 * dmg;
    }

    @Override
    public void descansar() {
        cantidadAtaquesBuffeados = 2;
        danioActual *= 4;
    }
    
    public int getCantidadAtaquesBuffeados() {
		return cantidadAtaquesBuffeados;
	}

	public void setCantidadAtaquesBuffeados(int cantidadAtaquesBuffeados) {
		this.cantidadAtaquesBuffeados = cantidadAtaquesBuffeados;
	}
    
    
}