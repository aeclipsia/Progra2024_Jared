package arraysejemplos;

import java.util.*;

public class Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String cadenas[]=new String[4];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < cadenas.length; i++) {
			System.out.println("Anota cadena");
			cadenas[i]=sc.nextLine();
		}
		
		System.out.println("Cadenas leídas: ");
		
		for (int i = 0; i < cadenas.length; i++) {
			System.out.println(cadenas[i]);
		}
		
	}

}
