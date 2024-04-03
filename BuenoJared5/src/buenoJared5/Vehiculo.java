package buenoJared5;

import java.time.*;

public class Vehiculo {

	private String matricula;
	private int estado, codReserva;
	private LocalTime timeReserva, timeFuncionamento;
	
	public Vehiculo(String matricula) {
		this.matricula = matricula;
		this.estado = 0;
	}


	public String infoVehiculo() {
		
		switch (estado) {
		case 0:
			return matricula + " disponible";
			
		case 1:
			return matricula + " reservado";
			
		case 2:
			return matricula + " en funcionamento";
		}
		
		return null;

	}
	
	public String getMatricula() {
		return matricula;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public LocalTime getTimeReserva() {
		return timeReserva;
	}
	
	public void setTimeReserva(LocalTime timeReserva) {
		this.timeReserva = timeReserva;
	}

	public int getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}
	
	public LocalTime getTimeFuncionamento() {
		return timeFuncionamento;
	}
	
	public void setTimeFuncionamento(LocalTime timeFuncionamento) {
		this.timeFuncionamento = timeFuncionamento;
	}
	
	
	
	
	
	
	
}
