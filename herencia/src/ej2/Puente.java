package ej2;

public class Puente extends Alumno {

	private String carreraProc;

	public Puente(String nombre, String apellidos, String curso, double importe, String carreraProc) {
		super(nombre, apellidos, curso, importe);
		this.carreraProc = carreraProc;
	}

	@Override
	public String toString() {
		return super.toString()+"Puente [carreraProc=" + carreraProc + "]";
	}
	
	
	
}
