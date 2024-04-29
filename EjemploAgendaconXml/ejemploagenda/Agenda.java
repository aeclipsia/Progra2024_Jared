/*
 * agenda: Programa principal.
 */

package ejemploagenda;

import java.io.*;
import java.util.*;

import bbdd.BD_Conector;
import modelos.Contacto;
import bbdd.*;

public class Agenda {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int opc = 0;
		String nombre = "", telefono = "", apellidos = "";
		Contacto ct;
		BD_Agenda bd = new BD_Agenda("mysql-properties.xml");

		do {
			System.out.println(
					"\n1.Nuevo Contacto\n2.Borrar Contacto\n3.Consultar teléfono\n4.Mostrar contactos\n5. Salir");
		
				opc = sc.nextInt();
			
			switch (opc) {
			case 1:
				sc.nextLine();//Limpiando buffer
				System.out.println("Introduce nombre");
				nombre = sc.nextLine();
				System.out.println("Introduce apellidos");
				apellidos = sc.nextLine();
				System.out.println("Introduce telefono");
				telefono = sc.nextLine();
				ct = new Contacto(nombre, apellidos, telefono);
				if (bd.añadir(ct))
					System.out.println("Añadido");
				else
					System.out.println("No se ha podido añadir");
				break;
				
			case 2:
				sc.nextLine(); //Limpiando buffer
				System.out.println("Introduce nombre");
				nombre = sc.nextLine();
				System.out.println("Introduce apellidos");
				apellidos = sc.nextLine();
				System.out.println("Introduce telefono");
				telefono = sc.nextLine();
				ct = new Contacto(nombre, apellidos, telefono);
				int filas = bd.borrar(ct);
				switch (filas) {
				case 0:
					System.out.println("No es contacto");
					break;
				case 1:
					System.out.println("Contacto elimindado");
					break;
				default:
					System.out.println("En este momento no podemos eliminar. Inténtalo más tarde");
				}

				break;
			case 3:
				sc.nextLine(); //Limpiando buffer
				System.out.println("Introduce nombre");
				nombre = sc.nextLine();
				System.out.println("Introduce apellidos");
				apellidos = sc.nextLine();
				ct = new Contacto(nombre, apellidos);
				telefono = bd.buscarTelefono(ct);
				if (telefono == null)
					System.out.println("Por motivos técnicos no podemos obtener la información en este momento");
				else if (telefono.equals(""))
					System.out.println("No es contacto");
				else
					System.out.println("Su teléfono es: " + telefono);
				break;
			case 4:
				ArrayList<Contacto> v = bd.mostrarContactos();
				for (int i = 0; i < v.size(); i++)
					System.out.println(v.get(i));

			}
		} while (opc != 5);

	}

}
