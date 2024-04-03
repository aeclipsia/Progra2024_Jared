package ejercicio2;

public class Externo extends Empleado{

	private String proc;
	
	public Externo(int numEmple, String nombre, String dni, String direc, String telefono, String proc) {
		super(numEmple, nombre, dni, direc, telefono, 0);
		this.proc = proc;
	}
	
	public Externo(int numEmple) {
		super(numEmple);
	}
	
	public String pagar() {
		pago+=(22*horas);
		//reset
		horas=0;
		
		return nombre+" pagado "+pago+" euros.";
	}
	
	public String toString() {
		return "Número de empleado: "+numEmple+"// Nombre: "+nombre+"// Empresa de procedencia: "+proc+" // Horas trabajadas: "+horas+" // Pago con beneficios: "+pago+"\n";
	}
	
}
