package ejercicio6vol;

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class Main {

	static BufferedReader reader = null;
	static Scanner sc = new Scanner (System.in);
	static int op;
	static String nombre, pass;
	static Charset charset = Charset.forName("UTF-8");
	static boolean usuEx, passC;
	
	public static void main(String[] args) {
		
		Path file = Paths.get("fichero/ej4V.xml");
		
		do {
			usuEx=false;
			passC=false;
			try {
				System.out.println("Anota un nombre");
				nombre=sc.nextLine();
				reader=Files.newBufferedReader(file,charset);
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (line.indexOf(nombre)!=-1) { //comprueba que el nombre introducido es lo mismo
						usuEx=true;
						System.out.println("Anota su contraseña");
						pass=sc.nextLine();
						if ((line = reader.readLine()).indexOf(pass)!=-1) { //salta a la siguiente linea y comprueba que está la contraseña igual
							passC=true;
							System.out.println("Minutos conectados del usuario "+nombre+": "+(line=reader.readLine()).replace("<conexion>", "")
									.replace("</conexion>", ""));
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (!usuEx) {
				System.err.println("Usuario no encontrado");
			}
			else {
				if (!passC) {
					System.err.println("Contraseña incorrecta");
				}
			}
			System.out.println("Quieres seguir?\n1-Sí\n2-no");
			op=sc.nextInt();
			sc.nextLine();
		} while (op!=2);
	}
}
