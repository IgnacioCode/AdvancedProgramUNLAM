
import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		final int inf = Integer.MAX_VALUE;
		
		int cantNodos = 6;
		int[][] mat = {
				{inf,1,inf,1,1,inf},
				{1,inf,inf,1,1,inf},
				{1,inf,inf,1,1,inf},
				{inf,inf,1,inf,1,inf},
				{1,1,1,inf,inf,inf},
				{inf,inf,inf,inf,inf,inf}
		};
		
		
		/*
		int cantNodos = 3;
		int[][] mat = {
				{inf,1,inf},
				{1,inf,inf},
				{1,inf,inf},
		};
		*/
		/*
		int cantNodos = 12;
		int[][] mat = {
			{inf ,1 ,1,inf,inf,1	 ,1	, 1,inf,inf,inf,1},
			{1	,inf	  ,1	,inf	,inf	  ,1	,inf	  ,1	,inf	  ,1	  ,1	,inf},
			{1	  ,1	,inf	  ,1	,inf	  ,1	 , 1	 , 1	,inf	,  1	,  1	 , 1},
			{inf	,inf	,  1,	inf	  ,1	 , 1	,inf,	inf	  ,1	,inf	,inf	,inf},
			{inf,	inf	,inf	,  1	,inf	,  1	,inf	,  1	,  1,	  1	, 1	 , 1},
			{1	  ,1	  ,1,	  1	,  1,	inf	,  1,	  1	,inf,	  1,	inf	,  1},
			{1	,inf,	  1,	inf,	inf	,  1,	inf	 , 1,	  1,	inf,	  1,	inf},
			{1	 , 1	,  1	,inf,	  1	 , 1,	  1	,inf	,  1	,  1,	  1	,  1},
			{inf	,inf,	inf	,  1,	  1,	inf,	  1	,  1	,inf,	  1,	inf	,inf},
			{inf,	  1,	  1,	inf	,  1,	  1	,inf	,  1	,  1,	inf	,  1	,  1},
			{inf,	  1,	  1,	inf,	  1,	inf,	  1	,  1	,inf	,  1,	inf	,  1},
			{1,	inf	,  1	,inf,	  1,	  1	,inf	,  1,	inf	 , 1,	  1	,inf},
		};
		*/
		
		Grafo miGrafo = new Grafo(mat);
		Ventana dibujo = new Ventana(cantNodos,miGrafo);
		Cubo cubito = new Cubo(Math.PI/4);
		
		JFrame marco = new JFrame("Canvas");
		
		marco.setSize(500, 500);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int it = 4;
		
		for (int i = 0; i < it; i++) {
			Cubo cubitosLocos = new Cubo(i*Math.PI/it);
			
			marco.add(cubitosLocos);
			
			System.out.println("hola"+i);
		}
		
		//marco.add(cubito);
	}
}
