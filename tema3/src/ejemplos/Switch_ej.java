package ejemplos;

import java.util.Scanner;

public class Switch_ej {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int posicion;
		
		System.out.println("Introduce su posición en la carrera");
		posicion=sc.nextInt();
		
		switch (posicion) {
		case 1:
		System.out.println("Oro");
		break;
		
		case 2:
		System.out.println("Plata");
		break;
		
		case 3:
		System.out.println("Bronce");
		break;
		
		default:
		System.out.println("Sin Premio");
		break;

		}
		
	}

}
