package practica6;

import java.math.BigInteger;
import java.util.*;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		long num,rest=10,count=0;
		
		System.out.println("Anota un número");
		num=sc.nextLong();
		
		do {
			rest=num/10;
			count=count+1;
			
			num=rest;
			
		} while (rest!=0);
		
		System.out.println("El número tiene "+count+" cifras.");
	}

}
