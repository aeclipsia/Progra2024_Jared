package restaurante;

import java.time.*;

abstract class Comensal {

	protected int nComensal, tipo, racion, bebida, pedirTry=0, mesaJuntado;
	protected double importe;
	protected boolean juntado;
	private static int nNormal, nTenedor, nGourmet;

	public Comensal(int nComensal, int tipo) {
		this.nComensal = nComensal;
		this.tipo = tipo;
		this.juntado = false;
	}
	
		
	@Override
	public String toString() {
		
		if (juntado==true) {
			return "Nº de personas: " + nComensal + ", Tipo(1.Normal 2.Tenedor "
					+ " 3.Gourmet): " + tipo + ", Mesa juntado con: " + mesaJuntado;
		}
		else {
			return "Nº de personas: " + nComensal + ", Tipo (1.Normal 2.Tenedor"
					+ " 3.Gourmet): " + tipo;
		}
	}

	public void addContador(int nPersonas, int tipo) {
		switch (tipo) {
		case 1:
			nNormal+=nPersonas;
			break;
			
		case 2:
			nTenedor+=nPersonas;
			break;
			
		case 3:
			nGourmet +=nPersonas;
			break;

		default:
			break;
		}
	}

	abstract void pagar();
	
	public boolean getJuntado() {
		return juntado;
	}

	
	public int getNComensal() {
		return nComensal;
	}
	
	public int getRacion() {
		return racion;
	}

	public void addRacion(int racion) {
		this.racion = this.racion+racion;
	}

	public int getBebida() {
		return bebida;
	}

	public void addBebida(int bebida) {
		this.bebida = this.bebida+bebida;
	}
	
	public String printNPersonas() {
		return "número de personas: "+nComensal;
	}
	
	abstract void addPedirTry();
	
	abstract int getPedirTry();
	
	abstract int getTipo();

	public void changeJuntado() {
		if (juntado==false) {
			juntado=true;
		}
		else {
			juntado=false;
		}
	}
	
	public void setMesaJuntado(int mesa) {
		mesaJuntado=mesa;
	}


}
