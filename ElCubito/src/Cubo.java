import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Cubo extends Canvas{
	
	final int tamX = 500;
	final int tamY = 500;
	final int L = 300;
	
	final int radio = 150;
	int iniX = 60;
	int iniY = 120;
	
	final int desX = L/2;
	final int desY = L/3;
	private double angulo;
	
	int[] puntosX = new int[4];
	int[] puntosY = new int[4];
	
	public Cubo(double angulo) {
		
		this.angulo = angulo;
		
		for (int i = 0; i < 4; i++) {
			puntosX[i] = (int) (250 + radio*Math.cos(angulo-i*Math.PI/2));
			puntosY[i] = (int) (250 + radio*Math.sin(angulo-i*Math.PI/2));
		}
	}
	
	public void paint(Graphics g) {
		
		
		
		g.setColor(Color.black);
		
		g.drawLine(250, 0, 250, 500);
		g.drawLine(0, 250, 500, 250);
		
		for (int i = 0; i < 4; i++) {
			g.setColor(Color.BLUE);
			g.drawLine(puntosX[i], puntosY[i], puntosX[(i+1)%4], puntosY[(i+1)%4]);
		}
		
		
		//dibujaCuadrado(g,puntosX[0],puntosY[0]);
		
		//dibujaCuadrado(g,iniX+desX,iniY-desY);
		
		
		
	}

	private void dibujaCuadrado(Graphics g,int posX,int posY) {
		g.drawLine(posX, posY, posX+L, posY);
		g.drawLine(posX+L, posY, posX+L, posY+L);
		g.drawLine(posX, posY+L, posX+L, posY+L);
		g.drawLine(posX, posY, posX, posY+L);
		
	}
	
}
