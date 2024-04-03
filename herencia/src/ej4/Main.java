package ej4;

import java.util.*;

public class Main {

	static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc=new Scanner (System.in);
		
		int op, lados, base, altura, lado2, lado3;
		
		Poligono forma=null;
		
		System.out.println("1-Cuadrado\n2-Rectángulo\n3-Triángulo");
		op=sc.nextInt();
		
		switch (op) {
		case 1:
			lados=4;
			System.out.println("Anota longitud del lado");
			base=sc.nextInt();
			
			altura=base;
			
			forma = new Cuadrado(lados,base,altura);
					
			break;

		case 2:
			lados=4;
			System.out.println("Anota longitud de la base");
			base=sc.nextInt();
			
			System.out.println("Anota su altura");
			altura=sc.nextInt();
			
			forma = new Rectangulo(lados,base,altura);
			
			break;
			
		case 3:
			lados=3;
			System.out.println("Anota longitud de la base");
			base=sc.nextInt();
			
			System.out.println("Anota su altura");
			altura=sc.nextInt();
			
			System.out.println("Anota longitud del lado 2");
			lado2=sc.nextInt();
			
			System.out.println("Anota longitud del lado 3");
			lado3=sc.nextInt();
			
			forma = new Triangulo(lados,base,altura,lado2,lado3);
			
			break;
			
		default:
			break;
		}
		
		forma.area();
		
		forma.perimetro();
		
	}

}
