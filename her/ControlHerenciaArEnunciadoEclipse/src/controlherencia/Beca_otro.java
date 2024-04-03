package controlherencia;

public class Beca_otro extends Beca{

	private int nota;

	public Beca_otro(String dnialumno, double renta) {
		super(dnialumno, renta);
	}
	
	public int darPuntuacion() {
		if(renta < 6000) {
			puntuacion=2;
		}
		if(renta >= 6000 && renta <= 10000) {
			puntuacion=1;
		}
		return puntuacion;
	}
}