package practica6;

import java.util.*;

public class Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int entrada, sala=1, total, op=0, barb=0;
		
		do {
			System.out.println("Que película quiere ver? Anota la sala");
			System.out.println("Sala 1: Oppenheimer");
			System.out.println("Sala 2: Barbie");
			System.out.println("0: Salida");
			sala=sc.nextInt();
			
			switch (sala) {
			case 1:
				System.out.println("Cuántas entradas?");
				entrada=sc.nextInt();
				
				op=op+entrada;
				break;
				
			case 2:
				System.out.println("Cuántas entradas?");
				entrada=sc.nextInt();
				
				barb=barb+entrada;
				break;	

			case 0:
				System.out.println("Que tenga buen día");
				break;
				
			default:
				System.out.println("error!");
				break;
			}
		} while (sala!=0);
		
		if (barb>op) {
			System.out.println("Barbie se ha vendido más con "+barb+" entradas.");
		}
		
		else if (barb<op) {
			System.out.println("Oppenheimer se ha vendido más con "+op+" entradas.");
		}
		
		else if (barb==op) {
			System.out.println("Se han vendido el igual número de entradas.");
		}
		
	}

}
