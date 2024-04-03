package practica4;

import java.util.*;

public class Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int ini=0000,v1,v2,v3;
		
		do {
			System.out.println("Escribe un número entero positivo de 3 cifras");
			ini=sc.nextInt();
		} while (ini<0 || ini>999);
		
		//division de valores
		v3=ini/100;
		v2=(ini%100)/10;
		v1=(ini%100)%10;
		
		System.out.println("Tu número al revés es "+v1+""+v2+""+v3);
	}

}
