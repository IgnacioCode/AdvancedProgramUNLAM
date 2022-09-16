
public class Corredor {

	public static void main(String[] args) {
		
		int[] miRecorrido = {15,67,89,41,94};
		
		System.out.println(jinetes(miRecorrido));
		

	}
	
	public static int jinetes(int[] estaciones) {
		
		int dis = 0;
		int jinetes = 1;
		for(int i=0;i<estaciones.length;i++) {
			dis+=estaciones[i];
			if(dis>100) {
				dis=estaciones[i];
				jinetes++;
			}
		}
		
		return jinetes;
	}
	
}
