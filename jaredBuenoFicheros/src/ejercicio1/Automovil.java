package ejercicio1;

import java.time.*;
import java.time.format.DateTimeFormatter;

/*
 * @author: Jared James Lloyd Bueno
 */

public class Automovil implements Comparable<Automovil>{

	static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
	
	private String mat, dni, nombre, apellido;
	private LocalDate fecha_compra;
	private double precio;
	
	public Automovil(String mat, LocalDate fecha_compra, double precio, String dni, String nombre, String apellido) {
		this.mat = mat;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_compra = fecha_compra;
		this.precio = precio;
	}

	public String toString() {
		return "Matricula: " + mat + ", DNI: " + dni + ", Nombre y Apellido: " + nombre.trim()+" "+ apellido.trim()
				+ ", Fecha de compra: " + fecha_compra.format(formatoFecha) + ", Precio: " + precio;
	}
	
	public int compareTo(Automovil a) {
		if (a.fecha_compra.isBefore(this.fecha_compra)) {
			return 1;
		}
		else if (a.fecha_compra.isAfter(this.fecha_compra)) {
			return -1;
		}
		else {
			if (a.precio<this.precio) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}
	
}
