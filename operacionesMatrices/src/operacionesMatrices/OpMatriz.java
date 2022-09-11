package operacionesMatrices;

import java.util.Arrays;

public class OpMatriz {

	public static void main(String[] args) {
		
		int[][] miMatriz= { {1,9,10,7,2,1,9,10,7,2,1,9,10,7,2,1,9,10,7,2},
							  {5,-3,2,9,-5,1,9,10,7,2,1,9,10,7,2,1,9,10,7,2},
							  {3,2,-1,5,2,1,9,10,7,2,1,9,10,7,2,1,9,10,7,2}};
		
		//int[][] miMatriz= {{1,9,10,7,2,1,9},{-5,1,9,10,7,2,1},{2,1,3,1,5,2,11}};
		//int[][] miMatriz = {{3,5,1,3}, {1,-3,9,3}, {5,7,9,4},{2,-2,9,1}};
		
		int[] miVector = buscaModasFilas(miMatriz);
		
		imprimeMatriz(miMatriz);
		
		System.out.println(Arrays.toString(miVector));
		
		imprimeDiagonales(miMatriz);
		
		//miMatriz = OpMatriz.sumaAdyacentes(miMatriz);
		
		//imprimeMatriz(miMatriz);
		
			
	}
	
	public static int[][] sumaAdyacentes(int[][] matriz){
		
		int n = matriz.length;
		int m = matriz[0].length;
		
		int[][] matrizAux = new int[n+2][m+2];
		int[][] matrizRes = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrizAux[i+1][j+1] = matriz[i][j];
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				matrizRes[i-1][j-1] = matrizAux[i-1][j] + matrizAux[i][j+1] + matrizAux[i+1][j] + matrizAux[i][j-1] + matrizAux[i][j];
			}
		}
		
		return matrizRes;
	}
	
	public static int[] buscaModasFilas(int[][] matriz) {
		
		int n = matriz.length;
		int[] vecRes = new int[n];
		
		for(int i = 0;i<n;i++) {
			vecRes[i]=buscarModa(matriz[i]);
		}
		
		return vecRes;
	}
	
	public static int buscarModa(int[] vector) {
	        
		int ant = vector[0];
	    int moda = vector[0];
	    int cuenta = 1;
	    int maxCuenta = 1;
		
		Arrays.sort(vector);

	    for (int i = 1; i < vector.length; i++) {
	        if (vector[i] == ant)
	        	cuenta++;
	        else {
	            if (cuenta >= maxCuenta) {
	            	moda = vector[i-1];
	            	maxCuenta = cuenta;
	            }
	            ant = vector[i];
	            cuenta = 1;
	        }
	    }
	    
	    if(cuenta > maxCuenta) {
	    	return vector[vector.length-1];
	    }
	    else {
	    	return moda;
	    }
	    
	}
	
	public static boolean multiNula(int[][] matriz){
		boolean tieneCero = false;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if(matriz[i][j] == 0)
					tieneCero = true;
			}
		}
		
		return tieneCero;
	}
	
	public static void imprimeDiagonales(int[][] matriz) {
		int n = matriz.length;
		int m = matriz[0].length;
		
		int i = n-1;
		int j = 0;
		boolean elementoEsquina = false;
		
		
		for(int k = 0;k<n+m-1;k++){
			elementoEsquina = false;
			if(k<n) {
				i = n - k - 1;
				j = 0;
			}
			else {
				i = 0;
				j = 0 + k -2;
			}
			while(!elementoEsquina){
				System.out.print(matriz[i][j] + " ");
				i++;
				j++;
				if(i>n-1 || j>m-1) {
					elementoEsquina = true;
				}
			}
			System.out.println();
		}
		
	}
	
	public static void imprimeMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.printf("%2d ", matriz[i][j]);
			}
			System.out.println("|");
		}
		System.out.println();
	}
	

}
