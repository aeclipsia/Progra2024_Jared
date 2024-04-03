package ejemplosarrays;

import java.util.Scanner;

public class borrar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, pos;
		int numeros[] = { 3, 5, 2, 7, 4 };
		int tam = numeros.length;

		Scanner sc = new Scanner(System.in);

		System.out.println("Contenido del array:");

		for (int i = 0; i < tam; i++)
			System.out.println(numeros[i]);

		do {
			System.out.println("Anota número que quieres borrar:");

			num = sc.nextInt();

			pos = buscar(numeros, tam, num);
			if (pos == -1)
				System.out.println("No encontrado");
			else {
				for (int j = pos; j < tam - 1; j++)
					numeros[j] = numeros[j + 1];

				numeros[tam - 1] = 0;
				tam--;
				for (int i = 0; i < tam; i++)
					System.out.println(numeros[i]);

			}
		} while (tam > 0);

	}

	public static int buscar(int numeros[], int tam, int num) {
		for (int i = 0; i < tam; i++) {
			if (numeros[i] == num)
				return i;
		}
		return -1;
	}

}
