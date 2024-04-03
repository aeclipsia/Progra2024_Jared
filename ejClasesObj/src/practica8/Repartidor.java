package practica8;

import java.util.*;

public class Repartidor {

	Scanner sc = new Scanner(System.in);
	
	private int codRep, numPedido;
	private double importe, ganancias, propina, gananciasT;
	
	public Repartidor(int codRep) {
		this.codRep=codRep;
	}
	
	public void Pedido(double importe, double propina){
		numPedido=numPedido+1;
		gananciasT=gananciasT+(importe*0.2)+propina;
	}

	public int getNumPedido() {
		return numPedido;
	}

	@Override
	public String toString() {
		return "Repartidor [codRep=" + codRep + ", gananciasT=" + gananciasT + "]";
	}
	
	
}
