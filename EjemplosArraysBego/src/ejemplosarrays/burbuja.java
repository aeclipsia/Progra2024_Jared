package ejemplosarrays;

import java.util.Scanner;

public class burbuja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[] = new int[8];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce número:");
			numeros[i] = sc.nextInt();
		}
		
		burbuja(numeros,numeros.length);
		System.out.println("Array ordenado de forma creciente");
		
		for (int i=0; i< numeros.length;i++)
			System.out.println(numeros[i]);
		
		burbuja2(numeros,numeros.length);
		System.out.println("Array ordenado de forma decreciente");
		
		for (int i=0; i< numeros.length;i++)
			System.out.println(numeros[i]);

	}

	// Ordena de menor a mayor
	public static void burbuja(int v[], int TAM) {
		int j, k, aux;
		for (j = 1; j < TAM; j++) // Doy tantas vueltas como elementos tenga mi array

			for (k = 0; k < TAM - j; k++) // En cada vuelta llevo el elemento mayor al

				if (v[k] > v[k + 1]) // Si un elemento es mayor que el siguiente, los

				{
					aux = v[k];
					v[k] = v[k + 1];
					v[k + 1] = aux;
				}

	}
	//Ordena de mayor a menor
	
	public static void burbuja2(int v[], int TAM) {
		int j, k, aux;
		for (j = 1; j < TAM; j++) // Doy tantas vueltas como elementos tenga mi array

			for (k = 0; k < TAM - j; k++) // En cada vuelta llevo el elemento mayor al

				if (v[k] < v[k + 1]) // Si un elemento es mayor que el siguiente, los

				{
					aux = v[k];
					v[k] = v[k + 1];
					v[k + 1] = aux;
				}

	}

}
