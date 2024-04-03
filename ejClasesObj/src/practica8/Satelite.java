package practica8;

public class Satelite {
	
	private double distance;
	private int paralelo, meridian;
	
	
	public Satelite(double distance, int paralelo, int meridian) {
		this.distance = distance;
		this.paralelo = paralelo;
		this.meridian = meridian;
	}


	public Satelite(int paralelo, int meridian) {
		this.paralelo = paralelo;
		this.meridian = meridian;
	}
	
	public Satelite() {
		
	}
	
	public boolean estaOrbita() {
		if(distance==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
