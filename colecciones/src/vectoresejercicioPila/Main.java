package vectoresejercicioPila;

import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static Pila caracteres=new Pila();
	static int op;
	static char ins;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//menu
		do {
			try {
				System.out.println("1-Añadir elemento\n2-Borrar elemento\n3-Mostrar último elemento\n4-Comprobar sí es vacío\n5-salir");
				op=sc.nextInt();
				
				switch (op) {
				case 1:
					System.out.println("Carácter a añadir: ");
					ins=sc.next().charAt(0);
					
					caracteres.addElemento(ins);
					break;
					
				case 2:
					caracteres.borrarElemento();
					break;
				
				case 3:
					System.out.println(caracteres.ultimoElemento());
					break;
					
				case 4:
					System.out.println(caracteres.vectorIsEmpty());
					break;

				case 5:
					System.out.println("Programa terminada");
					break;
					
				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Anota sólo números");
				sc.nextLine();
			}
		} while (op!=5);
		
	}

}
