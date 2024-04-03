package practicaString;

import java.util.*;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String end="fin",cadena;
		boolean cont=true;
		
		do {
			System.out.println("Escribe cualquier frase. Pon fin para terminar el programa");
			cadena=sc.nextLine();
			
			if (cadena.equalsIgnoreCase(end)) {
				cont=false;
			}
		} while (cont==true);

		System.out.println("Fin del programa");
		
	}

}
