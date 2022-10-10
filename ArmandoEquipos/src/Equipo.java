import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Equipo {
	
	private int cantParticipantes;
	private int cantPreguntas;
	private List<String> respuestas;
	private String patronMax;
	private int afinidad;
	
	public Equipo(int cpar,int cpre,List<String> lista) {
		cantParticipantes = cpar;
		cantPreguntas = cpre;
		respuestas = lista;
	}
	
	public void calculaAfinidad() {
		
		Map<String,Integer> subGrupos = new LinkedHashMap<String,Integer>();
		
		for (int i = 0; i < cantParticipantes; i++) { // O(n^2)
			for (int j = 1; j <= cantPreguntas; j++) { //O(n)
				
				String actual = respuestas.get(i); //O(1)
				String subPatronActual = actual.substring(0, j); //O(1)
				subGrupos.put(subPatronActual, subGrupos.getOrDefault(subPatronActual, 0)+1); //O(1)
				
			}
		}

		int afiMax = 0;
		String llaveMax = "";
		for (String llave : subGrupos.keySet()) { //O(n)
			int afiLeida = (int) (subGrupos.get(llave) * Math.pow(llave.length(),2));
			if(afiLeida > afiMax) {
				afiMax = afiLeida;
				llaveMax = llave;
			}
		}
		
		afinidad = afiMax;
		patronMax = llaveMax;

	}

	public String getPatronMax() {
		return patronMax;
	}

	public int getAfinidad() {
		return afinidad;
	}
	
}
