import java.util.HashMap;
import java.util.Map;

public class Reina {
	private int x;
	private int y;
	public int id;
	public Map<String,Reina> flancos;
	
	public Reina(int cx, int cy, int cid) {
		x = cx;
		y = cy;
		id = cid;
		flancos = new HashMap<String,Reina>();
	}

	public void verificaChoque(Reina leida) {
		
		String dir = null;
		
		if(this.x == leida.x) {	//Una arriba de otra
			if(this.y < leida.y) {
				dir = "N";
			}
			else {
				dir = "S";
			}
		}
		else if(this.y == leida.y) { //Una al lado de otra
			if(this.x < leida.x) {
				dir = "E";
			}
			else {
				dir = "O";
			}
		}
		else { // En diagonales
			double pendiente = (leida.y - this.y)/(leida.x - this.x);
			if(pendiente == 1) {
				if(this.x < leida.x) {
					dir = "NE";
				}
				else {
					dir = "SO";
				}
			}
			else if(pendiente == -1) {
				if(this.x < leida.x) {
					dir = "SE";
				}
				else {
					dir = "NO";
				}
			}
		}
		
		if(this.flancos.containsKey(dir)) {
			Reina anterior = this.flancos.get(dir);
			double dOld = Math.sqrt(Math.pow(this.x-anterior.x, 2) + Math.pow(this.y-anterior.y, 2));
			double dNew = Math.sqrt(Math.pow(this.x-leida.x, 2) + Math.pow(this.y-leida.y, 2));
			if(dOld > dNew) {
				this.flancos.put(dir, leida);
			}
		}
		else if(dir!=null){
			this.flancos.put(dir, leida);
		}

	}
}
