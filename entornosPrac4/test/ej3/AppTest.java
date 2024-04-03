package ej3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppTest {

	@Test
	public void testPotencia1() {
		assertEquals(1, App.potencia(1, 1));
	}
	
	@Test
	public void testPotencia2() {
		assertEquals(4, App.potencia(2, 2));
	}
	
	@Test
	public void testPotencia3() {
		assertEquals(1, App.potencia(1, -1));
	}
	
	@Test
	public void testPotencia4() {
		assertEquals(0.25, App.potencia(2, -2));
	}
	
	@Test
	public void testPotencia5() {
		assertEquals(-1, App.potencia(-1, 1));
	}
	
	@Test
	public void testPotencia6() {
		assertEquals(4, App.potencia(-2, 2));
	}
	
	@Test
	public void testPotencia7() {
		assertEquals(-1, App.potencia(-1, -1));
	}
	
	@Test
	public void testPotencia8() {
		assertEquals(0.25, App.potencia(-2, -2));
	}
	
	@Test
	public void testPotencia9() {
		assertEquals(1, App.potencia(1, 0));
	}
	
	@Test
	public void testPotencia10() {
		assertEquals(1, App.potencia(2, 0));
	}
	
	@Test
	public void testPotencia11() {
		assertEquals(1, App.potencia(-1, 0));
	}
	
	@Test
	public void testPotencia12() {
		assertEquals(1, App.potencia(-2, 0));
	}
	
	@Test
	public void testPotencia13() {
		assertEquals(-1, App.potencia(0, 0));
	}
	
	@Test
	public void testPotencia14() {
		assertEquals(0, App.potencia(0, 1));
	}
	
	@Test
	public void testPotencia15() {
		assertEquals(0, App.potencia(0, 2));
	}
}
