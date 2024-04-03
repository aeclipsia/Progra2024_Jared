package practica5;

import java.util.*;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		int numero=0, resultado;
		
		
		while (numero>=0) {
			System.out.println("Escribe un número y te devuelvo el cuadrado");
			numero=sc.nextInt();
			
			resultado=numero*numero;
			System.out.println("El cuadrado de "+numero+" es "+resultado);
		}
		
		
	}

}
