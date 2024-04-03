package ej2;

public class Alumno {

	private String nombre, apellidos, curso;
	protected double importe;
	
	public Alumno(String nombre, String apellidos, String curso, double importe) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso + ", importe=" + importe
				+ "]";
	}
	
}
