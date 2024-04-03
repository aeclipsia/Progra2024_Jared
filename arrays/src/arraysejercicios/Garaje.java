package arraysejercicios;

public class Garaje {

	private int id, planta;
	private double metros, precio;
	private boolean alquilado;
	private static double beneficios;
	
	public Garaje(int id, int planta, double metros) {
		this.id=id;
		this.planta=planta;
		this.metros=metros;
		this.alquilado=false;
		this.beneficios=0;
		switch (this.planta) {
		case 1:
			if (this.metros>4) {
				this.precio=18+3+1.5;
			}
			else if (this.metros<3) {
				this.precio=18+3-1;
			}
			else {
				this.precio=18+3;
			}
			break;
			
		case 2:
			if (this.metros>4) {
				this.precio=18+1.5+1.5;
			}
			else if (this.metros<3) {
				this.precio=18+1.5-1;
			}
			else {
				this.precio=18+1.5;
			}
			break;	

		default:
			if (this.metros>4) {
				this.precio=18+1+1.5;
			}
			else if (this.metros<3) {
				this.precio=18+1-1;
			}
			else {
				this.precio=18+1;
			}
			break;
		}
	}
	
	public void Alquilar() {
		if (this.alquilado==false) {
			this.alquilado=true;
			this.beneficios=beneficios+precio;
			
			System.out.println("Garaje "+this.id+" alquilado por "+precio+" euros.");
		}
		else {
			System.err.println("Garaje ya alquilado");
		}
	}
	
	public int getID() {
		return id;
	}
	
	
	public double getPrecio() {
		return precio;
	}

	public void info() {
		if (alquilado==false) {
			System.out.println("Garaje "+id+" de tamaño "+metros+"m²");
		}
	}
	
	public void plusPrecio(double plus) {
		if (alquilado==true) {
			System.err.println("Garaje alquilado, no se puede modificar el precio");
		}
		else {
			this.precio=precio*(1+(plus/100));
			System.out.println("Nuevo precio: "+this.precio);
		}
	}
	
	public static double getBeneficios() {
		return beneficios;
	}

	
	
}
