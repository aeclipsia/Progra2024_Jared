package buenoJared2Eval;

/*
 * @author Jared James Lloyd Bueno
 */

import java.util.*;

public class Garantia extends Arreglos{

	private static int countType;
	
	public Garantia() {
		super();
		countType++;
	}

	double finalizar() {
		importe=Math.random()*30;
		
		finalizado=true;
		return importe;
	}
	
	public static int getCountType() {
		return countType;
	}
	
}
