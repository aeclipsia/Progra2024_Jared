package practica8;

public class Ej1main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Satelite s1=new Satelite();
		Satelite s2=new Satelite(2000,14,15);
		Satelite s3=new Satelite(21,62);
		
		if (s2.estaOrbita()) {
			System.out.println("El segundo satelite está en órbita");
		}
		else {
			System.out.println("El segundo satelite no está en orbita");
		}
		
		if (s3.estaOrbita()) {
			System.out.println("El segundo satelite está en órbita");
		}
		else {
			System.out.println("El segundo satelite no está en orbita");
		}
		
		
	}

}
