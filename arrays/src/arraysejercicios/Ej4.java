package arraysejercicios;

import java.util.*;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String personas[]=new String[5];
		boolean eq=false;
		
		
		for (int i = 0; i < personas.length; i++) {
			System.out.println("Anota persona "+(i+1)+":");
			personas[i]=sc.nextLine();
		}		
		
		Arrays.sort(personas);
		
		System.out.println("Anota un nombre: ");
		String nombre=sc.nextLine();
		
		for (int i = 0; i < personas.length; i++) {
			if (nombre.equalsIgnoreCase(personas[i])) {
				eq=true;
				break;
			}
		}
		
		if (eq==true) {
			System.out.println("El nombre "+nombre+" aparece en la lista");
		}
		else {
			System.out.println("El nombre "+nombre+" no aparece en la lista");
		}
		
	}
}
