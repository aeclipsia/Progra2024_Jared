package ejercicios;

import java.util.*;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		double num;
		int count=0, sum=0;
		boolean continuar;
		double media;
		
		do {
			try {
				System.out.println("Anota número");
				num=sc.nextInt();
				if (num!=0) {
					sum+=num;
					count++;
					continuar=true;
				}
				else {
					continuar=false;
				}
			} catch (InputMismatchException e) {
				System.out.println("No has introducido un número");
				continuar=true;
			}
		} while (continuar==true);
		
		//calcular media
		try {
			media=sum/count;
			System.out.println(media);
		} catch (ArithmeticException e) {
			System.out.println("No has introducido ningún número");
		}
	}

}
