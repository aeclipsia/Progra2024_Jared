package ejercicioRepaso1;

import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

	public static void main(String[] args) {

		Empleado emple[]=new Empleado[5];
		
		int tabla[][]=new int[4][emple.length];
		
		Scanner sc=new Scanner(System.in);
		
		LocalTime hEntrada = null, hSalida = null;
		
		//hora de entrada y salida
		hEntrada = leerHora(sc, hEntrada);
		
		System.out.println("Hora de entrada: "+hEntrada);
		
		hSalida = leerHora(sc, hEntrada);
		
		System.out.println("Hora de salida: "+hSalida);

		//creación de empleados
		for (int i = 0; i < emple.length; i++) {
			emple[i]=crearEmpleado(sc);
		}
		
		int ope;
		int contador=0;
		Fichaje fichaje[]=new Fichaje[50];
		int numEmple, posEmple;
		
		do { //validar menu opción
			ope=0;
			
			try {
				fichaje[contador].setIncidencia(false);
			} catch (NullPointerException e) {
				
			}
			
			try {
				System.out.println("1-Entrada\n2-Salida\n3-Mostrar fichajes\n4-Mostrar incidencias\n"
						+ "5-Mostrar empleados en la empresa\n6-Información\n7-Salir");
				ope=sc.nextInt();
				if (ope<1 || ope>7) {
					System.err.println("Opción no válido");
					continue;
				}
				
				switch (ope) {
				case 1: //entrada
						
					do { //buscador de empleado
						System.out.println("Anota el número de empleado");
						numEmple=sc.nextInt();
						posEmple=-1;
						posEmple=buscarEmple(emple,numEmple);
						if (posEmple==-1) {
							System.out.println("Empleado no encontrado");
						}
					} while (posEmple==-1);
					
															
					fichaje[contador]=crearFichaje(emple, ope, posEmple);
					
					if (LocalTime.now().isAfter(hEntrada) && LocalTime.now().isBefore(hSalida)) {
						emple[posEmple].addIncidencias();
						fichaje[contador].setIncidencia(true);
					}
					else if (emple[posEmple].isDentro()==true) {
						emple[posEmple].addIncidencias();
						fichaje[contador].setIncidencia(true);
					}
					
					emple[posEmple].setDentro(true);
					
					emple[posEmple].addEntradas();
					
					contador++;
					break;
					
				case 2: //salida
					
					do { //buscador de empleado
						System.out.println("Anota el número de empleado");
						numEmple=sc.nextInt();
						posEmple=-1;
						posEmple=buscarEmple(emple,numEmple);
						if (posEmple==-1) {
							System.out.println("Empleado no encontrado");
						}
					} while (posEmple==-1);
					
					
										
					fichaje[contador]=crearFichaje(emple, ope, posEmple);
					
					if (LocalTime.now().isAfter(hEntrada) && LocalTime.now().isBefore(hSalida)) {
						emple[posEmple].addIncidencias();
						fichaje[contador].setIncidencia(true);
					}
					else if (emple[posEmple].isDentro()==false) {
						emple[posEmple].addIncidencias();
						fichaje[contador].setIncidencia(true);
					}
					
					emple[posEmple].addSalidas();
					
					emple[posEmple].setDentro(false); 
					
					contador++;
					
					break;
					
				case 3:
					do { //buscador de empleado
						System.out.println("Anota el número de empleado");
						numEmple=sc.nextInt();
						posEmple=-1;
						posEmple=buscarEmple(emple,numEmple);
						if (posEmple==-1) {
							System.out.println("Empleado no encontrado");
						}
					} while (posEmple==-1);
					
					for (int j = 0; j < contador; j++) {
						if (emple[posEmple].getNumEmple()==fichaje[j].getNumEmple()) {
							System.out.println(fichaje[j].toString());
						}
					}
					
					System.out.println("Total tiempo trabajado: "+emple[posEmple].getTimeTrabajado()+" mins");
					
					break;
					
				case 4:
					for (int i = 0; i < contador; i++) {
						if (fichaje[i].getIncidencia()==true) {
							System.out.println(fichaje[i].toString());
						}
					}
					break;
				
					
				case 5:
					for (int i = 0; i < emple.length; i++) {
						if (emple[i].isDentro()==true) {
							System.out.println(emple[i].toString());
						}
					}	
					break;
					
				case 6:
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < emple.length; j++) {
								switch (i) {
								case 0:
									tabla[i][j]=emple[j].getNumEmple();
									break;
									
								case 1:
									tabla[i][j]=emple[j].getEntradas();
									break;
									
								case 2:
									tabla[i][j]=emple[j].getSalidas();
									break;
									
								case 3:
									tabla[i][j]=emple[j].getIncidencias();
									break;

								default:
									break;
								}
						}
					}
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < emple.length+1; j++) {
							if (j==0) {
								switch (i) {
								case 0:
									System.out.print("Número de empleado: ");
									break;
									
								case 1:
									System.out.print("Nº de entradas: ");
									break;
									
								case 2:
									System.out.print("Nº de salidas: \t");
									break;
									
								case 3:
									System.out.print("Nº de incidencias: ");
									break;
								}
							}
							else {
								System.out.print("\t"+tabla[i][j-1]);
							}
						}
						System.out.println();
					}
					break;

				default:
					
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Debes anotar un número:");
				sc.nextLine();
				continue;
			}
		} while (ope!=7);
		

	}

	public static LocalTime leerHora(Scanner sc, LocalTime hEntrada) {
		boolean hVal;
		do {
			hVal=true;
			try {
				System.out.println("Anota la hora con formato hh:mm: ");
				hEntrada = LocalTime.parse(sc.next());
			} catch (DateTimeParseException e) {
				System.out.println("Hora incorrecta");
				hVal=false;
			}
		} while (hVal==false);
		return hEntrada;
	}
	
	public static Empleado crearEmpleado(Scanner sc) {
		int numemple=0;
		String dni;
		boolean repeat, dniVal;
		
		do {
			repeat=false;
			try {
				System.out.println("Anota el número de empleado: ");
				numemple=sc.nextInt();	
				sc.nextLine();
			} catch (InputMismatchException e) {
				repeat=true;
				System.out.println("Sólo acepta números");
				sc.nextLine();
			}
		} while (repeat==true);
		
		do {
			dniVal=true;
			
			System.out.println("Anota el DNI: ");
			dni=sc.nextLine();
			
			dni=convertirNIE(dni);
			dniVal=validarDNI(dni);
			
		} while (dniVal==false);
		
		Empleado empleado = new Empleado(numemple,dni);
		return empleado;
		
	}
	
	public static String convertirNIE(String dni) {
		if (dni.charAt(0)=='X' || dni.charAt(0)=='x') {
			dni=0+dni.substring(1,dni.length());
		}
		else if (dni.charAt(0)=='Y' || dni.charAt(0)=='y') {
			dni=1+dni.substring(1,dni.length());
		}
		else if (dni.charAt(0)=='Z' || dni.charAt(0)=='z') {
			dni=2+dni.substring(1,dni.length());
		}
		else {
			dni=dni;
		}
		return dni;
	}
	
	public static boolean validarDNI(String dni) {
		int calc;
		boolean letraVal;
		
		if (dni.length()<2||dni.length()>9) {
			return false;
		}
		try {
			calc=Integer.parseInt(dni.substring(0,dni.length()-1));
		} catch (NumberFormatException e) {
			return false;
		}
		
		calc=calc%23;
		
		letraVal=validarLetra(calc,dni);
		if (letraVal==false) {
			return false;
		}
		return true;
	}
	
	public static boolean validarLetra(int calc, String dni) {
		String letras="trwagmyfpdxbnjzsqvhlcke";
		
		if (dni.charAt(dni.length()-1)==letras.charAt(calc)) {
			return true;
		}
		return false;
	}
	
	public static int buscarEmple(Empleado emple[], int numEmple) {
		for (int i = 0; i < emple.length; i++) {
			if (numEmple==emple[i].getNumEmple()) {
				return i;
			}
		}
		return -1;
	}
	
	public static Fichaje crearFichaje(Empleado emple[], int ope, int i) {
		Scanner sc = new Scanner(System.in);
		
		char tipo;
		String password;
		int numEmple;
		boolean contraVal;
		
		if (ope==1) {
			tipo='e';
		}
		else {
			tipo='s';
		}
		
		do {
			contraVal=true;
			System.out.println("Anota contraseña: ");
			password=sc.nextLine();
			
			if (password.equalsIgnoreCase(emple[i].getDni().substring(4, emple[i].getDni().length()-1))) {
				System.out.println("Contraseña correcta");
			}
			else {
				System.err.println("Contraseña incorrecta");
				contraVal=false;
			}
		} while (contraVal==false);
		
		numEmple=emple[i].getNumEmple();
		
		Fichaje fi = new Fichaje(tipo,numEmple,password);
		return fi;
	}

}
