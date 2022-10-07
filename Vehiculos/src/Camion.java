import java.util.LinkedHashSet;
import java.util.Set;

public class Camion extends Vehiculo{
   
	private Remolque remolque;
	
	public Camion(String mat) {
		super(mat);
		remolque = null;
	}

	public void ponRemolque(Remolque r) {
		remolque = r;
	}
	
	public void quitaRemolque() {
		remolque = null;
	}

	@Override
	public String toString() {
		return "remolque=" + remolque + ", "+ super.toString();
	}
	
	public void acelerar(int v) throws DemasiadoRapidoException {
		if(remolque!=null && velocidad + v >100) {
			throw new DemasiadoRapidoException("Vas muy rapido papa -->" + (int)(velocidad + v));
		}
		else {
			velocidad+=v;
		}
	}
}

      
