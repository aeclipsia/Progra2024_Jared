package restaurante;

public class NoMesasDisponible extends Exception{

	public NoMesasDisponible() {
		
	}
	
	public NoMesasDisponible(String message) {
		super(message);
	}
	
}
