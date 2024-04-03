package matrices;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int tabla[][]=new int[4][3];
		
		showMatrix(tabla);
		
		//input
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("Anota número["+i+"]["+j+"]:");
				tabla[i][j]=sc.nextInt();
			}
		}
		
		showMatrix(tabla);
		
	}

	public static void showMatrix(int[][] tabla) {
		
		System.out.println("Matriz: ");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("\t"+tabla[i][j]);
			}
			System.out.println();
		}
	}

}
