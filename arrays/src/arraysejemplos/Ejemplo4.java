package arraysejemplos;

import java.util.*;

public class Ejemplo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double temp[]=new double[7];
		String d[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
		boolean correcto=false;
		double tmax=-273,tmin=100000;
		String dmax="0",dmin="0";
		int pos;
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		for (int i = 0; i < d.length; i++) {
			System.out.println("Anota temperatura para el día de "+d[i]+":");
			temp[i]=sc.nextDouble();
			sc.nextLine();
			if (temp[i]>tmax) {
				tmax=temp[i];
				dmax=d[i];
			}
			if (temp[i]<tmin) {
				tmin=temp[i];
				dmin=d[i];
			}
		}
		
		System.out.println("Temperaturas leídas: ");
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]+": "+temp[i]);
		}
				
		do {
			System.out.println("Qué día quieres que te muestre?");
			String dia=sc.nextLine();
			
			correcto=false;
			pos=validarDia(dia,d);
			if (pos==-1) {
				System.out.println("Ese día no existe");
			}
		} while (pos==-1);
		
		System.out.println("Temperatura el día de "+d[pos]+": "+temp[pos]+" grados.");
		
		System.out.println("Temperatura mínima: "+tmin);
		System.out.println("Día: "+dmin);
		System.out.println("Temperatura máxima: "+tmax);
		System.out.println("Día: "+dmax);
		
	}


	public static int validarDia(String dia,String dias[]) {
		for (int i = 0; i < dias.length; i++) {
			if (dia.equalsIgnoreCase(dias[i])) {
				return i;
			}
		}
		return -1;
	}
}
