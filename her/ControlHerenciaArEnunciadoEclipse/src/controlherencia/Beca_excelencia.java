package controlherencia;

public class Beca_excelencia extends Beca{

	private int nota;

	public Beca_excelencia(String dnialumno, double renta, int nota) {
		super(dnialumno, renta);
		this.nota = nota;
	}
	
	public int darPuntuacion() {
		if(renta < 6000) {
			if (nota==7||nota==8) {
				puntuacion=2+1;
			}
			else if (nota==9||nota==10) {
				puntuacion=2+2;
			}
		}
		if(renta >= 6000 && renta <= 10000) {
			if (nota==7||nota==8) {
				puntuacion=1;
			}
			else if (nota==9||nota==10) {
				puntuacion=2;
			}
		}
		return puntuacion;
	}
	
}
