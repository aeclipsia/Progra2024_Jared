package ejercicio1;

import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		sc.useLocale(Locale.ENGLISH);
		
		boolean val;
		double num;
		
		System.out.println("De que tamaño es el array?");
		int tam=sc.nextInt();
		
		ArrayReales a=new ArrayReales(tam);
		
		do {
			val=true;
			
			System.out.println("Anota número");
			num=sc.nextDouble();
			val=a.add(num);
			if (val==false) {
				System.out.println("Array ya lleno");
			}
		} while (val==true);
		
		System.out.println("Mínimo: "+a.minimo());
		System.out.println("Máximo: "+a.maximo());
		System.out.println("Suma: "+a.sumatorio());
		
	}

}
