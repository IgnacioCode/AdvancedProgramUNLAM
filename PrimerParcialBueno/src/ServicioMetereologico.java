import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioMetereologico {
	
	private List<Estacion> estaciones;
	private List<Estacion> estacionesPeores;
	
	public ServicioMetereologico(List<Estacion> estaciones) {
		super();
		this.estaciones = estaciones;
	}

	public void calculaMasHostil() {//O(P^2)
		
		for (int i = estaciones.size()-1; i > 0; i--) {//O(P^2)
			Estacion actual = estaciones.get(i);
			actual.setCantIncomparables(estaciones.size()-i-1-actual.getCantIguales());
			for (int j = i-1; j >= 0; j--) { //O(P)
				Estacion sig = estaciones.get(j);
				comparaHostilidades(actual,sig);
			}
		}
		
		int cantMaxSup = 0;
		
		for (Estacion estacion : estaciones) { //O(P)
			int b = estacion.getCantSuperados();
			if(b>cantMaxSup)
				cantMaxSup = b;
		}
		
		List<Estacion> resultado = new LinkedList<Estacion>();
		
		for (Estacion estacion : estaciones) { //O(P)
			int supActual = estacion.getCantSuperados();
			if(supActual == cantMaxSup)
				resultado.add(estacion);
		}
		
		resultado.sort(new ComparaEstaciones()); //O(P*log(P))
		
		estacionesPeores = resultado;
		
	}

	private static void comparaHostilidades(Estacion actual, Estacion sig) {
		
		int comp = actual.compareTo(sig);
		
		if(comp == 1)
			actual.sumaCantSuperados();
		if(comp == -1)
			actual.sumaCantIncomparables();
		if(comp == 0) {
			actual.sumaCantIguales();
			sig.sumaCantIguales();
		}
			

	}

	public List<Estacion> getEstacionesPeores() {
		return estacionesPeores;
	}
	
	
}
