package arraysejercicios;

import java.util.Arrays;

public class Vendedores {


	private String nombre;
	private int ventas[]=new int[3];
	private int totalVentas;

	public Vendedores(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}	
	
	public void Vender(int unidades, int pos) {
		ventas[pos]=unidades;
		totalVentas+=unidades;
	}

	public int gettotalVentas() {
		return totalVentas;
	}

	@Override
	public String toString() {
		return "Empleado "+nombre+" con ventas total de "+totalVentas;
	}
	
	
	
}
