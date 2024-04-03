package ejercicioRepaso2;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {

	static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Empleado emple[]=new Empleado[5];
				
		int tipoIncidencia = 0;
		int nEmple, ope, posEmple;
		String dni;
		boolean dniVal;
		
		sc=new Scanner(System.in);
		
		//Hora de entrada y salida
		Fichaje.setHoraEntradaTodos(leerHora("Introduce la hora de entrada"));
		Fichaje.setHoraSalidaTodos(leerHora("Introduce la hora de salida"));
		
		//Crear empleados
		for (int i = 0; i < emple.length; i++) {
			nEmple = leerNumero("Anota número");
			sc.nextLine(); // Limpio
			do {
				System.out.println("Anota dni:");
				dni = sc.nextLine();
				dniVal = validarDni(dni);
				if (!dniVal)
					System.out.println("Dni incorrecto");
			} while (dniVal == false);
			emple[i] = new Empleado(dni, nEmple);
		}
		//Menu
		do {
			System.out.println("1.Entrada\n2.Salida\n7.Terminar");
			ope = leerNumero("\nAnota opción:");
			switch (ope) {
			case 1:
				nEmple = leerNumero("Anota número de empleado:");
				posEmple = buscarEmpleado(emple, nEmple);
				if (posEmple == -1)
					System.out.println("No existe ese empleado");
				else {
					System.out.println("Anota contraseña:");
					String password = sc.nextLine();
					if (emple[posEmple].validarPassword(password) == false)
						System.out.println("Contraseña inválida");
					else {
						if (emple[posEmple].isDentro()) {
							tipoIncidencia = 3;
							System.out.println("Error, ya has fichado entrada");
						} else {
							tipoIncidencia = 0;
							emple[posEmple].setDentro(true);
						}

						emple[posEmple].fichajes[emple[posEmple].getnFichajes()] = new Fichaje(nEmple, 0, tipoIncidencia);
						emple[posEmple].addFichajes();
					}
				}
				break;
				
			case 2:// Fichar salida
				nEmple = leerNumero("Anota número de empleado:");
				posEmple = buscarEmpleado(emple, nEmple);
				if (posEmple == -1)
					System.out.println("No existe ese empleado");
				else {
					System.out.println("Anota contraseña:");
					String password = sc.nextLine();
					if (emple[posEmple].validarPassword(password) == false)
						System.out.println("Contraseña inválida");
					else {
						if (emple[posEmple].isDentro()) {
							tipoIncidencia = 4;
							System.out.println("Error, ya has fichado salida");
						} else {
							tipoIncidencia = 0;
							emple[posEmple].setDentro(false);
						}

						emple[posEmple].fichajes[emple[posEmple].getnFichajes()] = new Fichaje(nEmple, 1, tipoIncidencia);
						emple[posEmple].addFichajes();
					}
				}
				break; 
				
			case 3:// Mostrar fichajes de un empleado en concreto
				do { //buscador de empleado
					System.out.println("Anota el número de empleado");
					nEmple=sc.nextInt();
					posEmple=-1;
					posEmple=buscarEmpleado(emple,nEmple);
					if (posEmple==-1) {
						System.out.println("Empleado no encontrado");
					}
				} while (posEmple==-1);
				emple[posEmple].showFichajes();
				break;
			}
		} while (ope!=7);
		
		
	}
	
	public static LocalTime leerHora(String mensaje) {
		String horaString;
		LocalTime hora = null;
		boolean correcta = false;
		do {
			System.out.println(mensaje);
			horaString = sc.nextLine();
			try {
				hora = LocalTime.parse(horaString);
				correcta = true;
			} catch (DateTimeParseException e) {
				System.out.println("Formato incorrecto");
			}
		} while (correcta == false);
		return hora;
	}
	
	private static boolean validarDni(String dni) {
		String numStringParsed;
		int numIntParsed;
		
		if (dni.length() < 2 || dni.length() > 9)
			return false;
		
		char firstDniChar=Character.toUpperCase(dni.charAt(0));
		if (firstDniChar == 'X') {
			dni=0+dni.substring(1,dni.length());
		}
		else if (firstDniChar == 'Y') {
			dni=1+dni.substring(1,dni.length());
		}
		else if (firstDniChar == 'Z') {
			dni=2+dni.substring(1,dni.length());
		}
		
		char lastDniChar = Character.toUpperCase(dni.charAt(dni.length() - 1));
		if (lastDniChar < 'A' || lastDniChar > 'Z')
			return false;
		
		numStringParsed = dni.substring(0, dni.length() - 1);
		try {
			numIntParsed = Integer.parseInt(numStringParsed);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private static int leerNumero(String mensaje) {
		int nEmple = 0;
		boolean nVal = false;
		
		do {
			System.out.println(mensaje);
			try {
				nEmple = sc.nextInt();
				nVal = true;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("No es un número");
			}
		} while (nVal == false);
		return nEmple;
	}
	
	public static int buscarEmpleado(Empleado emp[], int num) {
		for (int i = 0; i < emp.length; i++)
			if (emp[i].getnEmple() == num)
				return i;

		return -1;
	}

}
