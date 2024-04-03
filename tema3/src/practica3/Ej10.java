package practica3;

import java.util.*;

public class Ej10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		//Iniciación de variables
		char cat;
		final double base=100;
		double pago;
		int sec,dia,baja;
		
		//Input de datos
		System.out.println("En que categoría está el trabajador? (Escribe la letra en mayúscula)");
		cat=sc.next().charAt(0);
		
		//Condiciones
		if (cat=='A' || cat=='B') {
			pago=base+240;
			System.out.printf("Su sueldo final es %.2f euros",pago);
		}
		else {
			System.out.println("En que sección está?");
			sec=sc.nextInt();
			if (sec==1) {
				System.out.println("Cuantos días trabaja?");
				dia=sc.nextInt();
				System.out.println("Cuantas bajas injustificadas tiene?");
				baja=sc.nextInt();
				pago=base+(0.5*dia)-(30*baja);
				System.out.printf("Su sueldo final es %.2f euros",pago);
			}
			else {
				pago=base+120;
				System.out.printf("Su sueldo final es %.2f euros",pago);
			}
		}
	}
}