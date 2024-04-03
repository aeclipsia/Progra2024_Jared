package practica5;

import java.util.*;

public class Ej11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int numero, par=0, impar=0, count=0, nulo=0;
		
		for (count = 0; count < 10; count++) {
						
			System.out.println("Escribe el numero");
			numero=sc.nextInt();
			
			if (numero%2==0 && numero!=0) {
				par=par+1;
			}
			
			else if (numero%2!=0 && numero!=0) {
				impar=impar+1;
			}
			
			else if (numero==0) {
				nulo=nulo+1;
			}
		}
		
		System.out.println(par+" pares, "+impar+" impares, "+nulo+" nulos.");
	}

}
