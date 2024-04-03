package ejercicio7;

import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static HashSet<Integer> num1 = new HashSet<Integer>();
	static HashSet<Integer> num2 = new HashSet<Integer>();
	static int op;
	
	public static void main(String[] args) {
	
		do {
			System.out.println("Anota un número para el primer conjunto");
			op=sc.nextInt();
			if (op!=0) {
				num1.add(op);
			}
		} while (op!=0);
		
		do {
			System.out.println("Anota un número para el segundo conjunto");
			op=sc.nextInt();
			if (op!=0) {
				num2.add(op);
			}
		} while (op!=0);
		
		for (Integer i : num1) {
			System.out.print(i+"\t");
		}
		System.out.println("\n");
		
		for (Integer j : num2) {
			System.out.print(j+"\t");
		}
		
		if (num1.containsAll(num2) || num2.containsAll(num1)) {
			System.out.println("Uno de los conjuntos está incluido en el otro");
		}
		else {
			System.out.println("No hay inclusión entre los conjuntos");
		}

	}

}
