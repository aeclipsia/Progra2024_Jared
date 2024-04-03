package practica5;

import java.util.*;

public class Ej12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		
		int nota=0,apro=0, count=0, alumnos;
		
		System.out.println("Cuántos alumnos hay en programación");
		alumnos=sc.nextInt();
		
		while (count!=alumnos) {
			System.out.println("Nota");
			nota=sc.nextInt();
			
			count=count+1;
			
			switch (nota) {
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				apro=apro+1;
				break;
				
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				break;
				
			default:
				System.out.println("Dato introducido es incorrecto.");
				System.exit(0);
				break;
			}
		}
		System.out.println("Han aprobado "+apro+" alumnos.");
	}

}
