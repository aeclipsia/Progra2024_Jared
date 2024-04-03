package practica5;

import java.util.*;

public class Ej15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int num=12, count, mult;
		
		do {
			System.out.println("Escribir un número entre 0 y 10");
			num=sc.nextInt();
		} while (num>10 || num<=0);
		
		for (count = 0; count <= 10; count++) {
			mult=num*count;
			System.out.println(num+" * "+count+" = "+mult);
		}
	}

}
