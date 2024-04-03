package ej1;

public class Libro {

	private String titulo, autor, editorial;
	private double precio;
	
	public Libro(String titulo, String autor, String editorial, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", precio=" + precio + "]";
	}
	
	
	
	
}
