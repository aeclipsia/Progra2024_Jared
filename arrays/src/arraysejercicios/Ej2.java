package arraysejercicios;

import java.util.*;

public class Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeros[]=new int[5];
		int input;
		boolean valid=false;
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < numeros.length; i++) {
			do {
				valid=true;
				System.out.println("Anota número "+(i+1)+": ");
				input=sc.nextInt();
				if (input<0) {
					valid=false;
				}
				else {
					valid=true;
					numeros[i]=input;
				}
			} while (valid==false);
		}
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]+"²="+(numeros[i]*numeros[i]));
		}
	}

}
