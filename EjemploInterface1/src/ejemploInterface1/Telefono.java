package ejemploInterface1;

import java.util.HashMap;

public class Telefono implements Machine{
	private String numero;
	// Tabla Hash, guarda parejas por clave, en este caso parejas de la forma nombre,teléfono
	private HashMap<String, String> contactos;
	
	
	

	public Telefono(String numero) {
		this.numero = numero;
		this.contactos = new HashMap<String, String>();
		
	}


	public void addContacto(String nombre,String telefono){
		contactos.put(nombre, telefono);
	}

	@Override
	public String suena() {
		
		return "Riiiiing";
	}
	
	public void reset(){
		contactos.clear();
	}


	@Override
	public String toString() {
		return "Telefono [numero=" + numero + ", contactos=" + contactos + "]";
	}
	
	

}
