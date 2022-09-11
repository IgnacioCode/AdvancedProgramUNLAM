package products;

import java.time.LocalDate;

public class CAgua extends Congelados {
	

	public CAgua(LocalDate f, int nroLote, LocalDate fechaEnv, String nombre, String paisO, double tempMan, double salinidad) {
		super(f, nroLote, fechaEnv, nombre, paisO, tempMan);
		this.salinidad=salinidad;
	}

	private double salinidad;
}
