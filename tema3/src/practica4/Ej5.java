package practica4;

import java.util.*;

public class Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int y;
		//input
		System.out.println("Escribe el año");
		y=sc.nextInt();
		
		if (y%4==0 || (y%100==0 && y%400==0)) {
			System.out.println("Es un año bisiesto");
		}
		else if (y<0) {
			System.out.println("ERROR!");
		}
		else
			System.out.println("No es un año bisiesto");
	}

}
