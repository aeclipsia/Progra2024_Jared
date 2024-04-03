package practica4;

import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		double n1,n2,n3;
		String ope;
		
		System.out.println("Escribe el primer número");
		n1=sc.nextDouble();
		
		System.out.println("Escribe el segundo número");
		n2=sc.nextDouble();
		
		System.out.println("Escribe el tercer número");
		n3=sc.nextDouble();
		
		sc.nextLine();
		
		System.out.println("¿Ascendente o descendente?");
		ope=sc.nextLine();
		
		switch (ope) {
		case "Descendente":
		case "descendente":
		case "D":
		case "d":
		case "DESCENDENTE":
			if (n1>n2) {
				if (n2>n3) {
					System.out.println(n1+", "+n2+", "+n3);
				}
				else if (n3>n1) {
					System.out.println(n3+", "+n1+", "+n2);
				}
				else
					System.out.println(n1+", "+n3+", "+n2);
			}
			else 
				if (n2>n1) {
					if (n3>n2) {
					System.out.println(n3+", "+n2+", "+n1);
				}
					else if (n1>n3) {
					System.out.println(n2+", "+n1+", "+n3);
				}
					else
					System.out.println(n2+", "+n3+", "+n1);
			}
				
			break;
			
		case "Ascendente":
		case "ascendente":
		case "A":
		case "a":
		case "ASCENDENTE":
			
			if (n1>n2) {
				if (n2>n3) {
					System.out.println(n3+", "+n2+", "+n1);
				}
				else if (n3>n1) {
					System.out.println(n2+", "+n1+", "+n3);
				}
				else
					System.out.println(n2+", "+n3+", "+n1);
			}
			else 
				if (n2>n1) {
					if (n3>n2) {
					System.out.println(n1+", "+n2+", "+n3);
				}
					else if (n1>n3) {
					System.out.println(n3+", "+n1+", "+n2);
				}
					else
					System.out.println(n1+", "+n3+", "+n2);
			}
				
			break;
			
		default:
			System.out.println("ERROR!");
			break;
		}
	}
}
