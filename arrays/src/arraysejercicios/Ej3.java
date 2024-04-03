package arraysejercicios;

import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int countInput, cont=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cuántos números quieres anotar?");
		countInput=sc.nextInt();
		
		int numeros[]=new int[countInput];
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Anota número "+(i+1)+": ");
			numeros[i]=sc.nextInt();
		}
		
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i]==numeros[numeros.length-1]) {
				cont=cont+1;
			}
		}
		
		System.out.println("El número "+numeros[numeros.length-1]+" se repite "+cont+" veces.");
		
	}

}
