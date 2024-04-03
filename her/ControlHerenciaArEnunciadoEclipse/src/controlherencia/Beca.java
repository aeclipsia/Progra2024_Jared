package controlherencia;

public abstract class Beca {

	private String dnialumno;
	protected double renta;
	protected int puntuacion;
	private String codigo;
		
	public Beca(String dnialumno, double renta) {
		super();
		this.dnialumno = dnialumno;
		this.renta = renta;
	}

	public String getDnialumno() {
		return dnialumno;
	}

	public double getRenta(){
		return renta;
	}
	
	public void setRenta(double renta) {
		this.renta = renta;
	}

	abstract int darPuntuacion();
	
	public int getPuntuacion(){
		return puntuacion;
	}
	
	public void setCodigo(String start, int end) {
		this.codigo=start+(end+1);
	}

	@Override
	public String toString() {
		return "Beca: "+codigo+" Dni= " + dnialumno + ", Renta= " + renta +", puntuacion= " + puntuacion;
	}
	
	
}
