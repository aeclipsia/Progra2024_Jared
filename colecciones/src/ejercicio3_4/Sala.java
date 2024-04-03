package ejercicio3_4;

public class Sala {

	private int numSala, dispo=40;
	private String nomPeli;
	private double recaudado;
	
	public Sala(int numSala, String nomPeli) {
		super();
		this.numSala = numSala;
		this.nomPeli = nomPeli;
	}
	
	public void addRecaudado(double importe) {
		recaudado+=importe;
	}
	
	public double getRecaudado() {
		return recaudado;
	}

	public String getNomPeli() {
		return nomPeli;
	}
	
	public int getDispo() {
		return dispo;
	}
	
	public void minusDispo(int entradas) {
		dispo=dispo-entradas;
	}
	
}
