package products;

import java.time.LocalDate;

public class CNitrogeno extends Congelados {
	
	
	public CNitrogeno(LocalDate f, int nroLote, LocalDate fechaEnv, String nombre, String paisO, double tempMan,String metodo,double tiempo) {
		super(f, nroLote, fechaEnv, nombre, paisO, tempMan);
		this.metodoCon=metodo;
		this.tiempoCon=tiempo;
	}
	private String metodoCon;
	private double tiempoCon;
}
