package mundo;

public class Cilnine extends Raza {
    
	private boolean puedeAtacar;
    private int ataquesDados;
    
    public Cilnine(int x) {
        this.posicion = x;
        this.puedeAtacar = true;
        this.saludMaxima = 76;
        this.saludActual = 76;
        this.danioBasico = 66;
        this.rangoMinimo = 16;
        this.rangoMaximo = 25;
        this.ataquesDados = 0;
    }

    public boolean isPuedeAtacar() {
		return puedeAtacar;
	}

	public void setPuedeAtacar(boolean puedeAtacar) {
		this.puedeAtacar = puedeAtacar;
	}

	@Override
    public void atacar(Raza enemigo) {
    	if(this.puedeAtacar) {
    	  int distancia = calcularDistancia(enemigo);
    	      if (distancia >= rangoMinimo && distancia <= rangoMaximo) {
    	           enemigo.recibirAtaque(this.danioBasico + 2 * this.ataquesDados);
    	           this.ataquesDados++;
    	      }
    	}
       
    }

    @Override
    public void recibirAtaque(int dmg) {
        this.puedeAtacar = true;
        this.saludActual -= dmg * 2 / 3;
    }

    @Override
    public void descansar() {
        this.puedeAtacar = false;
        this.saludMaxima += 33;
        this.saludActual += 33;

    }
  
}
