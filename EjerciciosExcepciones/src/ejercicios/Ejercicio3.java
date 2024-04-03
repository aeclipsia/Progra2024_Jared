package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[] = new int[5];
		int frecuencias[] = new int[5];
		int celda, anotadas = 0;

		Scanner sc = new Scanner(System.in);

		// Números entre 1 y 10
		for (int i = 0; i < numeros.length; i++)
			numeros[i] = (int) Math.round(Math.random() * 10);

		do {
			try {
				System.out.println("Anota celda:");
				celda = sc.nextInt();

				System.out.println("Número:" + numeros[celda]);
				if (frecuencias[celda] == 0) {
					anotadas++;
					frecuencias[celda] = 1;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Celda incorrecta");
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("No has anotado un número");
			}

		} while (anotadas < numeros.length);

	}

}
