package restaurante;

import java.time.*;

public class Normal extends Comensal {

	private DayOfWeek dia;
	
	public Normal(int nComensal, int tipo) {
		super(nComensal, tipo);
		this.dia=LocalDate.now().getDayOfWeek();
		this.juntado = false;
	}
	
	public void pagar() {
		if (dia.getValue()<=5&&dia.getValue()>=1) {
			importe=((bebida*2)+(racion*15))-(((bebida*2)+(racion*15))*0.1);
		}
		else {
			importe=(bebida*2)+(racion*15);
		}
		
		System.out.println("Importe a pagar: "+importe);
	}

	public void addPedirTry() {
		pedirTry++;
	}
	
	public int getPedirTry() {
		return pedirTry;
	}
	
	public int getTipo() {
		return tipo;
	}
}
