package alquilertest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import alquiler.Alquiler;

class AlquilerTest {

	Alquiler v1, v2;
	
	
	//crea 2 objetos y reinicializa las ganancias totales
	@BeforeEach
	public void crearVehiculos() {
		v1 = new Alquiler("1234ab","modelo1","marca1",2005,1);
		v2 = new Alquiler("1234cd","modelo2","marca2",2002,2);
		
		Alquiler.setGanancias(0);
	}
	
	//clases válidas (días positivas sin incluir 0)
	
	@Test
	void v1para1dia() {
		assertEquals(45, v1.alquiler(1)); //prueba alquilar el primer vehiculo para un día (45*1=45)
		//la salida obtenida es igual que la esperada
	}
	
	@Test
	void v2para1dia() {
		assertEquals(50, v2.alquiler(1)); //prueba alquilar el segundo vehiculo para un día (50*1=50)
		//la salida obtenida es 51, no la esperada que es 50
	}
	
	@Test
	void v1para2dias() {
		assertEquals(90, v1.alquiler(2)); //prueba alquilar el primer vehiculo para dos días (45*2=90)
		//la salida obtenida es 60, no la esperada que es 90
	}
	
	@Test
	void v2para2dias() {
		assertEquals(100, v2.alquiler(2)); //prueba alquilar el segundo vehiculo para dos días (50*2=100)
		//la salida obtenida es 52, no la esperada que es 100
	}
	
	@Test
	void v1para3dias() {
		assertEquals(90, v1.alquiler(3)); //prueba alquilar el primer vehiculo para tres días (30*3=90)
		//la salida obtenida es igual que la esperada
	}
	
	@Test
	void v2para3dias() {
		assertEquals(120, v2.alquiler(3)); //prueba alquilar el segundo vehiculo para tres días (40*3=120)
		//la salida obtenida es igual que la esperada
	}
	
	//clases inválidas
	
	@Test
	void v1para0dias() {
		assertEquals(0, v1.alquiler(0)); //prueba alquilar el primer vehiculo para cero días (45*0=0)
		//la salida obtenida es igual que la esperada
	}
	
	@Test
	void v2para0dias() {
		assertEquals(0, v2.alquiler(0)); //prueba alquilar el segundo vehiculo para cero días (50*0=0)
		//la salida obtenida es 50, no la esperada que es 0
	}
	

	@Test
	void v1paraMenos1dia() {
		assertEquals(0, v1.alquiler(-1)); //prueba alquilar el primer vehiculo para días negativas
		//la salida obtenida es -45, no la esperada que es 0 ya que no se debe dejar ejecutar el método alquiler
	}
	
	
	@Test
	void v2paraMenos1dia() {
		assertEquals(0, v2.alquiler(-1)); //prueba alquilar el segundo vehiculo para días negativas
		//la salida obtenida es 49, no la esperada que es 0 ya que no se debe dejar ejecutar el método alquiler
	}
	
	//pruebas para las ganancias totales
	
	@Test
	void gananciasTotales1() { //dos alquileres exitosos
		v1.alquiler(1); //precio=45;
		v2.alquiler(1);	//precio=50;
		
		//las ganancias totales debe ser 95;
		
		assertEquals(95, Alquiler.getGanancias()); //obtenido: 96, esperado: 95
	}
	
	@Test
	void gananciasTotales2() { //v1 exitoso, v2 fallo (caso 0)
		v1.alquiler(1); //precio=45;
		v2.alquiler(0); //precio=0;
		
		//las ganancias totales debe ser 45;
		
		assertEquals(45, Alquiler.getGanancias()); //obtenido: 95, esperado: 45
	}
	
	@Test
	void gananciasTotales3() { //v1 exitoso, v2 fallo (caso -1)
		v1.alquiler(1); //precio=45;
		v2.alquiler(-1); //precio=0;
		
		//las ganancias totales debe ser 45;
		
		assertEquals(45, Alquiler.getGanancias()); //obtenido: 94, esperado: 45
	}
	
	@Test
	void gananciasTotales4() { //v1 fallo, v2 exitoso (caso 0)
		v1.alquiler(0); //precio=0;
		v2.alquiler(1); //precio=50;
		
		//las ganancias totales debe ser 50;
		
		assertEquals(50, Alquiler.getGanancias()); //obtenido: 51, esperado: 50
	}
	
	@Test
	void gananciasTotales5() { //v1 fallo, v2 exitoso (caso -1)
		v1.alquiler(-1); //precio=0;
		v2.alquiler(1); //precio=50;
		
		//las ganancias totales debe ser 50;
		
		assertEquals(50, Alquiler.getGanancias()); //obtenido: 6, esperado: 50
	}
	
	//pruebas para alquilar un vehículo ya alquilado
	@Test
	void alquilarAlquilado1() { //caso válido
		v1.alquiler(1); //el vehículo ya está alquilado
		
		assertEquals(0, v1.alquiler(3)); //la salida obtenida es igual que la esperada
	}
	
	@Test
	void alquilarAlquilado2() { //caso inválido
		v1.alquiler(0); //el vehículo no se debe alquilar,entonces el vehículo debería estar disponible
		
		assertEquals(45, v1.alquiler(1));
		//la salida obtenida es 0, es decir que el vehículo ya estaba alquilado cuando no debería ser
	}
	
	/*
	 * En el caso de los vehículos de categoría 1, al alquilar un vehículo por exactamente 2 días,
	 * usa el precio para alquileres de estrictamente más de 2 días (>=2)
	 * 
	 * En el caso de los vehículos de categoría 2, al alquilar un vehículo por 2 días o menos, el
	 * precio se suma al número de días (precio base: 50 + número de días = precio) cuando debe ser
	 * multiplicado (precio base: 50 * número de días = precio)
	 * 
	 * El código no se tiene en cuenta que el día no puede ser cero o negativo (en el caso de números negativos,
	 * se resta en las ganancias totales y en ambos casos, el vehículo se registra como alquilado y no se cancela
	 * la operación)
	 */

	
}
