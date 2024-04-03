package arraysejemplos;

import java.util.Iterator;

public class EjemploOrdenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeros[]={1,2,6,4,5,3};
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		System.out.println("------------------------------");
		
		burbuja(numeros,numeros.length); //menor a mayor
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
		System.out.println("------------------------------");
		
		burbuja2(numeros,numeros.length); //mayor a menor
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
	}
	
	
	public static void burbuja(int v[],int l) {
		int j, k, aux;
		for (j = 1; j < l; j++) {
			for (k = 0; k < l - j ; k++) {
				if (v[k] > v[k+1]) {
					aux=v[k];
					v[k]=v[k+1];
					v[k+1]=aux;
				}
			}
		}
	}
	
	public static void burbuja2(int v[],int l) {
		int j, k, aux;
		for (j = 2; j < l; j++) {
			for (k = 0; k < l - j ; k++) {
				if (v[k] < v[k+1]) {
					aux=v[k];
					v[k]=v[k+1];
					v[k+1]=aux;
				}
			}
		}
	}

}
