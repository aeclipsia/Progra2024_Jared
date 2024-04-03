package repasofichajes;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado empleados[] = new Empleado[5];
		Fichaje fichajes[] = new Fichaje[40];

		// LocalTime horaEntrada, horaSalida;
		int nFichajes = 0, incidencia = 0;
		int numEmp, opc, pos;
		String dni;
		boolean correcto;

		sc = new Scanner(System.in);

		// horaEntrada=leerHora();
		// horaSalida=leerHora();
		Fichaje.setHoraEntradaTodos(leerHora("Hora entrado todos:"));
		Fichaje.setHoraSalidaTodos(leerHora("Hora salida todos:"));

		// Alta empleados

		for (int i = 0; i < empleados.length; i++) {
			numEmp = leerNumero("Anota número");
			sc.nextLine(); // Limpio
			do {
				System.out.println("Anota dni:");
				dni = sc.nextLine();
				correcto = valDni(dni);
				if (!correcto)
					System.out.println("Dni incorrecto");
			} while (correcto == false);
			empleados[i] = new Empleado(dni, numEmp);

		}

		// entro en menu
		do {
			System.out.println("1.Entrada\n2.Salida\7.Terminar");
			opc = leerNumero("\nAnota opción:");
			switch (opc) {
			case 1:
				if (nFichajes == fichajes.length)
					System.out.println("No se pueden dar de alta más fichajes");
				else {
					numEmp = leerNumero("Anota número de empleado:");
					pos = buscarEmp(empleados, numEmp);
					if (pos == -1)
						System.out.println("No existe ese empleado");
					else {
						System.out.println("Anota contraseña:");
						String contraseña = sc.nextLine();
						if (empleados[pos].validarContraseña(contraseña) == false)
							System.out.println("Contraseña inválida");
						else {
							if (empleados[pos].isDentro()) {
								incidencia = 3;
								System.out.println("Error, ya has fichado entrada");
							} else {
								incidencia = 0;
								empleados[pos].setDentro(true);
							}

							
							fichajes[nFichajes] = new Fichaje(numEmp, 0, incidencia);
							nFichajes++;
						}
					}
				}
				break;
				
			case 2:// Fichar salida
				break; 
			}
		} while (opc != 7);

	}

	private static LocalTime leerHora(String msg) {
		String horaS;
		LocalTime hora = null;
		boolean correcta = false;
		do {
			System.out.println(msg);
			horaS = sc.nextLine();
			try {
				hora = LocalTime.parse(horaS);
				correcta = true;
			} catch (DateTimeParseException e) {
				System.out.println("Formato incorrecto");
			}
		} while (correcta == false);
		return hora;
	}

	private static int leerNumero(String mensaje) {
		int num = 0;
		boolean correcto = false;
		do {
			System.out.println(mensaje);
			try {
				num = sc.nextInt();
				correcto = true;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("No es un número");
			}
		} while (correcto == false);
		return num;
	}

	private static boolean valDni(String dni) {
		String numS;
		int num;
		if (dni.length() < 2 || dni.length() > 9)
			return false;
		char ultima = Character.toUpperCase(dni.charAt(dni.length() - 1));
		if (ultima < 'A' || ultima > 'Z')
			return false;
		numS = dni.substring(0, dni.length() - 1);
		try {
			num = Integer.parseInt(numS);
			// Validar que la letra se corresponde con el módulo del
			// número -- completarlo
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	public static int buscarEmp(Empleado emp[], int num) {
		for (int i = 0; i < emp.length; i++)
			if (emp[i].getnEmp() == num)
				return i;

		return -1;
	}

}
