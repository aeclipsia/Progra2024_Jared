package practica3;

import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
		
		double num1=0, num2=0, num3=0;
		boolean check;
		do {
			System.out.println("Anota el primer número");
			num1=sc.nextDouble();
			System.out.println("Anota un segundo número distinto");
			num2=sc.nextDouble();
			System.out.println("Anota un tercer número distinto");
			num2=sc.nextDouble();
		} while (num1==num2 || num2==num3 || num3==num1);
		
		  if (num1 > num2){ 
	            if (num2 > num3)
	                System.out.print("El mayor es el "+ num1);

	            else if  (num3 > num1)
	                System.out.print("El mayor es el "+ num3);

	            else if (num1 > num3)
	                System.out.print("El mayor es el "+ num1);
	    }

	    if (num2 > num1){
	        if (num3 > num2)
	            System.out.print("El mayor es el "+ num3);
	        else if (num3 > num1)
	            
	            System.out.print("El mayor es el "+ num2);
	        else if (num1 > num3)
	         
	            System.out.print("El mayor es el "+ num2); 
	    }
	}

}
