package ej2;

import java.util.*;

public class Main {

	static Scanner sc;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);

		int cont;
		
		System.out.println("Anota número de alumnos");
		cont=sc.nextInt();
		sc.nextLine();
		
		Alumno alumnos[] = new Alumno[cont];
		
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i]=crearAlumno();
		}
		
		for (int i = 0; i < alumnos.length; i++) {
			System.out.println(alumnos[i].toString());
		}
		
	}
	
	public static Alumno crearAlumno() {
		String nombre, apellidos, curso, pais, carreraProc;
		double importe;
		int op;
		Alumno a;
		
		System.out.println("Anota su nombre");
		nombre=sc.nextLine();
		
		System.out.println("Anota sus apellidos");
		apellidos=sc.nextLine();
		
		System.out.println("Anota su curso");
		curso=sc.nextLine();
		
		System.out.println("Anota el importe de matrícula");
		importe=sc.nextDouble();
		
		System.out.println("Tipo de alumno: \n0-Normal\n1-Extranjero\n2-Puente");
		op=sc.nextInt();
		
		sc.nextLine();
		
		switch (op) {
		case 0:
			a = new Alumno(nombre, apellidos, curso, importe);
			return a;
		
		case 1:
			System.out.println("Anota su país de origen");
			pais=sc.nextLine();
			
			a = new Extranjero(nombre, apellidos, curso, importe, pais);
			return a;
			
		case 2:
			System.out.println("Anota su carrera de procedencia");
			carreraProc=sc.nextLine();
			
			a = new Puente(nombre, apellidos, curso, importe, carreraProc);
			return a;
			
		default:
			System.out.println("Opción no válido");
			break;
		}
		
		return a=null;
	}
}
