package ejercicio3_4;

public class Cliente {

	private String nombre, nomPeli;
	protected int numEntradas;
	protected double pago;
	
	public Cliente(String nombre, String nomPeli, int numEntradas) {
		super();
		this.nombre = nombre;
		this.nomPeli = nomPeli;
		this.numEntradas = numEntradas;
	}
	
	public double pagar() {
		pago=10*numEntradas;
		
		return pago;
	}
	
	public String toString() {
		return numEntradas+" para "+nomPeli+", Cliente: "+nombre+"\n";
	}
	
	public String getNomPeli() {
		return nomPeli;
	}
	
	public int getNumEntradas() {
		return numEntradas;
	}
}
