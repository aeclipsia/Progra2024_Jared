package ejercicio8;

public class Vehiculo {

	private String matricula;
	private String tipo;
	
	
	public Vehiculo(String matricula, String tipo) {
		this.matricula = matricula;
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "matricula=" + matricula + ", tipo=" + tipo;
	}
	
	
	
}
