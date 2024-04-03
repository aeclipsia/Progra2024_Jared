package ejercicioRepaso2;

public class Empleado {

	private String dni,pwd;
	private int nEmple, nFichajes = 0;
	private boolean dentro;
	
	Fichaje fichajes[]=new Fichaje[50];
	
	public Empleado(String dni, int nEmple) {
		this.dni = dni;
		this.nEmple = nEmple;
		String ceros="";
		for (int i=1; i< 9-dni.length(); i++) {
			ceros+="0";
		}
		this.dni=ceros+this.dni;
		this.pwd = this.dni.substring(4,8);
	}

	public int getnEmple() {
		return nEmple;
	}
	
	public boolean validarPassword(String contra) {
		return this.pwd.equals(contra);
		
	}
	
	public boolean isDentro() {
		return dentro;
	}

	public void setDentro(boolean dentro) {
		this.dentro = dentro;
	}
	
	
	public int getnFichajes() {
		return nFichajes;
	}

	public void addFichajes() {
		this.nFichajes++;
	}

	public void showFichajes() {
		for (int i = 0; i < nFichajes; i++) {
			fichajes[i].printFichaje();
		}
	}
	
	
}
