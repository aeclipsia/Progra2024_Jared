package practica5;

import java.util.*;

public class Ej19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int num1,num2,aux;
		
		System.out.println("Escribe el primer número: ");
		num1=sc.nextInt();
		
		System.out.println("Escribe el segundo número: ");
		num2=sc.nextInt();
		
		if (num1<num2) {
			aux=num1;
			while (aux!=num2+1) {
				System.out.println(aux);
				aux=aux+1;
			}
		}
		else {
			aux=num1;
			while (aux!=num2-1) {
				System.out.println(aux);
				aux=aux-1;
			}
		}
	}
}
