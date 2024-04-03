package practica6bis;

import java.util.*;

public class Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		char letra=0,most=0, ant=0;
		int count=1, max=0;
			
		do {
			System.out.println("Introduce una letra");
			letra=sc.next().charAt(0);
			
			if (ant==letra) {
				count=count+1;
				most=letra;
			}
			
			else {
				ant=letra;
				count=1;
			}
						
			if (max<count) {
				max=count;
			}
			
			else if (max==count) {
				char most1=ant; System.out.println(most1);
				char most2=most;
			}
			
			ant=letra;
			
		} while (letra!='$');
		System.out.println("La letra más introducida es "+most+" y fue introducida "+max+" veces.");
	}

}
