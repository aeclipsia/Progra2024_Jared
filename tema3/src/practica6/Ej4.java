package practica6;

import java.util.*;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int adult,child,nument,max=0;
		String ad,ch;
		double precio,precioad=0,precioch=0, total=0;
		
		do {
			System.out.println("Anota el número de adultos");
			adult=sc.nextInt();
			System.out.println("Tiene la tarifa reducida?");
			ad=sc.next();
			switch (ad) {
			case "si":
			case "sí":
			case "Si":
			case "Sí":
			case "SI":
			case "SÍ":
				precioad=adult*2;
				break;
				
			case "no":
			case "No":
			case "NO":
				precioad=adult*3;
				break;	

			default:
				break;
			}
			
			System.out.println("Anota el número de niños");
			child=sc.nextInt();
			System.out.println("Tiene la tarifa reducida?");
			ch=sc.next();
			switch (ch) {
			case "si":
			case "sí":
			case "Si":
			case "Sí":
			case "SI":
			case "SÍ":
				precioch=child*1.2;
				break;
				
			case "no":
			case "No":
			case "NO":
				precioch=child*2;
				break;	

			default:
				System.out.println("error");
				break;
			}
			
			
			precio=precioch+precioad;
			System.out.printf("Importe total: %.2f\n",precio);
			
			nument=adult+child;
			
			if (nument>=max) {
				max=nument;
			}
			
			total=total+precio;
			
			System.out.printf("Dinero recaudado: %.2f\n",total);
			
		} while (total<=100);
		
		System.out.println("Mayor número de entradas comprado por un grupo: "+max+" entradas.");
	}

}
