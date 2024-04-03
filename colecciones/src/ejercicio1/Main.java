package ejercicio1;

import java.util.*;

public class Main {

	static Scanner sc;
	
	public static void main(String[] args) {
		
		sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		int op;
		String nombre,nombre2;
		
		Vector<Alumno> alumnos = new Vector<Alumno>();

		//menu
		do {
			System.out.println("1.Alta\n2.Modificar nota\n3.Sustituir\n4.Borrar\n5.Mostrar\n6.Salir");
			op=sc.nextInt();
			
			switch (op) {
			case 1:
				sc.nextLine();
				
				System.out.println("Anota el nombre del alumno");
				nombre=sc.nextLine();
				if (alumnos.indexOf(new Alumno(nombre))!=-1) {
					System.out.println("Alumno ya existe");
				}
				else {
					System.out.println("Introduce nota");
					double nota=sc.nextDouble();
					alumnos.add(new Alumno(nombre,nota));
				}
				break;
				
			case 2:
				sc.nextLine();
				System.out.println("Anota el nombre del alumno que quieres modificar");
				nombre=sc.nextLine();
				if (alumnos.indexOf(new Alumno(nombre))==-1) {
					System.out.println("Alumno no existe");
				}
				else {
					System.out.println("Introduce nota");
					double nota=sc.nextDouble();
					alumnos.get(alumnos.indexOf(new Alumno(nombre))).setNota(nota);
				}
				break;
				
			case 3:
				sc.nextLine();
				System.out.println("Anota el nombre del alumno que quieres sustituir");
				nombre=sc.nextLine();
				
				System.out.println("Y por quién?");
				nombre2=sc.nextLine();
				
				if (alumnos.indexOf(new Alumno(nombre))==-1) {
					System.out.println("Alumno no existe");
				}
				else {
					System.out.println("Vas a sustituir a "+alumnos.get(alumnos.indexOf(new Alumno(nombre))).getNombre());
					
					System.out.println("Introduce nota");
					double nota=sc.nextDouble();
					alumnos.get(alumnos.indexOf(new Alumno(nombre))).setNota(nota);
					alumnos.get(alumnos.indexOf(new Alumno(nombre))).setNombre(nombre2);
				}
				break;
				
			case 4:
				sc.nextLine();
				System.out.println("Anota el nombre del alumno que quieres borrar");
				nombre=sc.nextLine();
				
				if (alumnos.indexOf(new Alumno(nombre))==-1) {
					System.out.println("Alumno no existe");
				}
				else {
					alumnos.remove(alumnos.indexOf(new Alumno(nombre)));
				}
				break;
				
			case 5:
					System.out.println(alumnos.toString());
				break;

			default:
				break;
			}
		} while (op!=6);
	}
	
	public static int buscarAlumnos(Vector<Alumno> al, String alumnos) {
		for (int i = 0; i < al.size(); i++) {
			if ((al.get(i).getNombre().equals(alumnos))) {
				return i;
			}
		}
		return -1;
	}
	
}
