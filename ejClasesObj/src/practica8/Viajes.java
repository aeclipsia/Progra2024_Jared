package practica8;

import java.util.*;

public class Viajes {

	Scanner sc = new Scanner(System.in);
	
	private String origCity, destCity, codViaje;
	private int seat,cod, resT;
	private double pricePerP,priceTotal;
	private static double recaudadoTotal;
	
	//constructor
	public Viajes(String origCity, String destCity, int cod, int seat, double pricePerP) {
		super();
		this.origCity = origCity.toUpperCase();
		this.destCity = destCity.toUpperCase();
		this.cod = cod;
		this.seat = seat;
		this.pricePerP = pricePerP;
		
		codViaje=this.origCity.substring(0,2)+this.destCity.substring(0,2)+cod;
	}
	
	public void reservas(int adu, int nin) {
		int res=adu+nin;
		if (seat<res) {
			System.out.println("No hay plazos suficientes");
			System.out.println("-------------------------");
		}
		else {
			seat=seat-res;
			System.out.println("Plaza reservada");
			System.out.println("Quedan "+seat+" plazas.");
			
			double price=(adu*pricePerP)+((nin*pricePerP)-((nin*pricePerP)*0.2));
			System.out.println("Precio de viaje: "+price);
			System.out.println("-------------------------");
			
			resT=resT+res;
			priceTotal=priceTotal+price;
		}
	}

	public void addPlazas(int seat) {
		if (resT>seat) {
			System.out.println("Error. Ya hay más reservas que el número de plazas que quieres");
			System.out.println("-------------------------");
		}
		else {
			this.seat=seat;
			System.out.println("Número de plazas modificado correctamente");
			System.out.println("Nuevo número de plazas: "+seat);
			System.out.println("-------------------------");
			this.seat=seat-resT;
			System.out.println("Plazas que quedan: "+(seat-resT));
			System.out.println("-------------------------");
		}
	}

	public void priceViaje() {
		System.out.println("El precio total recuadado por esta viaje es: "+this.priceTotal);
	}
	
	public static void total(Viajes a, Viajes b) {
		recaudadoTotal=a.priceTotal+b.priceTotal;
		System.out.println("Total recaudado: "+recaudadoTotal);
	}
	
	@Override
	public String toString() {
		return "Viajes [codigo de viaje=" + codViaje + "]";
	}
	
	
	
		
}
