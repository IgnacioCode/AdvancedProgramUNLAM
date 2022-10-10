import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Pais {
	private String nombre;
	private Set<String> limitrofes;
	private Set<String> transLimitrofes;
	
	public Pais(String nom,Set<String> vecinos) {
		nombre = nom;
		limitrofes = vecinos;
		transLimitrofes = new TreeSet<String>();
	}
	
	public void calculaTransLimitrofes(Map<String,Set<String>> mundo) {
		
		for (String llave : mundo.keySet()) { // O(n)
			if(llave!=nombre && limitrofes.contains(llave)) {
				transLimitrofes.addAll(mundo.get(llave));
			}
		}
		
		transLimitrofes.remove(nombre);
		transLimitrofes.removeAll(limitrofes);
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<String> getLimitrofes() {
		return limitrofes;
	}

	public void setLimitrofes(Set<String> limitrofes) {
		this.limitrofes = limitrofes;
	}

	public Set<String> getTransLimitrofes() {
		return transLimitrofes;
	}

	public void setTransLimitrofes(Set<String> transLimitrofes) {
		this.transLimitrofes = transLimitrofes;
	}
	
}
