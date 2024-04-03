package ejercicio2;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Carnet implements Caducable{

	private LocalDate diaCad;

	public Carnet(LocalDate diaCad) {
		this.diaCad = diaCad;
	}

	@Override
	public boolean isCaducado() {
		if (diaCad.isBefore(LocalDate.now())) {
			return true;
		}
		return false;
	}

	@Override
	public int diasParaCaducado() {
		if (diaCad.isAfter(LocalDate.now())) {
			int dias=(int) ChronoUnit.DAYS.between(LocalDate.now(), diaCad);
			return dias;
		}
		return 0;
	}
	
}
