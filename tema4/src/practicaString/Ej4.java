package practicaString;

import java.util.*;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String dni, dniconverted;
		int op;
		boolean valid=true, continuar=true;
		char c1, clast, clastinputted, cont;

		do {
			do {
				valid=true;
				System.out.println("Anota el DNI");
				dni=sc.next();
				dni=dni.toLowerCase();
				
				valid = validLength(dni, valid);
				
				if (valid==false) {
					System.out.println("DNI nó válido");
					continue;
				}
				
				c1 = nieDIgit(dni);
				
				clastinputted=dni.charAt(dni.length()-1);
				
				dniconverted=c1+dni.substring(1,dni.length()-1);
				
				op=(Integer.parseInt(dniconverted))%23;
				
				clast = opeDigits(op);
				
				if (clast!=clastinputted) {
					valid=false;
					System.out.println("DNI no válido");
					continue;
				}
							
			} while (valid==false);
			
			System.out.println("DNI válido");
			
			System.out.println("Quieres continuar? S/N");
			cont=sc.next().charAt(0);
			
			if (cont=='n') {
				continuar=false;
			}
		} while (continuar==true);
		
		System.out.println("Fin del programa");
	}

	public static char opeDigits(int op) {
		char clast;
		switch (op) {
		case 0:
			clast='t';
			break;
			
		case 1:
			clast='r';
			break;
			
		case 2:
			clast='w'; 
			break;
			
		case 3:
			clast='a';
			break;
			
		case 4:
			clast='g';
			break;
			
		case 5:
			clast='m';
			break;
			
		case 6:
			clast='y';
			break;
			
		case 7:
			clast='f';
			break;
			
		case 8:
			clast='p';
			break;
			
		case 9:
			clast='d';
			break;
			
		case 10:
			clast='x';
			break;
			
		case 11:
			clast='b';
			break;
			
		case 12:
			clast='n';
			break;
			
		case 13:
			clast='j';
			break;
			
		case 14:
			clast='z';
			break;
			
		case 15:
			clast='s';
			break;
			
		case 16:
			clast='q';
			break;
			
		case 17:
			clast='v';
			break;
			
		case 18:
			clast='h';
			break;
			
		case 19:
			clast='l';
			break;
			
		case 20:
			clast='c';
			break;
			
		case 21:
			clast='k';
			break;
			
		case 22:
			clast='e';
			break;

		default:
			clast='0';
			System.out.println("DNI no válido");
			break;
		}
		return clast;
	}

	public static boolean validLength(String dni, boolean valid) {
		int dnilength;
		dnilength=dni.length();
		if (dnilength<2 || dnilength>9) {
			valid=false;
		}
		return valid;
	}

	public static char nieDIgit(String dni) {
		char c1;
		c1=dni.charAt(0);
		if (c1=='x') {
			c1='0';
		}
		else if (c1=='y') {
			c1='1';
		}
		else if (c1=='z') {
			c1='2';
		}
		return c1;
	}

}
