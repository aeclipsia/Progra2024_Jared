package buenoJared2Eval;

/*
 * @author Jared James Lloyd Bueno
 */

public class Normal extends Arreglos{

	int mins;
	int minimo=5;
	private static int countType;
	
	public Normal() {
		super();
		countType++;
	}

	double finalizar() {
		if (mins<minimo) {
			importe=minimo;
		}
		else if (mins>30) {
			importe=30;
		}
		else {
			importe=mins;
		}
		finalizado=true;
		
		return importe;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}
	
	public void changeMinimo() {
		this.minimo=10;
		this.importe=10;
	}
	
	public static int getCountType() {
		return countType;
	}
	
}
