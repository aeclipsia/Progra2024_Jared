package practica6;

import java.util.*;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int count,rep=0;
		char letra, first=0;
		
		for (count = 0; count < 50; count++) {
			System.out.println("escribe una letra");
			letra=sc.next().charAt(0);
			
			if (count==0) {
				first=letra;
			}
			
			if (letra==first) {
				rep=rep+1;
			}
		}
		
		System.out.println("La letra "+first+" se repite "+rep+" veces.");
	}

}
