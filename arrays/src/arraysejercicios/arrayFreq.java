package arraysejercicios;

import java.util.*;

public class arrayFreq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int freq[] = new int[5];
		
		int num;
		boolean numVal;
		
		//input
		for (int i = 0; i < 20; i++) {
			
			do {
				numVal=true;
				
				System.out.println("Anota un número entre 1 y 5");
				num=sc.nextInt();
				
				if (num<1 || num>5) {
					numVal=false;
					System.err.println("El número debe ser entre 1 y 5");
				}
			} while (numVal==false);
			freq[num-1]++;
		}
		
		//output
		for (int i = 0; i < freq.length; i++) {
			System.out.println("El número "+(i+1)+" salió "+freq[i]+" veces.");
		}
	}

}
