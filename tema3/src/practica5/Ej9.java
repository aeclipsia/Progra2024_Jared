package practica5;

import java.util.*;

public class Ej9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		int edad, alumno, avgedad;
		double altura, avgh;
		
		//variables de la suma
		int sumedad=0;
		double sumh=0;
		
		for (alumno = 1; alumno <= 5; alumno++) {
			
			System.out.println("Escribe la altura del alumno "+alumno);
			altura=sc.nextDouble();
			
			System.out.println("Escribe la edad del alumno "+alumno);
			edad=sc.nextInt();
			
			sumh=sumh+altura;
			sumedad=sumedad+edad;
		}
		
		avgh=sumh/5;
		avgedad=sumedad/5;
		System.out.println("La edad media de la clase es "+avgedad+" y la altura media de la clase es "+avgh);
	}

}
