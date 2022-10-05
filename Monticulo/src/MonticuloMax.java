
import java.util.ArrayList;

public class MonticuloMax {

	private ArrayList<Integer> monticulo;
	private int tamanio;
	
	public MonticuloMax(ArrayList<Integer> monticulo) {
		this.monticulo = new ArrayList<Integer>();
		this.monticulo = monticulo;
		this.tamanio = monticulo.size();
		
		// verifica que el mont�culo cumpla la propiedad de mont�culo
		// si no la cumple, lo "reacomoda"
		for (int i = 0; i < this.tamanio; i++) {
			subirNodo(i);
		}

	}
	
	public void insertarNodo(int valor) {
		//se agrega el nuevo nodo al final del mont�culo
		this.monticulo.add(valor);
		int posicion = this.tamanio;
		
		// verifica que el mont�culo cumpla la propiedad de mont�culo
		// si no la cumple, lo intercambia el nodo hasta que se cumpla
		subirNodo(posicion);
		this.tamanio++;
	}

	public int eliminarNodo() {
		// elimina el nodo ra�z
		int raiz = this.monticulo.remove(0);
		this.tamanio--;
		
		// pone como ra�z al �ltimo nodo del mont�culo
		this.monticulo.add(0, this.monticulo.remove(this.tamanio-1));
		int posicion = 0;
		
		int hijoIzq, hijoDer, padre;
		
		do {
			
			hijoIzq = 2 * posicion + 1;
			hijoDer = 2 * posicion + 2;
			padre = posicion;

			// verifica que se cumpla la propiedad de mont�culo
			if(hijoIzq < this.tamanio && this.monticulo.get(hijoIzq) > this.monticulo.get(posicion))
				posicion = hijoIzq;
			if(hijoDer < this.tamanio && this.monticulo.get(hijoDer) > this.monticulo.get(posicion))
				posicion = hijoDer;
			
			// si no se cumple, intercambia con el nodo de mayor valor
			if(posicion != padre) {
				int auxiliar = this.monticulo.get(posicion);
				this.monticulo.set(posicion, this.monticulo.get(padre));
				this.monticulo.set(padre, auxiliar);
			}
			
		} while(posicion != padre);
		
		// retorna el nodo ra�z que se extrajo al inicio
		return raiz;
	}
	
	public int obtenerRaiz() {
		return this.monticulo.get(0);
	}
	
	private void subirNodo(int posicion) {
		while(posicion > 0 && this.monticulo.get(posicion) > this.monticulo.get((int)(posicion-1)/2)) {
			int auxiliar = this.monticulo.get(posicion);
			this.monticulo.set(posicion, this.monticulo.get((int)((posicion-1)/2)));
			this.monticulo.set((int)((posicion-1)/2), auxiliar);
			posicion = (int)((posicion-1)/2);
		}
	}
	
	public void mostrarMonticulo() {
			System.out.println(this.monticulo);
	}
	
public static void main(String[] args) {

		// se crea un array y se le agregan los nodos del monticulo
		ArrayList<Integer> montMax = new ArrayList<Integer>();		
		montMax.add(15);
		montMax.add(2);
		montMax.add(12);
		montMax.add(25);
		montMax.add(8);
		montMax.add(56);
		
		MonticuloMax monticuloMaximos = new MonticuloMax(montMax);
		monticuloMaximos.mostrarMonticulo();
		
		monticuloMaximos.insertarNodo(60);
		monticuloMaximos.mostrarMonticulo();
		
		monticuloMaximos.insertarNodo(30);
		monticuloMaximos.mostrarMonticulo();
		
		System.out.println("Nodo eliminado: " + monticuloMaximos.eliminarNodo());
		monticuloMaximos.mostrarMonticulo();
		
		System.out.println("Nodo eliminado: " + monticuloMaximos.eliminarNodo());
		monticuloMaximos.mostrarMonticulo();
		
		System.out.println("Raiz: " + monticuloMaximos.obtenerRaiz());

	}
	
}