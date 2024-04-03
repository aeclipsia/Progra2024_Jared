package practica5;

import java.util.Scanner;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int numero, suma=0, contador=0, media;
		
		System.out.println("Escribe el numero");
		numero=sc.nextInt();
		
		while (numero>=0) {	
			suma=suma+numero;
			
			System.out.println("Escribe el numero");
			numero=sc.nextInt();
			
			contador=contador+1;
		}
		media=suma/contador;
		System.out.println("La media es "+media);
	}

}
