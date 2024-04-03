package ejercicio2;

import java.util.*;

import ejercicio1.Alumno;

public class Main {

	static Scanner sc;
	static int op, countProp=0, countExt=0;
	static Vector<Empleado> emples = new Vector<Empleado>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc=new Scanner(System.in);
		
		//menu
		do {
			System.out.println("1-Alta\n2-Fichar\n3-Reparto de beneficios\n4-Pagar\n5-Mostrar\n6-Salir");
			op=sc.nextInt();
			
			switch (op) {
			case 1: //ALTA
				sc.nextLine();
				altaEmple();
				break;
				
			case 2: //FICHAR
				ficharEmple();
				break;
			
			case 3: //REPARTIR BENEFICIOS
				repartirBeneficios();
				break;
				
			case 4: //PAGAR EMPLEADOS
				pagarEmple();
				break;
				
			case 5:
				System.out.println(emples.toString());
				break;

			default:
				break;
			}
			
		} while (op!=6);
	}

	public static void altaEmple() {
		String nombre, dni, direccion, telefono, proc;
		int numEmple;
		
		System.out.println("Anota el número de empleado");
		numEmple=sc.nextInt();
		sc.nextLine(); //limpiar buffer
		
		System.out.println("Anota nombre");
		nombre=sc.nextLine();
		
		System.out.println("Anota dni");
		dni=sc.nextLine();
		
		System.out.println("Anota direccion");
		direccion=sc.nextLine();
		
		System.out.println("Anota telefono");
		telefono=sc.nextLine();
		
		do {
			System.out.println("Es externo? 0-No 1-Sí");
			op=sc.nextInt();
			
			switch (op) {
			case 0:
				
				System.out.println("Bonus de interno");
				double bonus=sc.nextDouble();
				
				emples.add(new Empleado(numEmple ,nombre, dni, direccion, telefono, bonus));
				
				countProp++;
				break;
				
			case 1:
				sc.nextLine();
				
				System.out.println("Anota empresa de procedencia");
				proc=sc.nextLine();
				
				emples.add(new Externo(numEmple, nombre, dni, direccion, telefono, proc));
				
				countExt++;
				break;

			default:
				System.out.println("Anota 0 o 1");
				continue;
			}
		} while (op!=0 && op!=1);
	}
	
	public static void ficharEmple() {
		int numEmple;
		
		System.out.println("Anota el número de empleado");
		numEmple=sc.nextInt();
		if ((emples.indexOf(new Empleado(numEmple)))==-1) {
			System.out.println("Empleado no existe");
		}
		else {
			System.out.println("Anota las horas realizadas");
			int horas=sc.nextInt();
			
			emples.get(emples.indexOf(new Empleado(numEmple))).addHoras(horas);
		}
	}
	
	public static void repartirBeneficios() {
		System.out.println("Cuantos euros se reparten?");
		double benefFull = sc.nextDouble();
		
		for (int i = 0; i < emples.size(); i++) {
			if (!emples.getClass().getSimpleName().equalsIgnoreCase("Externo")) {
				emples.get(i).addBenef(benefFull/countProp);
			}
		}	
	}
	
	public static void pagarEmple() {
		for (int i = 0; i < emples.size(); i++) {
			System.out.println(emples.get(i).pagar());
		}
	}
}
