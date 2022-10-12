import java.util.Comparator;

public class ComparaEstaciones implements Comparator<Estacion>{

	@Override
	public int compare(Estacion o1, Estacion o2) {
		return o1.getId()-o2.getId();
	}

}
