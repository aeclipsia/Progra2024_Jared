package practica3;

import java.util.*;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		double num1, num2, res = 0;
		
		//Input
		System.out.println("Anota el primer número");
		num1=sc.nextDouble();
		
		System.out.println("Anota el segundo número");
		num2=sc.nextDouble();
		
		if (num1>=0 && num2>=0) {
			res=num1+num2;
			System.out.println("La suma de "+num1+" y "+num2+" es "+res);
		}
			else if (num1<0 && num2<0) {
				res=num1-num2;
				System.out.println("La resta de "+num1+" y "+num2+" es "+res);
			}
			else
				System.out.println("ERROR");
		}
	
}	

