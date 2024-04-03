package practica6;

import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int fresa=0,a=0,b=0,c=0;
		
		do {
			System.out.println("De que grosor es la fresa?  (ESCRIBE ");
			fresa=sc.nextInt();
			
			if (fresa>=1 && fresa<3) {
				a=a+1;
			}
			else if (fresa>=3 && fresa<5) {
				b=b+1;
			}
			else if (fresa>=5){
				c=c+1;
			}
			
		} while (fresa!=0);
		
		System.out.println("Hay "+a+" fresa(s) de la categoría A, "+b+" fresa(s) de la categoría B y "+c+" fresa(s) de la categoría C.");
	}
}
