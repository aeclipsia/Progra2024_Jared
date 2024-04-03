package ejercicioRepaso1;

import java.time.LocalTime;

public class Fichaje {

	private char tipo;
	private int numEmple, totalTime;
	private LocalTime tiempo;
	private String pwd;
	private boolean incidencia;
	
	public Fichaje(char tipo, int numEmple, String pwd) {
		this.tipo = tipo;
		this.numEmple = numEmple;
		this.tiempo = LocalTime.now();
		this.pwd = pwd;
		this.incidencia = false;
	}

	
	public String toString() {
		return "Fichaje [tipo=" + tipo + ", numEmple=" + numEmple + ", totalTime=" + totalTime + ", tiempo=" + tiempo
				+ ", pwd=" + pwd + ", incidencia=" + incidencia + "]";
	}

	public int getNumEmple() {
		return numEmple;
	}
	
	public boolean getIncidencia() {
		return incidencia;
	}
	
	public void setIncidencia(boolean incidencia) {
		this.incidencia=incidencia;
	}	
}
