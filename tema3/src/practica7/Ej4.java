package practica7;

import java.util.*;

public class Ej4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		long num, total=1;
		boolean continuar=true;
		char conti;
		
		
		do {
			do {
				System.out.println("Anota un número positivo");
				num=sc.nextLong();
			} while (num<0);
			
			total = factorial(num);
			System.out.println(num+"!="+total);
			
			System.out.println("Quiere continuar?");
			conti=sc.next().charAt(0);
			
			if (conti=='n' || conti=='N') {
				continuar=false;
			}
		} while (continuar==true);
		
		System.out.println("Programa terminado");
		
	}

	public static long factorial(long num) {
		long totals=1;
		for (long i = num; i > 0; i--) {
			totals=totals*i;
		}
		return totals;
	}

}
