package buenoJared2Eval;

/*
 * @author Jared James Lloyd Bueno
 */

public abstract class Arreglos {

	static int counter=100; //acumulador para la asignación del número de arreglo
	
	private int numArreglo;
	private String codEmple;
	protected double importe;
	protected boolean finalizado;
	
	public Arreglos() {
		this.numArreglo = counter;
		this.codEmple = null;
		this.importe = 0;
		this.finalizado = false;
		counter++;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public String getCodEmple() {
		return codEmple;
	}

	public void setCodEmple(String codEmple) {
		this.codEmple = codEmple;
	}
	
	public int getNumArreglo() {
		return numArreglo;
	}
	
	abstract double finalizar();

	@Override
	public String toString() {
		return "Número de Arreglo: "+numArreglo+" Importe: "+importe+" Finalizado? "+finalizado;
	}

}
