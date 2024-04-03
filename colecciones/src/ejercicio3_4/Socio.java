package ejercicio3_4;

public class Socio extends Cliente{

	private String id;
	
	public Socio(String nombre, String nomPeli, int numEntradas, String id) {
		super(nombre, nomPeli, numEntradas);
		this.id = id;
	}

	public double pagar() {
		if (numEntradas<=4) {
			pago=(10*numEntradas)*0.8;
		}
		else {
			pago=(40*0.8)+(10*(numEntradas-4));
		}
		
		return pago;
	}
	
	
}
