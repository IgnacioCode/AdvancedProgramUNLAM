
public class Fede {
	
	public String saludar() {
		return "Hola!";
	}
	
	public String saludar(String otro) {
		if(otro == null || otro.trim() == "") {
			return saludar();
		}
		otro = otro.trim();
		return "Hola, "+ otro +"!";
	}
	
	public static void main(String[] args) {
		
		Fede miFede = new Fede();
		
		System.out.println(miFede.saludar());
		System.out.println(miFede.saludar("Franco"));
	}

}
