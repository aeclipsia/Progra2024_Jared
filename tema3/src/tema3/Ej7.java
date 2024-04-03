package tema3;

import java.util.*;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double tem;
		
		System.out.println("Anota la temperatura");
		sc.useLocale(Locale.ENGLISH);
		tem=sc.nextDouble();
		
		if (tem>30) {
			System.out.println("Natación");
		}
		if (tem>20 && tem<=30) {
				System.out.println("Tenis");
		}
		if (tem>10 && tem<=20) {
					System.out.println("Golf");
		}
		if (tem>5 && tem<=10) {
						System.out.println("Esquí");
		}
		if (tem<=5) {
							System.out.println("Parchis");
		}
	}
}
