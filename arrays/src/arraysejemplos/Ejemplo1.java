package arraysejemplos;

import java.util.*;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeros[]=new int[10];
		int numeroBuscar, cont=0;
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Anota número "+(i+1)+": ");
			numeros[i]=sc.nextInt();
		}
		
		System.out.println("Los números leídos son:");
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
		System.out.println("Anota el número que quieres buscar: ");
		numeroBuscar=sc.nextInt();
		
		for (int i = 0; i < numeros.length; i++) {
			if (numeroBuscar==numeros[i]) {
				cont=cont+1;
			}
		}
		
		System.out.println("El número "+numeroBuscar+" aparece " +cont+" veces.");
		
	}

}