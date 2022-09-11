package products;

import java.time.LocalDate;

public class Productos {
	
	private LocalDate fechaCaducidad;
	private int nroLote;
	private LocalDate fechaEnvasado;
	private String nombre;
	private String paisOrigen;
	
	public Productos(LocalDate f,int nroLote,LocalDate fechaEnv,String nombre,String paisO) {
		this.fechaCaducidad=f;
		this.nroLote=nroLote;
		this.fechaEnvasado=fechaEnv;
		this.nombre=nombre;
		this.paisOrigen=paisO;
	}

	@Override
	public String toString() {
		return this.nombre + "|" + this.nroLote + "|"  + this.fechaEnvasado + "|" + this.paisOrigen;
	}
}
