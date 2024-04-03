package ejemplos;

import java.util.Scanner;

public class Switch_ej_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
			int motor;
		
			System.out.println("Introduce el tipo de motor");
			motor=sc.nextInt();
		
			switch (motor) {
			case 0:
				System.out.println("No hay establecido un valor definido para el tipo de bomba");
				break;
		
			case 1:
				System.out.println("La bomba es una bomba de agua");
				break;
		
			case 2:
				System.out.println("La bomba es una bomba de gasolina");
				break;
			case 3:
				System.out.println("La bomba es una bomba de hormigón");
				break;
		

			case 4:
				System.out.println("La bomba es una bomba de pasta alimenticia");
				break;
			
			default:
				System.out.println("No existe un valor válido para tipo de bomba");
				break;

		}
		
	}

}
