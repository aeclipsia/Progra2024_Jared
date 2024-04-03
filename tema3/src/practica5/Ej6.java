package practica5;

import java.util.*;

public class Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		int numero, suma=0;
		
		System.out.println("Escribe el numero");
		numero=sc.nextInt();
		
		while (numero!=0) {	
			suma=suma+numero;
			
			System.out.println("Escribe el numero");
			numero=sc.nextInt();
		}
		System.out.println("La suma es: "+suma);
	}
}
