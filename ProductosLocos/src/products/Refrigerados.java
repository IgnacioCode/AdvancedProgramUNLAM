package products;

import java.time.LocalDate;

public class Refrigerados extends Congelados {
	
	public Refrigerados(LocalDate f, int nroLote, LocalDate fechaEnv, String nombre, String paisO,double tempMan,String codOrg) {
		super(f, nroLote, fechaEnv, nombre, paisO, tempMan);
		this.codOrg=codOrg;
	}

	private String codOrg;
	
	@Override
	public String toString() {
		return super.toString() + "|" + this.codOrg;
	}
	
}
