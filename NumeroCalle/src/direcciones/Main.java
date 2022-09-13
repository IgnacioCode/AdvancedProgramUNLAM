package direcciones;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
	
	public static int metodo1(long n){
		if(n<3) return -1;
		for(int i=2; i<=n; i++){
			int sumaIzq=0;
			for (int j=1; j<i;j++)
				sumaIzq+=j;
			int sumaDer=0;
			for (int k=i+1; k<=n;k++)
				sumaDer+=k;
			if(sumaDer==sumaIzq)return i;
		}
		return -1;

	}

	public static long metodo2(long n) {

		
		long sumaTotal = (long) sumaHastaPos(n);
		long nroCasa=-1;
		
		for(long i=1;i<n;i++) {
			long sumIzq = (long) sumaHastaPos(i) - i;
			long sumDer = sumaTotal - sumIzq - i;
			if(sumIzq==sumDer) {
				nroCasa=i;
				break;
			}
		}
		
		
		return nroCasa;

	}
	
	public static double sumaHastaPos(double n) {
		return (n*(n+1))/2;
	}
	
	
	public static long metodo3(long n) {
		
		long sumaN = (long) sumaHastaPos(n);
		return (long) Math.sqrt(sumaN);
	}

	public static void main(String[] args) {
		
		long n=332928;
		
		Calendar tIni = new GregorianCalendar();
		System.out.println(metodo3(n));
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("Tiempo de ejecución del metodo 3  "+diff);
		System.out.println("-----------------------------------------");

		tIni = new GregorianCalendar();
		System.out.println(metodo2(n));
		tFin = new GregorianCalendar();
		diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("Tiempo de ejecución del metodo2  "+diff);
		System.out.println("-----------------------------------------");

		tIni = new GregorianCalendar();
		System.out.println(metodo1(n));
		tFin = new GregorianCalendar();
		diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("Tiempo de ejecución del metodo 1  "+diff);
		
		//Esto es un cambio
		
		
	}
}
