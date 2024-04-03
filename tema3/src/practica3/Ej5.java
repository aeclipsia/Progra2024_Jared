package practica3;

import java.util.*;

public class Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		
		int dist, dia;
		double pago,discpay;
		final double price=0.05, disc=0.3;
		//Distancia
		System.out.println("Distancia  a recorrer en KM: ");
		dist=sc.nextInt();
		//Días de estancia
		System.out.println("Días de estancia: ");
		dia=sc.nextInt();
		
		if (dist>1000 && dia>7) {
			discpay=(0.05*dist)*disc;
			pago=(0.05*dist)-discpay;
			System.out.printf("Tienes que pagar %.2f euros.",pago);
		}
		else {
			pago=0.05*dist;
			System.out.printf("Tienes que pagar %.2f euros.",pago);
		}
	}

}
