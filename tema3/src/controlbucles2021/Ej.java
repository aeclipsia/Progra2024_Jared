package controlbucles2021;

import java.util.*;

public class Ej {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		final int paradas=4,max=5;
		int total=0,sube=0,baja=0;
		char billete=0;
		
		for (int i = 1; i <= paradas; i++) {
			total=total+sube-baja;
			
			
			//entrada de datos por cada parada
			if (i==1) {
				System.out.println("Cuántas personas se suben?");
				sube=sc.nextInt();
			}
			
			else if (i==paradas) {
				System.out.println("Fin de trayecto");
			}
			
			else {
				System.out.println("Cuántas personas se suben?");
				sube=sc.nextInt();
				
				System.out.println("Cuántas personas se bajan?");
				baja=sc.nextInt();
				
			}
			
			//comprobar el aforo maximo
			if (total+sube-baja>5) {
				total=5;
			}
			
			//billetes
			for (int j = 1; j <= sube; j++) {
				System.out.println("Tipo de billete: ");
				System.out.println("A, B o C");
				billete=sc.next().charAt(0);
				
				do {
					switch (billete) {
					case 'A':
					case 'a':
						
						break;
						
					case 'B':
					case 'b':
						
						break;

					case 'C':
					case 'c':
						
						break;


					default:
						continue;
					}
				} while (billete==0);
			}
		}
		
		
	}

}
