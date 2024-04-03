package vendedoresArrays;

import java.util.Arrays;

public class Vendedor {
	private String nombre;
	private int ventas[];
	private int totalVentas;
	public Vendedor(String nombre) {
		super();
		this.nombre = nombre;
		this.ventas=new int[3];
	}
	public String getNombre() {
		return nombre;
	}
	
	public int getTotalVentas() {
		return totalVentas;
	}
	
	public void vender(int unidades,int pos) {
		ventas[pos]=unidades;
		totalVentas+=unidades;
	}
	@Override
	public String toString() {
		return "Vendedor [nombre=" + nombre + ", ventas=" + Arrays.toString(ventas) + ", totalVentas=" + totalVentas
				+ "]";
	}
	
	
	
}
