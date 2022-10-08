
public class Arquitecto {
	
	public boolean posicionaCasa(Plano p) {
		
		int[][] mapa = p.getMapa();
		boolean hayPiedrasN=false;
		boolean hayPiedrasE=false;
		if( (p.getCasita().getF() > p.getDx() || p.getCasita().getL() > p.getDy()) || 
				(p.getCasita().getF() > p.getDy() || p.getCasita().getL() > p.getDx())	) 
			return false;
		
		// n ---> El tamaño del mapa  | Max = 100
		// m ---> Tamaño de la casa | Max = 1000
		// Peor caso = 1M * 10K = 10M 
		for (int i = 0; i < mapa.length; i++) {	//O(n^2 * m^2)
			for (int j = 0; j < mapa[0].length; j++) {	//O(n * m^2)
				hayPiedrasN = verificarPiedras(i,j,mapa,p.getCasita(),"N"); //O(m^2)
				hayPiedrasE = verificarPiedras(i,j,mapa,p.getCasita(),"E"); //O(m^2)
				if(!hayPiedrasN){
					p.getCasita().setPosX(j+1);
					p.getCasita().setPosY(i+1);
					p.getCasita().setOrientacion("N");
					return true;
				}else if(!hayPiedrasE) {
					p.getCasita().setPosX(j+1);
					p.getCasita().setPosY(i+1);
					p.getCasita().setOrientacion("E");
					return true;
				}
			}
		}
		
		
		return false;

	}

	private boolean verificarPiedras(int i, int j, int[][] mapa,Casa c,String dir) {
		
		if(dir =="N") {
			for (int k = i; k < c.getF()+i; k++) {
				for (int k2 = j; k2 < c.getL()+j; k2++) {
					if( k< mapa.length && k2<mapa[0].length && mapa[k][k2]==1)
						return true;
				}
			}
		}
		else {
			for (int k = i; k < c.getL()+i; k++) {
				for (int k2 = j; k2 < c.getF()+j; k2++) {
					if(k< mapa.length && k2<mapa[0].length && mapa[k][k2]==1)
						return true;
				}
			}
		}
		
		
		
		return false;
	}
	
}
