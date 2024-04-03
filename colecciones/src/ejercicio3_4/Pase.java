package ejercicio3_4;

public class Pase extends Cliente{

	private int gratis=3;
	
	public Pase(String nombre, String nomPeli, int numEntradas) {
		super(nombre, nomPeli, numEntradas);
	}
	
	public double pagar() {
		if (numEntradas<=gratis) {
			pago=0;
		}
		else {
			pago=10*(numEntradas-gratis);
		}
		return pago;
	}
	
}
