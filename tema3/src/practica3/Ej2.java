package practica3;

import java.util.*;

public class Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		double num1=0, num2=0;
		
		do {
			System.out.println("Anota el primer número");
			num1=sc.nextDouble();
			System.out.println("Anota un segundo número distinto");
			num2=sc.nextDouble();
		} while (num1==num2);
		
		if (num1>num2) 
			System.out.println(num1+" es mayor que "+num2);
		else
			System.out.println(num2+" es mayor que "+num1);
	}
}

