package ejpapel;

import java.util.*;

public class EJ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int capacidad, peso=0, count=0;
		
		do {
			System.out.println("Anota la capacidad");
			capacidad=sc.nextInt();
		} while (capacidad<=0);		
		
		
		do {
			System.out.println("Anota peso");
			peso=sc.nextInt();
			
			
			if (peso<0) {
				System.out.println("Error! Peso debe ser positivo");
				continue;
			}
			
			if (capacidad-peso<0) {
				System.out.println("ERROR!");
				continue;
			}
			else {
				capacidad=capacidad-peso;
				System.out.println("Le queda "+capacidad+" de capacidad.");
				count=count+1;
			}
		} while (capacidad!=0 && peso!=-1);
		
		System.out.println("Fin del programa: "+count+" números.");
		
	}

}