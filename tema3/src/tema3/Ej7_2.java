package tema3;

import java.util.*;

public class Ej7_2 {

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
			else if (tem>20 && tem<=30) {
				System.out.println("Tenis");
		}
				else if (tem>10 && tem<=20) {
					System.out.println("Golf");
		}
					else if (tem>5 && tem<=10) {
						System.out.println("Esquí");
		}
						else if (tem<=5) {
							System.out.println("Parchis");
		}
	}
}
