package ejercicios;

import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		int num[] = new int[5];
		int count[] = new int[5];
		int mostrar;
		boolean retry, continuar;
		
		for (int i = 0; i < num.length; i++) {
			num[i]= (int)Math.round(Math.random()*10);
		}
		
		do {
			continuar=false;
			do {
				try {
					retry=false;
					
					System.out.println("Elige una celda para mostrar de 1 a 5: ");
					mostrar=sc.nextInt();
					
					System.out.println(num[mostrar-1]);
					count[mostrar-1]++;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Celda no encontrada");
					retry=true;
				} catch (InputMismatchException e) {
					System.out.println("Anota un número entre 1 y 5");
					sc.nextLine();
					retry=true;
				}
			} while (retry==true);
			
			for (int i = 0; i < count.length; i++) { //comprobar si ya salió todos
				if (count[i]==0) {
					continuar=true;
				}
			}
		} while (continuar==true);	
		
		System.out.println("Ya has mostrado todas las celdas, programa terminada");
	}

}
