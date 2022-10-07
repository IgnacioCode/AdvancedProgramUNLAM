import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Tren {
	
	private List<Especie> listaEspecies;
	private int limiteAgresividad;
	private int agresividadMax;
	private int cantVagones;
	
	public Tren(List<Especie> le,int ma) {
		listaEspecies = le;
		limiteAgresividad  = ma;
		cantVagones = 0;
	}
	
	public static void main(String[] args) throws IOException {	// O(n*log(n))
		Tren miTren = GestionArchivo.cargaArchivo("enunciado6.in"); // O(n)
		miTren.resuelveVagones(); // O(n*log(n)) 
		GestionArchivo.escribeArchivo("enunciado6.out",miTren); // O(1)
	}

	private void resuelveVagones() {
		Collections.sort(listaEspecies);; // O(n*log(n))
		int agreActual = listaEspecies.get(0).getAgresividad();
		int limActual = limiteAgresividad + agreActual;
		int agreMaxima = 0;
		int i = 1;
		for (i = 1; i < listaEspecies.size(); i++) { // O(n)
			Especie leido = listaEspecies.get(i);
			if(leido.getAgresividad() > limActual) {
				
				int agreAnterior = listaEspecies.get(i-1).getAgresividad() - agreActual;
				if(agreAnterior > agreMaxima)
					agreMaxima = agreAnterior;
				
				agreActual = leido.getAgresividad();
				limActual = limiteAgresividad + agreActual;
				cantVagones++;
			}
			
		}
		int agreAnterior = listaEspecies.get(i-1).getAgresividad() - agreActual;
		if(agreAnterior > agreMaxima)
			agreMaxima = agreAnterior;
		
		cantVagones++;
		agresividadMax = agreMaxima;
				
	}

	public int getLimiteAgresividad() {
		return limiteAgresividad;
	}

	public void setLimiteAgresividad(int limiteAgresividad) {
		this.limiteAgresividad = limiteAgresividad;
	}

	public int getAgresividadMax() {
		return agresividadMax;
	}

	public void setAgresividadMax(int agresividadMax) {
		this.agresividadMax = agresividadMax;
	}

	public int getCantVagones() {
		return cantVagones;
	}

	public void setCantVagones(int cantVagones) {
		this.cantVagones = cantVagones;
	}

	
}
