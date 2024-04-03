package practica5;

import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int numero=1;
		
		while (numero!=0) {
			System.out.println("Número");
			numero=sc.nextInt();
			if (numero/2==0) {
				System.out.println("Es par");
			}
			else {
				System.out.println("Es impar");
			}
		}
		System.out.println("Es cero, el programa se termina");
	}

}
