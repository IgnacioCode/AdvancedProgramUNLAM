
public class Casa {
	
	private int f;
	private int l;
	private int posX=-1;
	private int posY=-1;
	private String orientacion;
	public Casa(int F,int L) {
		f = F;
		l = L;
	}

	public int getF() {
		return f;
	}

	public int getL() {
		return l;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public String getOrientacion() {
		return orientacion;
	}
	
	
	
}
