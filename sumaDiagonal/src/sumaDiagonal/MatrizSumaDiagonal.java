package sumaDiagonal;

public class MatrizSumaDiagonal {

	public static void main(String[] args) {
		
		int[][] miMatriz = {{7,2,3,6},{-1,7,10,1},{2,3,14,9},{1,2,5,28}};
		int n = miMatriz.length;
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				System.out.print(miMatriz[i][j] + " ");
			}
			System.out.println();
		}

		boolean diagonalCorrecta = checkeaSumas(miMatriz,n);
		
		if(diagonalCorrecta){
			System.out.println("La matriz cumple con la condicion");
		}
		else{
			System.out.println("La matriz no cumple con la condicion");
		}
		
	
	}
	
	static public boolean checkeaSumas(int[][] matrizDiagonal, int n){
		
		int[] diagonalPrincipal = new int[n];
		
		for(int i=0;i<n;i++){
			diagonalPrincipal[i] = matrizDiagonal[i][i];			
		}
		
		for(int i = 1;i<diagonalPrincipal.length;i++){
			if(diagonalPrincipal[i] != sumaHastaPos(diagonalPrincipal,i-1)){
				return false;
			}
		}
		return true;
	}

	static public int sumaHastaPos(int[] vector,int pos){
		int buffer=vector[0];
		for(int i = 1; i<=pos ; i++){
			buffer+=vector[i];
		}
		return buffer;
	}
	
}


