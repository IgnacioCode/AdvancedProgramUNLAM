package products;

import java.time.LocalDate;

public class Congelados extends Productos {
	
	public Congelados(LocalDate f, int nroLote, LocalDate fechaEnv, String nombre, String paisO,double tempMan) {
		super(f, nroLote, fechaEnv, nombre, paisO);
		this.tempMantenimiento=tempMan;
	}

	private double tempMantenimiento;
	
	@Override
	public String toString() {
		return super.toString() + "|" + this.tempMantenimiento;
	}
	
	
}
