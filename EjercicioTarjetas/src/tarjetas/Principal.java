package tarjetas;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.nio.charset.*;

import bbdd.*;
import modelos.*;

public class Principal {
	/**
	 * @param args
	 */
	
	static int op;
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Cuentas> listaCuentas=new ArrayList<>();
	static ArrayList<Tarjetas> listaTarjetas=new ArrayList<>();
	static ArrayList<Movimientos> listaMovimientos=new ArrayList<>();
	static int numTarjeta, numCuenta;
	static String titular, clave;
	static double limite, imp;
	static DateTimeFormatter formato=DateTimeFormatter.ofPattern("yyyy-LL-dd");
	
	public static void main(String[] args) throws IOException {
		BD_Tarjetas bd=new BD_Tarjetas("mysql-properties.xml");
		
		System.out.println("1-Alta crédito"
				+ "\n2-Alta débito"
				+ "\n3-Sacar dinero (Débito)"
				+ "\n4-Sacar dinero (Crédito)"
				+ "\n5-Movimientos no cargados"
				+ "\n6-Mostrar cuentas de un titular"
				+ "\n7-Alta movimientos"
				+ "\n8-Salir");
		System.out.print("Operación: \t");
		op=sc.nextInt();
		
		switch (op) {
		case 1: //ALTA CRÉDITO
			sc.nextLine();
			System.out.print("Anota el dni: \t");
			String dni=sc.nextLine();
			try {
				listaCuentas=bd.buscarCuentas(dni);
			} catch (ErrorBaseDatos e) {
				System.out.println("Contacte con sistemas "+e.getMessage());
			}
			
			System.out.println("Elige cuenta: ");
			for (int i = 0; i < listaCuentas.size(); i++) {
				System.out.println("Cuenta "+i +": "+ listaCuentas.get(i).toString());
			}
			System.out.print("---->\t");
			int op=sc.nextInt();
			
			System.out.print("Anota el número de tarjeta:\t");
			numTarjeta=sc.nextInt();
			sc.nextLine();
			try {
				if (bd.checkNumTarjetaDuplicado(numTarjeta)) {
					System.out.println("Tarjeta ya existe");
					break;
				}
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage());
				break;
			}
			System.out.print("Anota el nombre del titular:\t");
			titular=sc.nextLine();
			System.out.print("Anota el límite:\t");
			limite=sc.nextInt();
			sc.nextLine();
			System.out.print("Anota la clave:\t");
			clave=sc.nextLine();
			
			try {
				bd.altaCredito(listaCuentas.get(op),numTarjeta,titular,limite,clave);
			} catch (ErrorBaseDatos e) {
				System.out.println("Contacte con sistemas"+e.getMessage());
			}
			
			break;
			
		case 2: //ALTA DÉBITO
			System.out.print("Anota número de cuenta:\t");
			numCuenta=sc.nextInt();
			sc.nextLine();
			System.out.print("Anota el nombre del titular:\t");
			titular=sc.nextLine();
			
			do {
				System.out.print("Anota la clave:\t");
				clave=sc.nextLine();
			} while (clave.length()!=4);
			
			try {
				if (bd.buscarCuentas2(numCuenta)) {
					bd.altaDebito(numCuenta,titular,clave);
				}
				else {
					System.out.println("Cuenta no encontrada");
					break;
				}
			} catch (ErrorBaseDatos e) {
				System.out.println("Contacte con sistemas"+e.getMessage());
			}			
			break;
			
		case 3: //Sacar dinero debito
			System.out.print("Anota el número de tarjeta:\t");
			numTarjeta=sc.nextInt();
			
			try {
				if (bd.buscarTarjeta(numTarjeta)) {
					System.out.println("Anota contraseña");
					sc.nextLine();
					clave=sc.nextLine();
					if (bd.authenticar(numTarjeta, clave)) {
						if (bd.isDebit(numTarjeta)&&bd.isBlocked(numTarjeta)) {
								System.out.print("Anota la cantidad que quiere sacar:\t");
								imp=sc.nextDouble();
								bd.sacar(numTarjeta, imp);
						}
					}
					else {
						System.out.println("Datos incorrectos");
					}
				}
				else {
					System.out.println("Tarjeta no encontrada");
				}
			} catch (ErrorBaseDatos e) {
				System.out.println("Contacte con sistemas"+e.getMessage());
			}
			break;
			
		case 4: //Sacar dinero credito
			System.out.print("Anota el número de tarjeta:\t");
			numTarjeta=sc.nextInt();
			
			try {
				if (bd.buscarTarjeta(numTarjeta)) {
					System.out.println("Anota contraseña");
					sc.nextLine();
					clave=sc.nextLine();
					if (bd.authenticar(numTarjeta, clave)) {
						if (!bd.isDebit(numTarjeta) && bd.isBlocked(numTarjeta)) {
								System.out.print("Anota la cantidad que quiere sacar:\t");
								imp=sc.nextDouble();
								
								if (bd.belowLimit(numTarjeta,imp)) {
									bd.sacar(numTarjeta, imp);
								}
								else {
									System.out.println("La tarjeta de crédito superaría el límite");
								}
						}
					}
					else {
						System.out.println("Datos incorrectos");
					}
				}
				else {
					System.out.println("Tarjeta no encontrada");
				}
			} catch (ErrorBaseDatos e) {
				System.out.println("Contacte con sistemas"+e.getMessage());
			}
			break;
	 		
		case 5:
			System.out.println("Anota el número de la tarjeta");
			numTarjeta=sc.nextInt();
			
			try {
				bd.cargarCredito(numTarjeta);
			} catch (ErrorBaseDatos e) {
				System.out.println(""+e.getMessage());
			}
			
			break;
			
		case 6:
			sc.nextLine();
			System.out.println("Anota el nombre del titular");
			titular=sc.nextLine();
			
			try {
				listaTarjetas = bd.infoTitular(titular);
				
				if (listaTarjetas.isEmpty()) {
					System.out.println("No hay tarjetas del titular "+titular);
					break;
				}
				
				for (int i = 0; i < listaTarjetas.size(); i++) {
					System.out.println(listaTarjetas.get(i).toString());
				}
			} catch (ErrorBaseDatos e) {
				System.out.println(""+e.getMessage());
			}
			break;
			
		case 7:
			Path fich=Paths.get("movimientos.txt");
			BufferedReader reader=null;
			Charset charset=Charset.forName("UTF-8");
			try {
				reader=Files.newBufferedReader(fich,charset);
				String lineaFichero= null;
				while ((lineaFichero=reader.readLine())!=null) {
					String[] separado=lineaFichero.split(" ");
					
					int n=Integer.parseInt(separado[0]);
					int t=Integer.parseInt(separado[1]);
					int c=Integer.parseInt(separado[2]);
					double l=Double.parseDouble(separado[3]);
					LocalDate cad=LocalDate.parse(separado[3],formato);
					
					listaMovimientos.add(new Movimientos(n/*Numero*/,
							t/*Tarjeta*/,
							c/*Cargado*/,
							l/*Limite*/,
							cad/*Caducidad*/)
							);
				}
			} catch (IOException e) {
				System.err.println(e);
			} finally {
				if (reader!=null) {
					reader.close();
				}
			}
			break;

		default:
			break;
		}
		
	}
}
