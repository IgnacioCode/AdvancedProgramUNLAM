import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import org.junit.Assert;

public class TestProcesaImagenes {

	@Test
	public void ningunaCompresion() throws IOException {
		
		File archOut = new File("salidas\\ningunaCompresionOut.txt");
		Scanner lector = new Scanner(archOut);

		Main.procesaImagenes("entradas\\ningunaCompresionIn.txt", "salidas\\ningunaCompresionOut.txt");
		
		lector.useDelimiter("\r\n");
		
		String linea1 = lector.next();
		String linea2 = lector.next();
		
		lector.close();
		Assert.assertEquals("BNRV", linea1);
		Assert.assertEquals("RAB",linea2);

	}
	
	@Test
	public void unaLetra() throws IOException {
		
		File archOut = new File("salidas\\unaLetraOut.txt");
		Main.procesaImagenes("entradas\\unaLetraIn.txt", "salidas\\unaLetraOut.txt");
		
		Scanner lector = new Scanner(archOut);

		lector.useDelimiter("\r\n");
		
		String linea1 = lector.next();
		String linea2 = lector.next();
		
		lector.close();
		
		Assert.assertEquals("(A20)", linea1);
		Assert.assertEquals("BBBBBBBBBBBB",linea2);
		
	}
	
	@Test
	public void todoComprimido() throws IOException {
		
		File archOut = new File("salidas\\todoComprimidoOut.txt");
		Main.procesaImagenes("entradas\\todoComprimidoIn.txt", "salidas\\todoComprimidoOut.txt");
		
		Scanner lector = new Scanner(archOut);

		lector.useDelimiter("\r\n");
		
		String linea1 = lector.next();
		String linea2 = lector.next();
		
		lector.close();
		
		Assert.assertEquals("(A20)(V7)(B2)(R5)", linea1);
		Assert.assertEquals("RRRRRRNNNNNBBBBAAAAVVVVVVVV",linea2);
		
	}
	
	@Test
	public void gruposDeDos() throws IOException {
		
		File archOut = new File("salidas\\gruposDeDosOut.txt");
		Main.procesaImagenes("entradas\\gruposDeDosIn.txt", "salidas\\gruposDeDosOut.txt");
		
		Scanner lector = new Scanner(archOut);

		lector.useDelimiter("\r\n");
		
		String linea1 = lector.next();
		String linea2 = lector.next();
		
		lector.close();
		
		Assert.assertEquals("RRAABBVVRRAABB",linea2);
		Assert.assertEquals("AAVVBBAARRVVBB", linea1);
		
		Assert.assertEquals(linea1, linea2);
	}
	
	
	
}
