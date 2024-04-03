package ejercicioRepaso1;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Empleado {

	private int numEmple, entradas=0, salidas=0, incidencias=0;
	private String dni;
	private boolean dentro=false;
	private LocalTime entra=null;
	private long timeTrabajado=0;
	
	
	
	public Empleado(int numEmple, String dni) {
		this.numEmple = numEmple;
		this.dni = dni;
	}

	public int getNumEmple() {
		return numEmple;
	}

	public String getDni() {
		return dni;
	}
	
	public int getEntradas() {
		return entradas;
	}

	public void addEntradas() {
		this.entradas++;
	}

	public int getSalidas() {
		return salidas;
	}

	public void addSalidas() {
		this.salidas++;
	}

	public int getIncidencias() {
		return incidencias;
	}

	public void addIncidencias() {
		this.incidencias++;
	}

	public void setDentro(boolean dentro) {
		this.dentro = dentro;
		if (dentro==true) {
			entra=LocalTime.now();
		}
		else if (dentro==false && entra!=null) {
			timeTrabajado=timeTrabajado+ChronoUnit.MINUTES.between(entra, LocalTime.now());
		}
	}
	
	public boolean isDentro() {
		return dentro;
	}
	
	public long getTimeTrabajado() {
		return timeTrabajado;
	}

	public String toString() {
		return "Empleado [numEmple=" + numEmple + ", dni=" + dni + ", dentro=" + dentro + "]";
	}	
	
}
