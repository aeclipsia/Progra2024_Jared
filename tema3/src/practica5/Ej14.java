package practica5;

import java.util.*;

public class Ej14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int num, ant;
		
		System.out.println("Escribe un número");
		num=sc.nextInt();
		
		ant=num;
		
		System.out.println("Los números pares anteriores son:");
		
		while (ant>=0) {
			if (num%2==0) {
				System.out.println(ant);
				ant=ant-2;
			}
			else {
				ant=(ant/2)*2;
				System.out.println(ant);
				ant=ant-2;
			}
		}
	}
}
