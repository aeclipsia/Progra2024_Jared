package alquiler;

public class Alquiler {
	private String matricula;
	private String modelo;
	private String marca;
	private int añoMatriculacion;
	private int categoria = 0;
	private boolean alquilado;
	private double gananciasVeh = 0;
	private static double ganancias = 0;
	private static int vehAlquilado = 0;

	public Alquiler(String matricula, String modelo, String marca, int añoMatriculacion, int categoria) {

		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
		this.añoMatriculacion = añoMatriculacion;
		this.categoria = categoria;
		this.alquilado = false;
	}

	public double alquiler(int dias) {
		double precio = 0;

		if (alquilado == true) {
			return 0;
		}

		switch (categoria) {
		case 1:
			if (dias >= 2) {
				precio = dias * 30;

			} else {
				precio = dias * 45;
			}
			gananciasVeh = gananciasVeh + precio;
			ganancias = ganancias + precio;
			vehAlquilado++;
			alquilado = true;

			break;
		case 2:
			if (dias > 2) {
				precio = dias * 40;

			} else {
				precio = dias + 50;
			}
			gananciasVeh = gananciasVeh + precio;
			ganancias = ganancias + precio;
			vehAlquilado++;
			alquilado = true;
			break;

		default:
			System.out.println("Tipo de vehiculo no existente");
			break;

		}
		return precio;
	}

	public void devolver() {
		if (alquilado == false) {
			System.out.println("Error ese vehiculo no esta alquilado");
			return;
		}
		else {
			alquilado=false;
			vehAlquilado--;
		}
		System.out.println("Devolucion Finalizada");
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}

	public static int getVehAlquilado() {
		return vehAlquilado;
	}

	public static void setVehAlquilado(int vehAlquilado) {
		Alquiler.vehAlquilado = vehAlquilado;
	}

	public static double getGanancias() {
		return ganancias;
	}

	public static void setGanancias(double ganancias) {
		Alquiler.ganancias = ganancias;
	}

	public String getMatricula() {
		return matricula;
	}

	@Override
	public String toString() {
		return "Alquiler [matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", añoMatriculacion="
				+ añoMatriculacion + ", categoria=" + categoria + ", alquilado=" + alquilado + ", gananciasVeh="
				+ gananciasVeh + "]";
	}
	
	

}
