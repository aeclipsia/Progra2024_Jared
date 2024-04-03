package buenoJared2Eval;

/*
 * @author Jared James Lloyd Bueno
 */

public class Empleados {

	String cod;
	int assigned;
	int finished;
	public Empleados(String cod) {
		this.cod = cod;
		this.assigned=0;
		this.finished=0;
	}
	public String getCod() {
		return cod;
	}
	public int getAssigned() {
		return assigned;
	}
	public void addAssigned() {
		this.assigned++;
	}
	public int getFinished() {
		return finished;
	}
	public void addFinished() {
		this.finished++;
	}
	@Override
	public String toString() {
		return "El empleado "+cod+" ha terminado "+finished+" de los "+assigned+" que le tiene asignado.";
	}
	
	
	
}
