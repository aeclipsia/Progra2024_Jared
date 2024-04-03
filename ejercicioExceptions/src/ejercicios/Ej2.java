package ejercicios;

import java.util.*;

public class Ej2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String codigo;
		boolean codVal;
		
		do {
			try {
				codVal=true;
				System.out.println("Anota un código con el formato NNNNAA\n donde N=número y A=letra");
				codigo=sc.nextLine();
				
				Integer.parseInt(codigo.substring(0, 4));
			} catch (NumberFormatException e) {
				System.out.println("Formato incorrecto");
				codVal=false;
			}
		} while (codVal==false);
		
		System.out.println("Código correcto");
	}

}
