package products;

import java.time.LocalDate;

public class CAire extends Congelados {
	
	public CAire(LocalDate f, int nroLote, LocalDate fechaEnv, String nombre, String paisO, double tempMan,double nitro,double oxi,double dioCar,double vapor) {
		super(f, nroLote, fechaEnv, nombre, paisO, tempMan);
		this.nitrogeno=nitro;
		this.oxigeno=oxi;
		this.dioCarbono=dioCar;
		this.vapor=vapor;
	}
	private double nitrogeno;
	private double oxigeno;
	private double dioCarbono;
	private double vapor;
	
}
