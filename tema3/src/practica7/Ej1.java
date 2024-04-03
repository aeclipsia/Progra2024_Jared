package practica7;

import java.util.*;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		int nEmple,nExtras;
		float sueldo,preExtra,otros;
		
		do {
			System.out.println("Número de empleado: ");
			nEmple=sc.nextInt();
			
			System.out.println("Sueldo: ");
			sueldo=sc.nextFloat();
			
			System.out.println("Horas extras: ");
			nExtras=sc.nextInt();
			
			System.out.println("Precio hora extra: ");
			preExtra=sc.nextFloat();
			
			System.out.println("Otros ingresos: ");
			otros=sc.nextFloat();
			
			float sueldoFinal=calcularSalario(sueldo,nExtras,preExtra,otros);
			System.out.println(sueldoFinal);
			
			if(mas600(sueldoFinal)==true) {
				System.out.println("El empleado "+nEmple+" gana más de 600 euros.");
			}
		} while (nEmple!=0);
		
	}

	//algoritmo que detecta si gana más de 600 euros
	public static boolean mas600(float s) {
		if (s>=600) {
			return true;
		}		
		return false;
	}	
	
	//algoritmo que calcula el saldo final
	public static float calcularSalario(float sueldo, int horas, float precioHora, float otros) {
		float total;
		
		total=sueldo+(horas*precioHora)+otros;
		return total;
	}
	
	
}
