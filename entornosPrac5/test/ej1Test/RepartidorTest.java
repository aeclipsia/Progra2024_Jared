package ej1Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ej1.Repartidor;

public class RepartidorTest {

	Repartidor r1;
	Repartidor r2;
	
	@BeforeEach
	public void crearRepartidor() {
		r1 = new Repartidor(1);
		r2 = new Repartidor(2);
	}
	
	@Test
	public void gananciasTest_1() {
		r1.realizarPedido(100, 0);
		assertEquals(20, r1.getGanancias());
	}
	
	@Test
	public void gananciasTestTest_2() {
		r2.realizarPedido(100, 2);
		assertEquals(22, r2.getGanancias());
	}
	
	@Test
	public void gananciasTestTest_3() {
		r1.realizarPedido(0.01, 0);
		assertEquals(0.002, r1.getGanancias());
	}
	
	@Test
	public void realizarPedidoTest_1() {
		r1.realizarPedido(100, 0);
		r2.realizarPedido(100, 0);
		assertEquals(1, r1.getnPedidos());
		assertEquals(1, r2.getnPedidos());
	}
	
	@Test
	public void realizarPedidoTest_2() {
		r1.realizarPedido(100, 0);
		r1.realizarPedido(0, 0);
		assertEquals(1, r1.getnPedidos());
	}
	
	@Test
	public void realizarPedidoTest_3() {
		r2.realizarPedido(-3, 0);
		r1.realizarPedido(100, 0);
		assertEquals(1, Repartidor.getTotalPedidos());
	}
}
