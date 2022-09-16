package vectorSumas;

public class Main {

	public static void main(String[] args) {
		
		int[] miVector = {1,2,3};
		
		int[] nuevoVector = vectorSumas(miVector);
		
		for (int i : nuevoVector) {
			System.out.print(i+" ");
		}
		
	}
	
	public static int[] vectorSumas(int[] vector) {
		
		int sumaTotal = 0;
		int[] vecRes = new int[vector.length];
		
		for (int i : vector) {
			sumaTotal+=i;
		}
		
		for (int i = 0; i < vecRes.length; i++) {
			vecRes[i] = sumaTotal - vector[i];
		}
		
		return vecRes;
	}

}
