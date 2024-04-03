package practica7;

import java.util.*;

public class Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int num,count=0;
		
		System.out.println("Anota un número");
		num=sc.nextInt();
		
		count = cifras(num, count);
		
		System.out.println("El número tiene "+count+" cifras.");
	}

	private static int cifras(int num, int count) {
		int rest;
		do {
			rest=num/10;
			count=count+1;
			
			num=rest;
			
		} while (rest!=0);
		return count;
	}

}
