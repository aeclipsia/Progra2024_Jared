package practica5;

import java.util.*;

public class Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int numero, adiv=1;
		
		System.out.println("Esribe tu numero y lo adivino");
		numero=sc.nextInt();
		
		while (numero!=adiv) {
			System.out.println("Escribe un numero y te digo si es menor o mayor");
			adiv=sc.nextInt();
			
			if (numero<adiv) {
				System.out.println("Tu número es menor que "+adiv);
			}
			else 
			if (numero>adiv){
				System.out.println("Tu número es mayor que "+adiv);
			}
		}
		
		System.out.println("He adivinado tu número: "+adiv);
	}

}
