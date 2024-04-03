package practica5;

import java.util.*;

public class Ej10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int nota=0,apro=0, alumnos,count=0;
		
		System.out.println("Cuantas estudiantes hay en programación: ");
		alumnos=sc.nextInt();
		
		for (count = 1; count <= alumnos; count++) {		
			System.out.println("Nota");
			nota=sc.nextInt();	
			switch (nota) {
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
						apro=apro+1;
					break;
				default:
					break;
			}
		}
		System.out.println("Hay "+apro+" aprobados.");
	}
}
