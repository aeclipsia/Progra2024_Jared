package restaurante;

public class Gourmet extends Comensal{

	public Gourmet(int nComensal, int tipo) {
		super(nComensal, tipo);
		this.juntado = false;
	}
	
	public void pagar() {
		importe=((bebida-1)*2)+(racion*15);
		
		System.out.println("Importe a pagar: "+importe);
	}
	
	public int getPedirTry() {
		return pedirTry;
	}
	
	public void addPedirTry() {
		pedirTry++;
	}
	
	public int getTipo() {
		return tipo;
	}
	
}
