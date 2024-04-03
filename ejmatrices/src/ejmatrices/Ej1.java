package ejmatrices;

import java.util.*;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int tabla[][]=new int[5][4];
		
		//input
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println("Anota número["+i+"]["+j+"]:");
				tabla[i][j]=sc.nextInt();
			}
		}
		
		int auxMin=tabla[0][0], auxMax=tabla[0][0];
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				if (auxMin>tabla[i][j]) {
					auxMin=tabla[i][j];
				}
				if (auxMax<tabla[i][j]) {
					auxMax=tabla[i][j];
				}
			}
		}
		
		showMatrix(tabla);
		
		System.out.println("Máximo: "+auxMax);
		System.out.println("Mínimo: "+auxMin);
		
	}
	
	public static void showMatrix(int[][] tabla) {
		
		System.out.println("Matriz: ");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("\t"+tabla[i][j]);
			}
			System.out.println();
		}
	}

}
