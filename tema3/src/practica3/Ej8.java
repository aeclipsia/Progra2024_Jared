package practica3;

import java.util.*;

public class Ej8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		double num, rest;
		
		//Input
		System.out.println("Anota un número");
		num=sc.nextDouble();
		
		//operar
		rest=num%2;
		
		//par o impar
		if (rest!=0) {
			System.out.printf("El numero %f es impar",num);
		}
		else {
			System.out.printf("El numero %f es par",num);
		}
	}

}
