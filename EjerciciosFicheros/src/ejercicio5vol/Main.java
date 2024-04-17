package ejercicio5vol;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.OpenOption;
import static java.nio.file.StandardOpenOption.*;
import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static int op;
	
	public static void main(String[] args) {
		Path file= Paths.get("fichero/ej4V.xml");
		Charset charset = Charset.forName("UTF-8");
		
		try {
			BufferedWriter writer = Files.newBufferedWriter(file, charset);
			
			BufferedReader archivo=Files.newBufferedReader(file);
			
			String content=null;
			
			if ((content=archivo.readLine())==null) {
				writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
				"<?xml-stylesheet type=\"text/xsl\" href=\"ej4V.xsl\"?>\n"
				+ "<usuarios>\n");
			}
			
			do{
				System.out.println("Anota el nombre");
				String nombre=sc.nextLine();
				System.out.println("Anota la contraseña");
				String pass=sc.nextLine();
				System.out.println("Cuantos minutos ha estado conectado durante la semana");
				int min=sc.nextInt();
				
				writer.write("<usuario>\n"
						+ "<nombre>"+nombre+"</nombre>\n"
						+ "<password>"+pass+"</password>\n"
						+ "<conexion>"+min+"</conexion>\n"
						+ "</usuario>\n");
				
				System.out.println("Quieres seguir?\n1-Sí\n2-No");
				op=sc.nextInt();
				sc.nextLine();
				
			}while(op!=2);
			writer.write("</usuarios>");
			
		    writer.close();
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}

}
