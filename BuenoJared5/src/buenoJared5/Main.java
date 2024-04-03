package buenoJared5;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;


public class Main {

	static Scanner sc;
	
	public static void main(String[] args) {
		
		sc=new Scanner(System.in);
		
		String mat, matQuerido;
		boolean matVal;
		int op;
		int codReserva;
		double importe;
		
		
		//dar de alta a los vehiculos
		System.out.println("Anota las matrículas separados por \",\":");
		mat=sc.nextLine();
		
		String matriculas[]=mat.split(",");		
		
		int lengthMat = matriculas.length;
		
		for (int i = 0; i < lengthMat; i++) {
			matVal=validarMatricula(matriculas[i]);			
			if (matVal==false) {
				
				for (int j = i; j < lengthMat - 1; j++)
					matriculas[j] = matriculas[j + 1];

				lengthMat--;
				i--;
			}
		}
		/* ESTE CÓDIGO ES PARA COMPROBAR SI BORRA BIEN LAS MATRICULAS NO VÁLIDAS
		for (int i = 0; i < lengthMat; i++) {
			System.out.println(matriculas[i]);
		}
		*/
		
		Vehiculo vehiculos[] = new Vehiculo[lengthMat];
		
		for (int i = 0; i < vehiculos.length; i++) {
			vehiculos[i] = new Vehiculo(matriculas[i]);
		}
		
		//menu
		do {
			op=0;
			try {
				System.out.println("------------------------------\n"
						+ "1.Reservar\n"
						+ "2.Abrir\n"
						+ "3.Aparcar\n"
						+ "4.Salir");
				op=sc.nextInt();
				
				switch (op) {
				case 1: //reservar
					try {
						System.out.println("********Vehículos********");
						for (int i = 0; i < vehiculos.length; i++) {
							System.out.println((i+1)+")." +vehiculos[i].infoVehiculo());
						}
						op=sc.nextInt();
						if (vehiculos[op-1].getEstado()==0) {
							codReserva=reservar(vehiculos[op-1]);
							System.out.println("Su código de reserva es: "+codReserva);
						}
						else {
							System.err.println("Vehículo no disponible");
						}
					} catch (InputMismatchException e) {
						System.err.println("Anota sólo números");
						sc.nextLine();
					} catch (ArrayIndexOutOfBoundsException e) {
						System.err.println("Vehículo no existe");
					}
					
					break;
					
				case 2: //abrir
					sc.nextLine();
					System.out.println("********Vehículos********");
					System.out.println("Anota la matrícula de su vehículo: ");
					for (int i = 0; i < vehiculos.length; i++) {
						System.out.println(vehiculos[i].infoVehiculo());
					}
					matQuerido=sc.nextLine();
					op=buscarVehiculo(vehiculos, matQuerido);
					if (op==-1) {
						System.out.println("Vehículo no existe");
					}
					else {
						if (vehiculos[op].getEstado()==1) {
							abrirVehiculo(vehiculos[op]);
						}
						else {
							System.out.println("Este vehículo no está reservado");
						}
					}
					break;
					
				case 3:
					sc.nextLine();
					System.out.println("********Vehículos********");
					System.out.println("Anota la matrícula de su vehículo: ");
					for (int i = 0; i < vehiculos.length; i++) {
						System.out.println(vehiculos[i].infoVehiculo());
					}
					matQuerido=sc.nextLine();
					op=buscarVehiculo(vehiculos, matQuerido);
					if (op==-1) {
						System.out.println("Vehículo no existe");
					}
					else {
						if (vehiculos[op].getEstado()==2) {
							importe=calcularPago(vehiculos[op]);
							
							System.out.printf("Importe a pagar: %.2f euros.\n", importe);
						}
						else {
							System.out.println("Este vehículo no está en funcionamento");
						}
					}
					break;

				case 4:
					
					System.err.println("Programa terminada");
					
					break;
					
				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Opción incorrecta, anota número");
				sc.next();
			} catch (NullPointerException e) {
				System.err.println("Debe anotar un número");
				sc.next();
			}
			
		} while (op!=4);
		
		
		
	}
	
	public static double calcularPago(Vehiculo v) {
		double importe;
		long timeFuncionamento;
		
		timeFuncionamento=ChronoUnit.SECONDS.between(v.getTimeFuncionamento(), LocalTime.now());
		
		importe=0.8*timeFuncionamento;
		
		v.setEstado(0);
		return importe;
		
	}
	
	public static int buscarVehiculo(Vehiculo v[], String matQuerido) {
		String matricula;
		for (int i = 0; i < v.length; i++) {
			matricula=v[i].getMatricula();
			if (matQuerido.equalsIgnoreCase(matricula)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void abrirVehiculo(Vehiculo v) {
		int codReserva,tries=3;
		
		do {
			System.out.println("Anota su código de reserva");
			codReserva=sc.nextInt();
			
			if (codReserva!=v.getCodReserva()) {
				tries--;
				System.err.println("Código incorrecto. Te quedan "+tries+" intentos.");
			}
			else {
				tries=0;
				if (ChronoUnit.SECONDS.between(v.getTimeReserva(), LocalTime.now())<=20) {
					v.setEstado(2);
					v.setTimeFuncionamento(LocalTime.now());
				}
				else {
					System.out.println("Ya ha transcurrido más de 20 segundos desde que se reservó. "
							+ "Su reserva ha sido cancelada.");
					v.setEstado(0);
				}
			}
		} while (tries>0);
		
	}
	
	public static int reservar(Vehiculo v) {
		int cod;
		
		cod=(int)(Math.random()*100);
		
		v.setCodReserva(cod);
		
		v.setEstado(1);
		
		v.setTimeReserva(LocalTime.now());
		
		return cod;
	}
	
	public static boolean validarMatricula(String matricula) {
		if (matricula.length()!=6) { //cambiar 6 por 7
			return false;
		}
		else {
			try {
				Integer.parseInt(matricula.substring(0,4));
			} catch (NumberFormatException e) {
				return false;
			}
			for (int i = 4; i < 6; i++) {
				if (Character.toUpperCase(matricula.charAt(i)) < 'A'
						|| Character.toUpperCase(matricula.charAt(i)) > 'Z') {
					return false;
				}
			}
		}
		return true;
	}
}
