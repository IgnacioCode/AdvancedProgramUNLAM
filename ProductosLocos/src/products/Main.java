package products;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		Envios miEnvio = new Envios();
		
		//Date fecha = new Date(2022, 5, 12);
		//Date fecha2 = new Date(2026,1,25);
		
		LocalDate fecha = LocalDate.of(2022, 5, 12);
		LocalDate fecha2 = LocalDate.of(2026, 2, 25);
		
		
		Productos miProducto1 = new Productos(fecha2,1001,fecha,"Leche","Argentina");
		Congelados miProducto2 = new Congelados(fecha2,1002,fecha,"Cafe","Colombia",0.7);
		Refrigerados miProducto3 = new Refrigerados(fecha2,1013,fecha,"Chocolate","Mexico",0.3,"CompaniaRefri");
		Congelados miProducto4 = new Congelados(fecha2,1010,fecha,"Chocolatada","EEUU",0.5);
		
		
		miEnvio.añadirProducto(miProducto1);
		miEnvio.añadirProducto(miProducto2);
		miEnvio.añadirProducto(miProducto3); 
		miEnvio.añadirProducto(miProducto4);
		
		miEnvio.mostrarEnvio();
		
		
	}

}
