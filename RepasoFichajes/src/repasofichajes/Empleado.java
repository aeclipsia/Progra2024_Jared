package repasofichajes;

import java.time.LocalTime;

public class Empleado {
	private String dni,contraseña;
	private int nEmp;
	private boolean dentro;
	private int minutosTrabajados;
	private LocalTime ultimaHoraEntrada;
	
	
	public Empleado(String dni, int nEmp) {
		super();
		this.dni = dni;
		this.nEmp = nEmp;
		String ceros="";
		for (int i=1; i< 9-dni.length(); i++) {
			ceros+="0";
		}
		this.dni=ceros+this.dni;
		this.contraseña = this.dni.substring(4,8);
	}

	public int getnEmp() {
		return nEmp;
	}

	public boolean validarContraseña(String contraseña) {
		return this.contraseña.equals(contraseña);
		
	}

	public boolean isDentro() {
		return dentro;
	}

	public void setDentro(boolean dentro) {
		this.dentro = dentro;
		// Actualizo minutosTrabajados
	}
	
	
}
