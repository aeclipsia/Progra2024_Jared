package practica6bis;

import java.util.*;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int intentos=3;
		char let, letcor='a', next;
		
		while (intentos!=0) {
			System.out.println("anota la letra: ");
			let=sc.next().charAt(0);
			
			if (let=='o') {
				letcor='ñ';
			}
			
			
			if (letcor!=let) {
				intentos=intentos-1;
				System.out.println("Te quedan "+intentos+" intentos");
			}
			letcor++;
		}
		
	}

}
