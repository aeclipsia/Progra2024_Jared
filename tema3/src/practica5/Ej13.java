package practica5;

import java.util.*;

public class Ej13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int num, ant;
		
		System.out.println("Escribe un número");
		num=sc.nextInt();
		
		ant=num-1;
		
		while (ant!=0) {
			System.out.println(ant);
			ant=ant-1;
		}
	}

}
