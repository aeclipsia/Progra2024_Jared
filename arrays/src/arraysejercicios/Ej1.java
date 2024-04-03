package arraysejercicios;

import java.util.*;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeros[]=new int[10];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Anota número "+(i+1)+": ");
			numeros[i]=sc.nextInt();
		}
		
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i]%2==0) {
				System.out.println(numeros[i]);
			}
		}
		
	}

}
