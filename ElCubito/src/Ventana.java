import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class Ventana extends Canvas{
	
	private int cantNodos;
	
	private final double radio=200;
	private double radioNodo = 50;
	private double centroX = 250 - radioNodo/2;
	private double centroY = 250 - radioNodo/2;
	
	private Grafo grafo;
	final int inf = Integer.MAX_VALUE;
	
	public Ventana(int cantNodos,Grafo grafo) {
		super();
		this.cantNodos = cantNodos;
		this.grafo = grafo;
		/*
		this.radioNodo = radioNodo/(cantNodos-2);
		centroX = 250 - radioNodo/2;
		centroY = 250 - radioNodo/2;
		*/
	}

	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		//g.drawLine(250, 0, 250, 500);
		//g.drawLine(0, 250, 500, 250);
		
		double[] puntosX = new double[cantNodos];
		double[] puntosY = new double[cantNodos];
		
		double angulo = 2*Math.PI/cantNodos;
		
		for (int i = 0; i < cantNodos; i++) {
			double proximoX = centroX + radio*Math.cos(i*angulo-Math.PI/2);
			double proximoY = centroY + radio*Math.sin(i*angulo-Math.PI/2);
			
			puntosX[i] = proximoX;
			puntosY[i] = proximoY;
			
		}
		
		for (int i = 0; i < cantNodos; i++) {
			int origenXActual = (int) puntosX[i];
			int origenYActual = (int) puntosY[i];
			for (int j = i+1; j < puntosY.length; j++) {
				int destinoX = (int) puntosX[j];
				int destinoY = (int) puntosY[j];
				if(grafo.getAdyacentes()[i][j] != inf)
					g.drawLine((int)(origenXActual+radioNodo/2), (int)(origenYActual+radioNodo/2), (int)(destinoX+radioNodo/2), (int)(destinoY+radioNodo/2));
			}
		}
		
		
		
		for (int i = 0; i < cantNodos; i++) {
			double proximoX = 0;
			double proximoY = 0;
			proximoX = puntosX[i];
			proximoY = puntosY[i];
			
			g.setColor(new Color(255,75,190));
			g.drawOval((int)proximoX,(int)proximoY,(int)radioNodo,(int)radioNodo);
			g.fillOval((int)proximoX,(int)proximoY,(int)radioNodo,(int)radioNodo);
			
			g.setColor(Color.white);
			String num = (i+1)+"";
			g.drawString(num, (int) ((int)proximoX+radioNodo/2 - 3*num.length()), (int) ((int)proximoY+5+radioNodo/2));
		}
		
		
	}
	
	
	
}
