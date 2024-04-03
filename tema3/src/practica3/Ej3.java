package practica3;

import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double num1, num2;
		//Primer número
		System.out.println("Escribe el primer número");
		num1=sc.nextDouble();
		//Segundo número
		System.out.println("Escribe el segundo número");
		num2=sc.nextDouble();
		
		if (num1>num2) 
			System.out.println(num1+" , "+num2);
		else
			System.out.println(num2+" , "+num1);
	}

}
