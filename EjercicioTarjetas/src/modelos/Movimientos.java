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
	
	

	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public int getTarjeta() {
		return tarjeta;
	}



	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}



	public int getCargado() {
		return cargado;
	}



	public void setCargado(int cargado) {
		this.cargado = cargado;
	}



	public double getImporte() {
		return importe;
	}



	public void setImporte(double importe) {
		this.importe = importe;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	@Override
	public String toString() {
		return "Movimientos [numero=" + numero + ", tarjeta=" + tarjeta + ", cargado=" + cargado + ", importe="
				+ importe + ", fecha=" + fecha + "]";
	}
	
	
	
}
