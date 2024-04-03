package practica7;

import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		long num, total=1;

		do {
			System.out.println("Anota un número positivo");
			num=sc.nextLong();
		} while (num<0);
		
		total = factorial(num);
		System.out.println(num+"!="+total);
		
	}

	private static long factorial(long num) {
		long total=1;
		for (long i = num; i > 0; i--) {
			total=total*i;
		}
		return total;
	}

}
