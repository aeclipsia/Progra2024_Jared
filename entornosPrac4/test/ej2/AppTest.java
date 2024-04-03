package ej2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppTest {

	//probar valores límites
	
	@Test
	public void testesValidaNota_1() {
		assertTrue(App.esValidaNota(0));
	}
	
	@Test
	public void testesValidaNota_2() {
		assertTrue(App.esValidaNota(10));
	}
	
	//probar valores dentro de los limites
	
	@Test
	public void testesValidaNota_3() {
		assertTrue(App.esValidaNota(3));
	}
	
	@Test
	public void testesValidaNota_4() {
		assertTrue(App.esValidaNota(4));
	}
	
	@Test
	public void testesValidaNota_5() {
		assertTrue(App.esValidaNota(5));
	}
	
	//probar valores fuera de los limites
	
	@Test
	public void testesValidaNota_6() {
		assertFalse(App.esValidaNota(-1));
	}
	
	@Test
	public void testesValidaNota_7() {
		assertFalse(App.esValidaNota(11));
	}
	
	//probar media para valores válidos
	
	//orden de opeación incorrecta
	
	@Test
	public void testcalcularMedia_1() {
		assertEquals(3, App.calcularMedia(0, 4, 5));
	}
	
	@Test
	public void testcalcularMedia_2() {
		assertEquals(6, App.calcularMedia(10, 3, 5));
	}
	
	@Test
	public void testcalcularMedia_3() {
		assertEquals(5, App.calcularMedia(5, 5, 5));
	}
	
	//probar media para valores no válidos
	
	//condición de entrada incorrecta
	
	@Test
	public void testcalcularMedia_4() {
		assertEquals(-1, App.calcularMedia(-1, 4, 5));
	}
	
	@Test
	public void testcalcularMedia_5() {
		assertEquals(-1, App.calcularMedia(11, 4, 5));
	}
	
}
