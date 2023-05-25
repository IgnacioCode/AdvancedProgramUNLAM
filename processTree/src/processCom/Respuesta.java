package processCom;

import java.io.Serializable;

public class Respuesta implements Serializable
{
	
	String caractTotales;
	String cantLetras;
	String cantDigitos;
	String cantidadOtros;
	
	public Respuesta(String caractTotales, String cantLetras, String cantDigitos, String cantidadOtros) 
	{
		super();
		this.caractTotales = caractTotales;
		this.cantLetras = cantLetras;
		this.cantDigitos = cantDigitos;
		this.cantidadOtros = cantidadOtros;
	}

	@Override
	public String toString()  
	{
		return caractTotales  + cantLetras + cantDigitos + cantidadOtros;
	}
	
	
	
}
