
public class Especie implements Comparable<Especie>{
	private String nom;
	private int agresividad;
	
	public Especie(String nombre,int agre) {
		 nom = nombre;
		 agresividad = agre;
	}

	@Override
	public int compareTo(Especie o) {
		// TODO Auto-generated method stub
		return this.agresividad - o.agresividad;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAgresividad() {
		return agresividad;
	}

	public void setAgresividad(int agresividad) {
		this.agresividad = agresividad;
	}
	
	
}
