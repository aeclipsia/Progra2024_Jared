package arraysejemplos;

import java.util.*;

public class Ejemplo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String mes[]= {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
		String mesprint="0";
		boolean mesVal=false;
		int d, m, y;
		
		System.out.println("Anota día: ");
		d=sc.nextInt();
		
		do {
			mesVal=true;
			System.out.println("Anota mes: ");
			m=sc.nextInt();
			if (m<=0 || m>12) {
				System.out.println("Mes incorrecto");
				mesVal=false;
			}
			
		} while (mesVal==false);
		
		System.out.println("Anota año: ");
		y=sc.nextInt();
		
		for (int i = 0; i < mes.length; i++) {
			if ((m-1)==i) {
				mesprint=mes[i];
			}
		}
		
		System.out.println(d+" de "+mesprint+" de "+y);
	}

}
