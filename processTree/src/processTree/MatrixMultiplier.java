package processTree;

import java.util.Random;

public class MatrixMultiplier implements Runnable 
{

  private int[][] matrix1;
  private int[][] matrix2;
  private int[][] result;
  private int row;

  public MatrixMultiplier(int[][] matrix1, int[][] matrix2, int[][] result, int row) 
  {
    this.matrix1 = matrix1;
    this.matrix2 = matrix2;
    this.result = result;
    this.row = row;
  }
  
  public static int[][] multiplyNormal(int[][] matrix1, int[][] matrix2) 
  {
   int n = matrix1.length;
   int[][] result = new int[n][n];
   for (int i = 0; i < n; i++) 
   {
	   for (int j = 0; j < n; j++) 
	   {
	 	   for (int k = 0; k < n; k++) 
	 	   {
	 		   result[i][j] += matrix1[i][k] * matrix2[k][j];
	 	   }
	   }
   }
  return result;
  }
  
  public void multiply(int row) 
  {
    int n = matrix1.length;
    for (int j = 0; j < n; j++) 
    {
      for (int k = 0; k < n; k++) 
      {
        result[row][j] += matrix1[row][k] * matrix2[k][j];
      }
    }
  }

  @Override
  public void run() 
  {
    multiply(row);
  }

  private static int[][] generateRandomMatrix(int n) 
  {
    int[][] matrix = new int[n][n];
    Random rand = new Random();
    
    for (int i = 0; i < n; i++) 
    {
      for (int j = 0; j < n; j++) 
      {
        matrix[i][j] = rand.nextInt(65) - 32;
      }
    }
    return matrix;
  }

  private static void printMatrix(int[][] matrix) 
  {
	  int n = matrix.length;
	  int maxLength = Integer.MIN_VALUE;
	  
	  for (int i = 0; i < n; i++) 
	  {
	    for (int j = 0; j < n; j++) 
	    {
	      int length = String.valueOf(matrix[i][j]).length();
	      if (length > maxLength) 
	      {
	        maxLength = length;
	      }
	    }
	  }
	  
	  String format = "%" + (maxLength + 1) + "d";
	  
	  for (int i = 0; i < n; i++) 
	  {
	    for (int j = 0; j < n; j++) 
	    {
	      System.out.printf(format, matrix[i][j]);
	    }
	    System.out.println();
	  }
  }
  
  public static boolean areEqual(int[][] matrix1, int[][] matrix2)
  {
      if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length)
      {
          return false;
      }

      for (int i = 0; i < matrix1.length; i++)
      {
          for (int j = 0; j < matrix1[0].length; j++)
          {
              if (matrix1[i][j] != matrix2[i][j])
              {
                  return false;
              }
          }
      }

      return true;
  }


  public static void main(String[] args) 
  {
	Random ranGen = new Random();
    int n = ranGen.nextInt(5, 20);
	int[][] matrix1 = generateRandomMatrix(n);
    int[][] matrix2 = generateRandomMatrix(n);
    int[][] CH = new int[n][n];
    int[][] CS = new int[n][n];
    
    CS = multiplyNormal(matrix1, matrix2);
    
    //Design Pattern de LINEA DE ENSAMBLAJE
    MatrixMultiplier[] multipliers = new MatrixMultiplier[n];
    Thread[] threads = new Thread[n];
    
    for (int i = 0; i < n; i++) 
    {
      multipliers[i] = new MatrixMultiplier(matrix1, matrix2, CH, i);
      threads[i] = new Thread(multipliers[i]);
      threads[i].start();
    }
    try 
    {
      for (int i = 0; i < n; i++) 
      {
        threads[i].join();
      }
    } 
    catch (InterruptedException e) 
    {
      e.printStackTrace();
    }
    
    System.out.println("Matriz 1:");
    printMatrix(matrix1);
    System.out.println("Matriz 2:");
    printMatrix(matrix2);
    System.out.println("Resultado Secuencial:");
    printMatrix(CS);
    System.out.println("Resultado Concurrente:");
    printMatrix(CH);
    
    if(areEqual(CS, CH))
    	System.out.println("Las matrices son iguales!");
    else
    	System.out.println("Las matrices no son iguales :(");
    
  }



}
