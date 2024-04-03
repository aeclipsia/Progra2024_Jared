package practica5;

import java.util.*;

public class Ej18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int count,numaux=0,num,max=0;
		
		for (count = 0; count < 5; count++) {
			System.out.println("Escribe el número: ");
			num=sc.nextInt();
			
			if (numaux>=num) {
				max=numaux;
			}
			else if (numaux<num) {
				numaux=num;
				max=numaux;
			}
		}	
		System.out.println("El mayor de ellos es "+max);
	}
}