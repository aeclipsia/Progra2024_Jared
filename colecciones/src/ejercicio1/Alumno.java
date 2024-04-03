package ejercicio1;

import java.util.Objects;

public class Alumno {

	private String nombre;
	private double nota;
	public Alumno(String nombre, double nota) {
		super();
		this.nombre = nombre;
		this.nota = nota;
	}
	
	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre, nota);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nota=" + nota + "]";
	}
	
	
	
}
