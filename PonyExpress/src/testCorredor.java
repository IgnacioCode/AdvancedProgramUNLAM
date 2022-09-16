import org.junit.Test;

import junit.framework.Assert;

public class testCorredor {

	 @Test
	 public void prueba1() {
		 Assert.assertEquals(1, Corredor.jinetes(new int[] {18,15}));
	 }
	
	 @Test
	 public void prueba2() {
		 Assert.assertEquals(2, Corredor.jinetes(new int[] {43, 23, 40, 13}));
	 }
	 @Test
	 public void prueba3() {
		 Assert.assertEquals(3, Corredor.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
	 }
	 @Test
	 public void prueba4() {
		 Assert.assertEquals(3, Corredor.jinetes(new int[] {51, 51, 51}));
	 }
	 @Test
	 public void prueba5() {
		 Assert.assertEquals(4, Corredor.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));

	 }
}
