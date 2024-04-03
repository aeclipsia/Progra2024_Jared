package practica6;

import java.util.*;

public class Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		boolean check=false;
		int op,comp=1, edad, precio, actpr=0, totalper, total=0;
		String act;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Qué operación quiere hacer?");
			System.out.println("1 = comprar entrada");
			System.out.println("2 = cerrar taquilla");
			op=sc.nextInt();
		} while (op!=1 && op!=2);
		
		if (op==1) {
			do {
				System.out.println("Edad: ");
				edad=sc.nextInt();
				
				if (edad<7 || edad>65) {
					precio=16;
				}
				else {
					precio=25;
				}
				
				if (edad>18) {
					do {
						System.out.println("Quiere ver una actuación de un grupo de teatro?");
						act=sc.next();
						
						switch (act) {
						case "si":
						case "sí":
						case "Si":
						case "Sí":
						case "SI":
							actpr=3;
							check=true;
							break;

						case "no":	
						case "No":
						case "NO":
							actpr=0;
							check=true;
							break;	
							
						default:
							System.out.println("ERROR! Responde con un sí o no");
							check=false;
							break;
						}
					} while (check==false);
				}
				
				totalper=precio+actpr;
				total=total+totalper;
				
				System.out.println("Quiere seguir comprando?");
				System.out.println("1 = Sí");
				System.out.println("2 = No");
				comp=sc.nextInt();
			} while (comp==1);
			
			System.out.printf("Importe total: "+total);
		}
		
		else if (op==2) {
			System.out.println("Gracias por venir!");
		}
	}
}
