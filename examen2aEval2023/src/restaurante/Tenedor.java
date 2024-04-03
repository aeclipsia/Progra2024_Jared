package restaurante;

public class Tenedor extends Comensal{

	private String cod;

	public Tenedor(int nComensal, String cod, int tipo) {
		super(nComensal, tipo);
		this.cod = cod;
		this.juntado = false;
	}
	
	public void pagar() {
		importe=((bebida-1)*2)+(racion*15)-(racion*15)*((Integer.parseInt(cod.substring(2))/100));
		
		System.out.println("Importe a pagar: "+importe);
	}
	
	public static boolean validarCodigo(String cod) {
		if (!cod.substring(0,2).equalsIgnoreCase("TE")) {
			return false;
		}
		if (cod.length()!=4) {
			return false;
		}
		try {
			Integer.parseInt(cod.substring(2));
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
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
