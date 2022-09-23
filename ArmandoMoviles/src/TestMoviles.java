import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class TestMoviles {

	@Test
	public void todosIguales() throws IOException {
		
		String nameIn = "entradas\\todosIgualesIn.txt";
		String nameOut = "salidas\\todosIgualesOut.txt";
		
		Moviles.cuentaPares(nameIn,nameOut);
		
		File archOut = new File(nameOut);
		Scanner lector = new Scanner(archOut);
		Assert.assertEquals(8, lector.nextInt());
		Assert.assertEquals(4, lector.nextInt());
		
	}
	
	@Test
	public void todosDistintos() throws IOException {
		
		String nameIn = "entradas\\todosDistintosIn.txt";
		String nameOut = "salidas\\todosDistintosOut.txt";
		
		Moviles.cuentaPares(nameIn,nameOut);
		
		File archOut = new File(nameOut);
		Scanner lector = new Scanner(archOut);
		Assert.assertEquals("no se puede", lector.nextLine());
		
	}
	
	@Test
	public void paresPerfectos() throws IOException {
		
		String nameIn = "entradas\\paresPerfectosIn.txt";
		String nameOut = "salidas\\paresPerfectosOut.txt";
		
		Moviles.cuentaPares(nameIn,nameOut);
		
		File archOut = new File(nameOut);
		Scanner lector = new Scanner(archOut);
		Assert.assertEquals(18, lector.nextInt());
		Assert.assertEquals(3, lector.nextInt());
		
	}
	
}
