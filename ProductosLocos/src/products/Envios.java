package products;

import java.util.ArrayList;
import java.util.List;

public class Envios {
	
	private List<Productos> listaProductos;
	
	public Envios(){
		this.listaProductos = new ArrayList<Productos>();
	}
	
	public void añadirProducto(Productos p) {
		this.listaProductos.add(p);
	}
	
	public void mostrarEnvio() {
		for(int i=0;i<this.listaProductos.size();i++) {
			System.out.println(this.listaProductos.get(i));
		}
		
	}
}
