package matrices;

import java.util.*;

public class UniMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int dim;
		
		do {
			System.out.println("Anota la dimensión de la matriz:");
			dim=sc.nextInt();
		} while (dim<1 || dim>30);
		
		int tabla[][]=new int[dim][dim];
		
		//creacion de la tabla unitaria
		for (int i = 0; i < dim; i++) {
			tabla[i][i]=1;
		}
		
		//show
		showMatrix(tabla, dim);
		
		
	}
	
	public static void showMatrix(int[][] tabla, int dim) {
		
		System.out.println("Matriz: ");
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				System.out.print("\t"+tabla[i][j]);
			}
			System.out.println();
		}
	}

}
