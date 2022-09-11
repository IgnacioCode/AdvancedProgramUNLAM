package operacionesMatrices;

public class Base {
	
	private int[] vector;
	
	public Base(int[] vec) {
		vector = vec;
	}
	
	public Base sumaPosiciones() {
		int[] nuevoVec = new int[vector.length];
		for(int i=0;i<vector.length;i++) {
			nuevoVec[i] = sumaHastaPos(vector,i);
		}
		return new Base(nuevoVec);
	}
	
	static public int sumaHastaPos(int[] vector,int pos){
		int buffer=vector[0];
		for(int i = 1; i<=pos ; i++){
			buffer+=vector[i];
		}
		return buffer;
	}
	
	public String toString() {
		String buffer = "[";
		for(int i = 0;i<this.vector.length;i++) {
			buffer += " "+this.vector[i];
		}
		buffer+=" ]";
		return buffer;
	}
	
}
