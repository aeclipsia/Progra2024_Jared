package BuenoJaredArrays;

public class Contratos {

	private String telefono;
	private String tarifa;
	private double importe;
	private int llamadas;
	
	public Contratos(String telefono, String tarifa) {
		this.telefono = telefono;
		this.tarifa = tarifa;
		this.importe = 0;
		this.llamadas = 0;
	}
	
	public void Llamada(int mins, int tipo) {
		switch (tipo) {
		case 0:
			if (mins<=5) {
				importe=10+(mins*0.02);
				llamadas++;
			}
			else {
				importe=10+(mins*0.03);
				llamadas++;
			}
			break;
			
		case 1:
			if (mins<=5) {
				importe=15+(mins*0.01);
				llamadas++;
			}
			else {
				importe=15+(mins*0.02);
				llamadas++;
			}
			break;
			
		case 2:
			if (mins<=5) {
				importe=30+(mins*0);
				llamadas++;
			}
			else {
				importe=30+(mins*0.01);
				llamadas++;
			}
			break;	

		default:
			break;
		}
		
		System.out.println("Importe: "+importe);
	}

	public String getTelefono() {
		return telefono;
	}
	
	public String getTarifa() {
		return tarifa;
	}

	public String toString() {
		return "Número de telefono: "+telefono+", Tipo de tarifa: "+tarifa+", llamadas realizadas: "+llamadas;
	}
	
	public int getLlamadas() {
		return llamadas;
	}
	
	
	
	
	
	
	
	
}
