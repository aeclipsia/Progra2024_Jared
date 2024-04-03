package practica5;

import java.util.*;

public class EJ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int numero=1;
		
		while (numero!=0) {
			System.out.println("Numero");
			numero=sc.nextInt();
			if (numero>0) {
				System.out.println("Es positivo");
			}
			else 
			if (numero<0){
				System.out.println("Es negativo");
			}
		}
		System.out.println("Es cero, el programa se termina");
	}

}
