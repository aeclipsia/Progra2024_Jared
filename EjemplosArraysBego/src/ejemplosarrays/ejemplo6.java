package ejemplosarrays;

import java.util.Arrays;
import java.util.Scanner;

public class ejemplo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[10];
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<numeros.length; i++) {
			System.out.println("Anota número:");
			numeros[i]=sc.nextInt();
		}
		
		Arrays.sort(numeros);
		
		System.out.println("El array ordenado es:");
		for(int i=0;i<numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
		System.out.println("Anota número que quieres buscar:");
		int num=sc.nextInt();
		
		int pos=Arrays.binarySearch(numeros, num);
		
		if (pos<0)
			System.out.println("No existe el número");
		else
			System.out.println("Número encontrado en la posición:"+pos);

	}

}
