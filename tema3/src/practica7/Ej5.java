package practica7;

import java.util.*;

public class Ej5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char d,c;
		double precioI=5;
		boolean check=true, continua=true;

		do {
			
			do {
				System.out.println("Qué día es hoy? ");
				System.out.println("L,M,X,J,V,S,D");
				d=sc.next().charAt(0);
				d=Character.toUpperCase(d);
				
				check = validaDia(d, check);
			} while (check!=true);
			
			
			calcPrecio(sc, d, precioI);
			
			System.out.println("Quiere continuar? S=sí N=no");
			c=sc.next().charAt(0);
			c=Character.toUpperCase(c);
			
			if (c=='N') {
				continua=false;
			}
		} while (continua==true);
		
		System.out.println("Programa terminado");
	}


	public static boolean validaDia(char d, boolean check) {
		if (d!='L' && d!='M' && d!='X' && d!='J' && d!='V' && d!='S' && d!='D') {
			return check=false;
		}
		return check=true;
	}


	public static void calcPrecio(Scanner sc, char d, double precioI) {
		int edad;
		double precio;
		switch (d) {
		case 'L':
		case 'J':
		case 'V':
			System.out.println("El precio por entrada son de "+precioI+" euros.");
			break;
			
		case 'M':
			System.out.println("Anota la edad");
			edad=sc.nextInt();
			
			if (edad>65) {
				precio=precioI-(precioI*0.5);
				System.out.println("El precio por entrada son de "+precio+" euros.");
			}
			
			else {
				System.out.println("El precio por entrada son de "+precioI+" euros.");
			}
			break;
			
		case 'X':
			precio=precioI-(precioI*0.2);
			System.out.println("El precio por entrada son de "+precio+" euros.");
			break;
			
		case 'S':
		case 'D':
			System.out.println("Anota la edad");
			edad=sc.nextInt();
			
			if (edad<18) {
				precio=precioI-(precioI*0.15);
				System.out.println("El precio por entrada son de "+precio+" euros.");
			}
			else {
				System.out.println("El precio por entrada son de "+precioI+" euros.");
			}
			break;

		default:
			System.out.println("Error");
			break;
		}		
	}

}
