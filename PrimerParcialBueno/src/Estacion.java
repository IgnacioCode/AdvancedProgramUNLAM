
public class Estacion implements Comparable<Estacion>{
	private int id;
	private int tempMin;
	private int tempMax;
	private int cantSuperados;
	private int cantIncomparables;
	private int cantIguales;
	
	public Estacion(int id, int tempMin, int tempMax) {
		super();
		this.id = id;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
	}
	
	public void sumaCantSuperados() {
		cantSuperados++;
	}
	
	public void sumaCantIncomparables() {
		cantIncomparables++;
	}
	
	public void sumaCantIguales() {
		cantIguales++;
	}
	
	@Override
	public String toString() {
		return "Estacion [id=" + id + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", cantIncomparables="
				+ cantIncomparables + "]";
	}

	@Override
	public int compareTo(Estacion o) {
		if(tempMin < o.tempMin && tempMax > o.tempMax)
			return 1;
		if(tempMin == o.tempMin && tempMax > o.tempMax)
			return 1;
		if(tempMax == o.tempMax && tempMin < o.tempMin)
			return 1;
		if(tempMin == o.tempMin && tempMax == o.tempMax)
			return 0;
		return -1;
	}

	public int getCantSuperados() {
		return cantSuperados;
	}

	public int getId() {
		return id;
	}

	public void setCantIncomparables(int cantIncomparables) {
		this.cantIncomparables = cantIncomparables;
	}

	public int getCantIncomparables() {
		return cantIncomparables;
	}

	public int getCantIguales() {
		return cantIguales;
	}
	
	
}
