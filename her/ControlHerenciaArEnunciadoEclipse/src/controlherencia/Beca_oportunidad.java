package controlherencia;

public class Beca_oportunidad extends Beca{

	private String ult_estudio;
	private int edad;
	
	public Beca_oportunidad(String dnialumno, double renta, String ult_estudio, int edad) {
		super(dnialumno, renta);
		this.ult_estudio = ult_estudio;
		this.edad = edad;
	}

	public int darPuntuacion() {
		if(renta < 6000) {
			if (ult_estudio.equalsIgnoreCase("eso")||ult_estudio.equalsIgnoreCase("fp basica")) {
				if (edad>=20) {
					puntuacion=2+1;
				}
				else {
					puntuacion=2+2;
				}
			}
		}
		else if(renta >= 6000 && renta <= 10000) {
			if (ult_estudio.equalsIgnoreCase("eso")||ult_estudio.equalsIgnoreCase("fp basica")) {
				if (edad>=20) {
					puntuacion=1;
				}
				else {
					puntuacion=2;
				}
			}
		}
		return puntuacion;
	}
	
}
