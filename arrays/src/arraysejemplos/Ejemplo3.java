package arraysejemplos;

import java.util.*;

public class Ejemplo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double temp[]=new double[7];
		String d[]={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
		boolean correcto=false;
		int pos;
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		for (int i = 0; i < d.length; i++) {
			System.out.println("Anota temperatura para el día de "+d[i]+":");
			temp[i]=sc.nextDouble();
			sc.nextLine();
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
