package arraysejercicios;

public class Ej5Vehiculos {

	private String mat, modelo;
	private int yy, cat;
	private static int numAlq;
	private static double gananciasT;
	private double ganancias;
	private boolean alq;
	
	public Ej5Vehiculos(String mat, String modelo, int yy, int cat) {
		super();
		this.mat = mat;
		this.modelo = modelo;
		this.yy = yy;
		this.cat = cat;
		this.alq = false;
	
	}
	
	public void Alquilar (int d) {
		double precio=0;
		if (alq==false) {
			switch (cat) {
			case 1:
				if (d<=2) {
					precio=45*d;
				}
				else {
					precio=30*d;
				}
				break;

			case 2:
				if (d<=2) {
					precio=50*d;
				}
				else {
					precio=40*d;
				}
				break;
			}
			
			System.out.println("Precio: "+precio);
			ganancias+=precio;
			gananciasT+=ganancias;
			
			alq=true;
			numAlq++;
		}
		else {
			System.err.println("Coche no disponible");
		}
	}
	
	public void Devolver () {
		if (alq==false) {
			System.err.println("Coche no alquilada");
		}
		else {
			System.out.println("Devolución de vehículo aceptado");
			alq=false;
			numAlq--;
		}
	}
	
	public void Disponible () {
		if (alq==false) {
			System.err.println("El coche está disponible");
		}
		else {
			System.out.println("El coche no está disponible");
		}
	}
	
	
	public void TotalAlquilado () {
		System.out.println("Hay "+numAlq+" coches alquilados");
	}
	
	public void TotalVehiculo () {
		System.out.println("Ganancias total de "+this.modelo+": "+ganancias);
	}
	
	public static void TotalEmpresa() {
		System.out.println("Ganancias totales de empresa: "+gananciasT);
	}
	
	public String toString() {
		return "Modelo: "+modelo+" Matricula: "+mat+" Año de matriculación: "+yy+" Categoría: "+cat;
	}

	public String getMat() {
		return mat;
	}

	public void setCat(int cat) {
		this.cat = cat;
	}

	public static void setNumAlq(int numAlq) {
		Ej5Vehiculos.numAlq = numAlq;
	}

	public static void setGananciasT(double gananciasT) {
		Ej5Vehiculos.gananciasT = gananciasT;
	}

	public void setAlq(boolean alq) {
		this.alq = alq;
	}

	public double getGanancias() {
		return ganancias;
	}
	
	
	
	
	
	
	
}
