package ejercicio4;

import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static LinkedList<Prestable> lista=new LinkedList<Prestable>();
	static int op;
	static String opS;
	
	public static void main(String[] args) {
		
		lista.add(new Serie("Masterchef","Realidad",11));
		lista.add(new Serie("Peaky Blinders","Drama",6));
		lista.add(new Videojuegos("Elden Ring", "Acción", "FromSoft", 250));
		lista.add(new Videojuegos("Warcraft III","RPG","Blizzard",120));
		
		do {
			try {
				System.out.println("1-Prestar\n2-Devolver\n3-Disponibilidad\n4-Salir");
				op=sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Anota solo números");
				sc.nextLine();
				continue;
			}
			
			switch (op) {
			case 1:
				sc.nextLine();
				System.out.println("Indique el título");
				for (Prestable i : lista) {
					System.out.println(i);
				}
				opS=sc.nextLine();
				for (Prestable i : lista) {
					if (opS.equalsIgnoreCase(i.getTitle()) && i.isEntregado()==false) {
						i.prestar();
						continue;
						//esto es un comentario para probar el branch de GIT
					}
				}
				break;
				
			case 2:
				sc.nextLine();
				System.out.println("Indique el título");
				for (Prestable i : lista) {
					System.out.println(i);
				}
				opS=sc.nextLine();
				for (Prestable i : lista) {
					if (opS.equalsIgnoreCase(i.getTitle())  && i.isEntregado()==true) {
						i.devolver();
						continue;
					}
				}
				break;
				
			case 3:
				sc.nextLine();
				System.out.println("Indique el título");
				for (Prestable i : lista) {
					System.out.println(i);
				}
				opS=sc.nextLine();
				for (Prestable i : lista) {
					if (opS.equalsIgnoreCase(i.getTitle())) {
						if (i.isEntregado()==true) {
							System.out.println(i.getTitle()+" ya está prestado");
							continue;
						}
						else {
							System.out.println(i.getTitle()+" es disponible");
							continue;
						}
					}
				}
				break;

			default:
				break;
			}
			
		} while (op!=4);
		
		System.out.printf("Se han recaudado %.2f euros en Series y %.2f euros en Videojuegos",Serie.getTotal(),Videojuegos.getTotal());
		
	}

}
