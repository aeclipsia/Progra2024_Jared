package practicaString;

import java.util.*;

public class Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String palabra;
		boolean eq=true;
		int i, j;
		char letra, letra2;
		
		System.out.println("Anota la palabra");
		palabra=sc.next();
		
		for (i = 0, j= palabra.length()-1; (i < palabra.length() && j>0); i++, j--) {
			
				letra=palabra.charAt(i);
				letra2=palabra.charAt(j);
			
				if (letra!=letra2) {
					eq=false;
				}
		}
		
		if (eq==false) {
			System.out.println("no es igual al revés");
		}
		else {
			System.out.println("es igual al revés");
		}
		
	}

}
