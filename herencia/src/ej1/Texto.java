package ej1;

public class Texto extends Libro {

	private String curso;
	private double discount;
	
	public Texto(String titulo, String autor, String editorial, double precio, String curso, double discount) {
		super(titulo, autor, editorial, precio);
		this.curso = curso;
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Texto "+super.toString()+"[curso=" + curso + ", discount=" + discount + "]";
	}
	
	
	
	
	
	
	
}
