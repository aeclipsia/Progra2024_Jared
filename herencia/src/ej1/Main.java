package ej1;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String titulo, editorial, autor, curso;
		double precio, discount;
		int tipo;
		
		Libro libros[]=new Libro[3];
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		
		for (int i = 0; i < libros.length; i++) {
			System.out.println("Anota título: ");
			titulo=sc.nextLine();
			
			System.out.println("Anota autor: ");
			autor=sc.nextLine();
			
			System.out.println("Anota editorial: ");
			editorial=sc.nextLine();
			
			System.out.println("Anota precio: ");
			precio=sc.nextDouble();
			
			System.out.println("Es un libro de texto?\n1-normal\n2-texto");
			tipo=sc.nextInt();
			sc.nextLine();
			
			if (tipo==1) {
				libros[i] = new Libro(titulo,autor,editorial,precio);
			}
			
			else if (tipo==2) {
				System.out.println("Anota curso: ");
				curso=sc.nextLine();
				
				System.out.println("Anota descuento: ");
				discount=sc.nextDouble();
				sc.nextLine();
				
				libros[i] = new Texto(titulo,autor,editorial,precio,curso,discount);
			}
			
		}
		
		for (int i = 0; i < libros.length; i++) {
			System.out.println(libros[i].toString());
		}
	}

}
