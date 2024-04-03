package ejercicio8;

import java.util.*;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static Cabina cabinas[] = new Cabina[8];
	static int opmenu, op, rand;
	static String mat, tipo;

	public static void main(String[] args) {

		for (int i = 0; i < cabinas.length; i++) { //inicialización de manera aleatoria a 8 cabinas
			rand=(int)(Math.random()*2+1);
			if (rand==1) {
				cabinas[i] = new Normal();
			}
			else {
				cabinas[i] = new Abonados();
			}
		}
		
		//menu
		do {
			System.out.println("1-Abrir Cabina\n2-Entrada de vehículo\n3-Pagar vehículo\n4-Mostrar info\n5-Cerrar\n6-Salir");
			opmenu=sc.nextInt();
			
			switch (opmenu) {
			case 1:
				abrirCabina();
				break;
				
			case 2:
				sc.nextLine();
				entraVeh();
				break;
				
			case 4:
				for (int i = 0; i < cabinas.length; i++) {
					System.out.println(cabinas[i].getClass().getSimpleName()+": Nº de vehículos "+cabinas[i].getNumVehiculos());
					for (int j = 0; j < args.length; j++) {
						System.out.println(cabinas[i].vehiculos.get(j).toString());
					}
				}
				break;

			default:
				break;
			}
			
		} while (opmenu!=6);
		
	}
	
	public static void abrirCabina() {
		System.out.println("Número de cabina para abrir");
		op=sc.nextInt()-1;
		
		if (cabinas[op].isAbierta()) {
			System.err.println("Esta cabina ya está abierta");
		}
		else {
			System.out.println("La cabina "+(op+1)+" se abrirá");
			cabinas[op].openCabina();
		}
	}
	
	public static void entraVeh() {
		System.out.println("Anota número de matrícula");
		mat=sc.nextLine();
		
		System.out.println("Anota su tipo");
		tipo=sc.nextLine();
		try {
			checkTipo(tipo);
		} catch (tipoClienteIncorrecto e) {
			System.out.println(e.getMessage());
		}
		
		addToCola(mat, tipo);
	}
	
	public static void checkTipo(String tipo) throws tipoClienteIncorrecto{
		if (tipo.equalsIgnoreCase("abonado")||tipo.equalsIgnoreCase("normal")) {
			return;
		}
		throw new tipoClienteIncorrecto ("El tipo debe ser abonado o normal");
	}
	
	public static void addToCola(String mat, String tipo) {
		Vehiculo a=new Vehiculo(mat, tipo);
		
		int min=100;
		int temp=0;
		
		for (int i = 0; i < cabinas.length; i++) {
			if (cabinas[i].isAbierta() &&
					cabinas[i].getClass().getSimpleName().equalsIgnoreCase(tipo) &&
					cabinas[i].getNumVehiculos()<=min) {
				temp=i;
				min=cabinas[i].getNumVehiculos();
			}
		}
		
		cabinas[temp].vehiculos.add(a);
		cabinas[temp] = new Cabina (cabinas[temp].vehiculos);
	}

}
