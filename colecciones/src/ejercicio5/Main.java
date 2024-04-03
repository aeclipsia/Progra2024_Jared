package ejercicio5;

import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static int op;
	static String nombre1, nombre2;
	static double nota;
	
	static HashMap<String, Double> alumnos = new HashMap<String, Double>();
	
	public static void main(String[] args) {
		// Programa usando HashMap el de alumnos y notas

		sc.useLocale(Locale.ENGLISH);
		
		//menu
		do {
			System.out.println("1.Alta\n2.Modificar nota\n3.Sustituir\n4.Borrar\n5.Mostrar\n6.Salir");
			op=sc.nextInt();
			
			switch (op) {
			case 1:
				sc.nextLine(); //limpiar buffer
				System.out.println("Anota el nombre del alumno");
				nombre1=sc.nextLine();
				
				if (alumnos.containsKey(nombre1)) {
					System.out.println("Alumno ya existe");
				}
				else {
					System.out.println("Anota su nota");
					nota=sc.nextDouble();
					
					alumnos.put(nombre1, nota);
				}
				break;
				
			case 2:
				sc.nextLine(); //limpiar buffer
				System.out.println("Anota el nombre del alumno");
				nombre1=sc.nextLine();
				
				if (!alumnos.containsKey(nombre1)) {
					System.out.println("Alumno no existe");
				}
				else {
					System.out.println("Anota su nuevo nota");
					nota=sc.nextDouble();
					
					alumnos.replace(nombre1, nota);
				}
				break;
				
			case 3:
				sc.nextLine(); //limpiar buffer
				System.out.println("Anota el nombre del alumno");
				nombre1=sc.nextLine();
				
				if (!alumnos.containsKey(nombre1)) {
					System.out.println("Alumno no existe");
				}
				else {
					System.out.println("Anota el nombre del alumno");
					nombre2=sc.nextLine();

					nota=alumnos.get(nombre1);
					
					alumnos.remove(nombre1);
					alumnos.put(nombre2, nota);
				}
				break;
			
			case 4:
				sc.nextLine(); //limpiar buffer
				System.out.println("Anota el nombre del alumno");
				nombre1=sc.nextLine();
				
				if (!alumnos.containsKey(nombre1)) {
					System.out.println("Alumno no existe");
				}
				else {
					alumnos.remove(nombre1);
				}
				break;
				
			case 5:
				for (String i : alumnos.keySet()) {
					  System.out.println("Alumno: " + i + " Nota: " + alumnos.get(i));
					}
				break;

			default:
				break;
			}
		} while (op!=6);
		
		System.out.println("FIN");
	}

}
