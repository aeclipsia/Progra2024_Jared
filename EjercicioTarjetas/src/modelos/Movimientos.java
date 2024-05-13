package modelos;

import java.time.*;

public class Movimientos {
	private int numero, tarjeta;
	private int cargado;
	private double importe;
	private LocalDate fecha;
	
	public Movimientos(int numero, int tarjeta, int cargado, double importe, LocalDate fecha) {
		super();
		this.numero = numero;
		this.tarjeta = tarjeta;
		this.cargado = cargado;
		this.importe = importe;
		this.fecha = fecha;
	}
	
	
}
