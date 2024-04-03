package buenoJared2Eval;

/*
 * @author Jared James Lloyd Bueno
 */

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Urgente extends Arreglos{

	LocalDate fechaentrega,fechafin;
	private static int countType;
	
	public Urgente(LocalDate fechaentrega) {
		super();
		this.fechaentrega = fechaentrega;
		countType++;
	}
	
	public void setFechafin(LocalDate fechafin) {
		this.fechafin = fechafin;
	}

	double finalizar() {
		if (fechaentrega.isAfter(fechafin)) {
			importe=40;
		}
		else {
			importe=40-((ChronoUnit.DAYS.between(fechaentrega, fechafin))*5);
		}
		
		finalizado=true;
		return importe;
	}
	
	public static int getCountType() {
		return countType;
	}
	
	
}
