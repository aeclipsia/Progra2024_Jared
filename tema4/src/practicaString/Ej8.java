package practicaString;

import java.util.*;

public class Ej8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String cad1, cad2;
		int pos;
		
		System.out.println("Anota la palabra");
		cad1=sc.next();
		
		System.out.println("Anota otra palabra");
		cad2=sc.next();
		
		if (cad1.length()>cad2.length()) {
			 pos=cad1.indexOf(cad2,0);
			 if (pos==-1) {
				System.out.println("La cadena "+cad2+" no está en la cadena "+cad1);
			}
			 else {
				System.out.println("La cadena "+cad2+" se encuentra en la posición "+(pos+1)+" de la cadena "+cad1);
			}
		}
		else if (cad1.length()<cad2.length()){
			 pos=cad2.indexOf(cad1,0);
			 if (pos==-1) {
				System.out.println("La cadena "+cad1+" no está en la cadena "+cad2);
			}
			 else {
				System.out.println("La cadena "+cad1+" se encuentra en la posición "+(pos+1)+" de la cadena "+cad2);
			}
		
		}
		else {
			if (cad1==cad2) {
				System.out.println("Las dos palabras son iguales");
			}
			else {
				System.out.println("Las dos palabras miden igual, y por tanto, no puede incluir la otra");
			}
		}
		
	}

}
