package ejercicio2;

import java.util.Objects;

public class Empleado {

	protected String nombre;
	private String dni;
	private String direc;
	private String telefono;
	protected int numEmple, horas;
	protected double pago;
	private double beneficios, bonus;

	public Empleado(int numEmple, String nombre, String dni, String direc, String telefono, double bonus) {
		super();
		this.numEmple = numEmple;
		this.nombre = nombre;
		this.dni = dni;
		this.direc = direc;
		this.telefono = telefono;
		this.bonus = bonus;
	}
	
	public Empleado(int numEmple) {
		super();
		this.numEmple = numEmple;
	}
	
	public String toString() {
		return "Número de empleado: "+numEmple+"// Nombre: "+nombre+"// Horas trabajadas: "+horas+" // Pago con beneficios: "+pago+"\n";
	}
	
	public void addHoras(int horas) {
		this.horas+=horas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direc, dni, horas, nombre, numEmple, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Empleado other = (Empleado) obj;
		return numEmple == other.numEmple;
	}
	
	public void addBenef(double dinero) {
		this.beneficios=dinero;
	}
	
	public String pagar() {
		pago+=beneficios+bonus+(15*horas);
		//reset
		beneficios=0;
		horas=0;
		
		return nombre+" pagado "+pago+" euros.";
	}
	
}
