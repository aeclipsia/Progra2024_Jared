package ejemplosarrays;

import java.util.Scanner;

public class ejemplo2 {
	public static void main(String args[]) {
		String[] cadenas=new String[4];
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<cadenas.length;i++) {
			System.out.println("Anota cadena:");
			cadenas[i]=sc.nextLine();
		}
		
		System.out.println("Cadenas leidas:");
		for(int i=0;i<cadenas.length;i++) {
			System.out.println(cadenas[i]);
		}
		
}
}
