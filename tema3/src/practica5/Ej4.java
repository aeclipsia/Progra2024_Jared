package practica5;

import java.util.*;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		int numero=0, contador=0;
		
		while (numero>=0) {
			System.out.println("Escribe un número");
			numero=sc.nextInt();
			
			contador=contador+1;
		}
		
		contador=contador-1;
		System.out.println("Has escrito "+contador+" números positivos.");
	}

}
