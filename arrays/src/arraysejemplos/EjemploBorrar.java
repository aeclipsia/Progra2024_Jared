package arraysejemplos;

import java.util.*;

public class EjemploBorrar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int numeros[]= {3,5,2,7,4}; //tam=5
		int tam=numeros.length, num, pos; //tamaño del array
		
		System.out.println("Contenido del array: ");
		Arrays.sort(numeros);
		for (int i = 0; i < tam; i++) {
			System.out.println(numeros[i]);
		}
		
		do {
			System.out.println("Anota número para borrar: ");
			num=sc.nextInt();
			
			//buscar
			pos=buscar(num,numeros,tam);
			if (pos==-1) {
				System.err.println("No encontrado");
			}
			else {
				for (int j = pos; j < tam-1; j++) {
					numeros[j]=numeros[j+1];
				}
				numeros[tam-1]=0;
				tam--;
			}
			System.out.println("Contenido del array: ");
			for (int i = 0; i < tam; i++) {
				System.out.println(numeros[i]);
			}
		} while (tam!=0);
		System.out.println("Array vacio");
		
		Arrays.sort(numeros);
		
	}
	
	public static int buscar(int num, int numeros[], int tam) {
		for (int i = 0; i < tam; i++) {
			if (numeros[i]==num) {
				return i;
			}
		}
		return -1;
	}

}
