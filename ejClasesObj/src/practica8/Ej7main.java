package practica8;

public class Ej7main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Viajes v1=new Viajes("Barcelona", "Madrid", 123, 100, 200);
		Viajes v2=new Viajes("Lugo", "Valencia", 333, 120, 170);
		
		System.out.println(v1.toString());
		System.out.println(v2.toString());
		
		System.out.println("-------------------------");
		
		
		v1.reservas(5,5);
		v2.reservas(10,3);
		v1.reservas(3,5);
		
		v1.addPlazas(15);
		v1.addPlazas(200);
		
		v1.reservas(182,5);
		v1.reservas(182,0);
		
		
		v1.priceViaje();
		v2.priceViaje();
		Viajes.total(v1, v2);
	}

}
