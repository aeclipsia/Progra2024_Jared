package tarjetas;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

import bbdd.*;
import modelos.*;

public class Principal {
	/**
	 * @param args
	 */
	
	static int op;
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Cuentas> listaCuentas=new ArrayList<>();
	
	public static void main(String[] args) {
		BD_Tarjetas bd=new BD_Tarjetas("mysql-properties.xml");
		
		System.out.println("1-Alta crédito"
				+ "\n2-Alta débito"
				+ "\n3-Sacar dinero (Crédito)"
				+ "\n4-Sacar dinero (Débito)"
				+ "\n5-Movimientos no cargados"
				+ "\n6-Mostrar cuentas de un titular"
				+ "\n7-Alta movimientos"
				+ "\n8-Salir");
		System.out.print("Operación: \t");
		op=sc.nextInt();
		
		switch (op) {
		case 1:
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
			System.out.println("---->\t");
			int op=sc.nextInt();
			
			
			
			break;

		default:
			break;
		}
		
	}
}
