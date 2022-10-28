import java.util.Iterator;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		/*
		Random r1 = new Random();
		
		int wins = 0;
		float i = 0;
		float[] results = new float[30];
		
		for (int j = 0; j < results.length; j++) {
			wins = 0;
			for (i = 0; i < 100_000_00; i++) {
				
				int x1 = r1.nextInt(0, 101);
				int x2 = r1.nextInt(0, 101);
				
				if(x1>x2)
					wins++;
			}
			
			System.out.println(wins/i);
			results[j] = wins/i;
		}
		float acum = 0;
		for (int j = 0; j < results.length; j++) {
			acum += results[j];
		}
		System.out.println("------------------------------------");
		System.out.println(acum / results.length);
		*/
		float resAnt = 1;
		for (int dim = 2; dim < 41; dim++) {
			
			float acum = 0;
			
			for (int i = 0; i < 101; i++) {
				acum+= Math.pow(i, dim-1);
			}
			
			System.out.println(acum/Math.pow(101, dim) + " | " +(1-(acum/Math.pow(101, dim))/resAnt) + " | " + (1/(float)dim) + " | " + dim);
			
			resAnt = (float) (acum/Math.pow(101, dim));
		}
	}
}
