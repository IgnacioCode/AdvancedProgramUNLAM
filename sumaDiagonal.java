class Main {
	public static void main(String[] args) {
		int[][] miMatriz = {{1,2,3},{-1,5,10},{2,6,-3}};
		int n = miMatriz.length;
		int[n] diagonalPrincipal;
		
		for(int i=0;i<n;i++){
			diagonalPrincipal[i] = miMatriz[i][i];			
		}

		bool diagonalCorrecta = checkeaSumas(diagonalPrincipal);
		
		if(diagonalCorrecta){
			System.out.println("La matriz cumple con la condicion");
		}
		else{
			System.out.println("La matriz no cumple con la condicion");
		}
	
	}
	
	public bool checkeaSumas(int[] diagonal){
		for(int i = 1;i<diagonal.length;i++){
			if(diagonal[i] != sumaHastaPos(diagonal,i-1)){
				return false;
			}
		}
		return true;
	}

	public int sumaHastaPos(int[] vector,int pos){
		int buffer=vector[0];
		for(int i = 1;i<=pos<i++){
			buffer=+vector[i];
		}
		return buffer;
	}


}