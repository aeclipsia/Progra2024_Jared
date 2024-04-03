package practica5;

import java.util.*;

public class Ej20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int count;
		
		for (count = 0; count < 100; count++) {
			if (count%5==0) {
				continue;
			}
			System.out.println(count);
		}	
	}
}
