package practicaString;

import java.util.*;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String palabra;
		char letra, car;
		int cont=0;
		
		System.out.println("Anota la palabra");
		palabra=sc.next();
		palabra=palabra.toLowerCase();
		
		System.out.println("Anota la letra");
		letra=sc.next().charAt(0);
		letra=Character.toLowerCase(letra);
		
		for (int i = 0; i < palabra.length(); i++) {
			car=palabra.charAt(i);
			
			if (letra==car) {
				cont=cont+1;
			}
		}
		
		System.out.println("La letra "+letra+" aparece "+cont+" veces en la palabra "+palabra+".");
	}

}
