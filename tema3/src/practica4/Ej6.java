package practica4;

import java.util.*;

public class Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int d,m,y;
		System.out.println("Día");
		d=sc.nextInt();
		
		System.out.println("Mes");
		m=sc.nextInt();
		
		System.out.println("Año");
		y=sc.nextInt();
		
		
		if (y%4==0 || (y%100==0 && y%400==0)) {
			switch (m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:	
				if (d==31) {
					System.out.println("Es una fecha válida");
					System.exit(0);
				}
				
				else if (d<0 || d>31) {
					System.out.println("ERROR! DÍA INCORRECTO!");
					System.exit(0);
				}
				
				else
					System.out.println("Es una fecha válida");
					System.exit(0);
				break;

			case 4:
			case 6:
			case 9:
			case 11:	
				if (d==30) {
					System.out.println("Es una fecha válida");
					System.exit(0);
				}
				
				else if (d<0 || d>30) {
					System.out.println("ERROR! DÍA INCORRECTO!");
					System.exit(0);
				}
				
				else
					System.out.println("Es una fecha válida");
					System.exit(0);
				break;	
			
			case 2:	
				if (d==29) {
					System.out.println("Es una fecha válida");
					System.exit(0);
				}
				
				else if (d<0 || d>29) {
					System.out.println("ERROR! DÍA INCORRECTO!");
					System.exit(0);
				}
				
				else
					System.out.println("Es una fecha válida");
					System.exit(0);
				break;		
				
			case 12:	
				if (d==31) {
					System.out.println("Es una fecha válida");
					System.exit(0);
				}
				
				else if (d<0 || d>31) {
					System.out.println("ERROR! DÍA INCORRECTO!");
					System.exit(0);
				}
				
				else
					System.out.println("Es una fecha válida");
					System.exit(0);
				break;		
				
			default:
				System.out.println("ERROR! MES INCORRECTO!");
				System.exit(0);
				break;
			}
		}
		else
			switch (m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:	
				if (d==31) {
					System.out.println("Es una fecha válida");
					System.exit(0);
				}
				
				else if (d<0 || d>31) {
					System.out.println("ERROR! DÍA INCORRECTO!");
					System.exit(0);
				}
				
				else
					System.out.println("Es una fecha válida");
					System.exit(0);
				break;

			case 4:
			case 6:
			case 9:
			case 11:	
				if (d==30) {
					System.out.println("Es una fecha válida");
					System.exit(0);
				}
				
				else if (d<0 || d>30) {
					System.out.println("ERROR! DÍA INCORRECTO!");
					System.exit(0);
				}
				
				else
					System.out.println("Es una fecha válida");
					System.exit(0);
				break;	
			
			case 2:	
				if (d==28) {
					System.out.println("Es una fecha válida");
					System.exit(0);
				}
				
				else if (d<0 || d>28) {
					System.out.println("ERROR! DÍA INCORRECTO!");
					System.exit(0);
				}
				
				else
					System.out.println("Es una fecha válida");
					System.exit(0);
				break;		
				
			case 12:	
				if (d==31) {
					System.out.println("Es una fecha válida");
					System.exit(0);
				}
				
				else if (d<0 || d>31) {
					System.out.println("ERROR! DÍA INCORRECTO!");
					System.exit(0);
				}
				
				else
					System.out.println("Es una fecha válida");
					System.exit(0);
				break;		
				
			default:
				System.out.println("ERROR! MES INCORRECTO!");
				System.exit(0);
				break;
			}
			
	}
}

