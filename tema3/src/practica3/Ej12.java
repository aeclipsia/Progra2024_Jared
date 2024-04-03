package practica3;

import java.util.*;

public class Ej12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int nota=0;
		
		System.out.println("Anota la nota");
		nota=sc.nextInt();
		
		switch (nota) {
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println(nota+"..........SUSPENSO");
			break;

		case 5:
			System.out.println(nota+"..........SUFICIENTE");
			break;	
			
		case 6:
			System.out.println(nota+"..........BIEN");
			break;	
		
		case 7:
		case 8:
			System.out.println(nota+"..........NOTABLE");
			break;		
		
		case 9:
		case 10:
			System.out.println(nota+"..........SOBRESALIENTE");
			break;		
			
		default:
			System.out.println("ERROR!");
			break;
		}
		
	}

}
