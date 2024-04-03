package practicaString;

import java.util.*;

public class Ej5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String cad1, cad2, cad3;
		char l1, l2, l3;
		int val1, val2, val3;
		
		System.out.println("Anota la primera palabra");
		cad1=sc.nextLine();
		
		System.out.println("Anota la segunda palabra");
		cad2=sc.nextLine();
		
		System.out.println("Anota la tercera palabra");
		cad3=sc.nextLine();
		
		if (cad1.compareToIgnoreCase(cad2)<=0 && cad1.compareToIgnoreCase(cad3)<=0) {
			System.out.println(cad1);
			if (cad2.compareToIgnoreCase(cad3)<=0) {
				System.out.println(cad2+"\n"+cad3);
			}
			else {
				System.out.println(cad3+"\n"+cad2);
			}
		}
		else if (cad2.compareToIgnoreCase(cad1)<=0 && cad2.compareToIgnoreCase(cad3)<=0) {
			System.out.println(cad2);
			if (cad1.compareToIgnoreCase(cad3)<=0) {
				System.out.println(cad1+"\n"+cad3);
			}
			else {
				System.out.println(cad3+"\n"+cad1);
			}
		}
		else if (cad3.compareToIgnoreCase(cad1)<=0 && cad3.compareToIgnoreCase(cad2)<=0) {
			System.out.println(cad3);
			if (cad1.compareToIgnoreCase(cad2)<=0) {
				System.out.println(cad1+"\n"+cad2);
			}
			else {
				System.out.println(cad2+"\n"+cad1);
			}
		}
	}
}
