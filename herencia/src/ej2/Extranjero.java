package ej2;

public class Extranjero extends Alumno {

	private String pais;
	private double impConTasa;
	
	public Extranjero(String nombre, String apellidos, String curso, double importe, String pais) {
		super(nombre, apellidos, curso, importe);
		this.pais = pais;
		this.impConTasa = this.importe + (this.importe * 0.15);
	}

	@Override
	public String toString() {
		return super.toString()+"Extranjero [pais=" + pais + ", impConTasa=" + impConTasa + "]";
	}
	
}
