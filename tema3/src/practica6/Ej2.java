package practica6;

import java.util.*;

public class Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int sum=0, num;
		boolean cero=false;
		
		
		do {
			System.out.println("escribe un número");
			num=sc.nextInt();
			
			sum=sum+num;
			
			System.out.println("total: "+sum);
			
			if (num==0) {
				cero=true;
			}
		} while (sum<100);
		
		System.out.println("Fin del programa");
		
		if (cero==true) {
			System.out.println("se ha anotado un cero");
		}
		else {
			System.out.println("no se ha anotado ningún cero");
		}
		
	}

}
