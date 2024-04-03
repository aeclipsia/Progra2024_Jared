package practica8;

public class Alumnos {

	private int mat,aprob;
	private double nota1, nota2, nota3, avg;
	private double avg1, avg2, avg3;
	
	public Alumnos(int mat, double nota1, double nota2, double nota3) {
		super();
		this.mat = mat;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}
	
	public Alumnos(double avg1, double avg2, double avg3) {
		this.avg1=avg1;
		this.avg2=avg2;
		this.avg3=avg3;
	}
	
	public double media() {
		avg=(nota1+nota2+nota3)/3;
		if (avg>=5) {
			aprob=aprob+1;
		}
		return avg;
	}
	
	public int getAprobados() {
		return aprob;
	}
	
}
