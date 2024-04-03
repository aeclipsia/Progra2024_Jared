package practica8;

import java.util.*;

public class Ej2main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int ancho, alto;
		char car;
		
		System.out.println("Anota la anchura de la etiqueta");
		ancho=sc.nextInt();
		
		System.out.println("Anota la altura de la etiqueta");
		alto=sc.nextInt();
		
		System.out.println("Anota el caracter de la etiqueta");
		car=sc.next().charAt(0);
		
		Etiqueta eti1=new Etiqueta(alto, ancho, car);
		
		eti1.dibujar();
	}

}
