package ejemplos;

import java.util.*;

public class Switch_ej_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		char op;
		boolean correcto=true;
		
		System.out.println("Que operación quiere que haga? (S/R/P(M)/D)");
		op=sc.next().charAt(0);
		
		System.out.println("Número 1?");
		num1=sc.nextInt();
		
		System.out.println("Número 2?");
		num2=sc.nextInt();
		
		int resultado=0;
		
		switch (op) {
		case 'S':
		case 's':
			resultado=num1+num2;
			break;
			
		case 'R':
		case 'r':
			resultado=num1-num2;
			break;	
			
		case 'P':
		case 'p':
		case 'M':
		case 'm':
			resultado=num1*num2;
			break;	
			
		case 'D':
		case 'd':
			resultado=num1/num2;
			break;	
			
		default:
			correcto=false;
			System.out.println("Operación incorrecta");
			break;
		}
		if (correcto=true) {
			System.out.println("El resultado es "+resultado);
		}
		

	}

}
