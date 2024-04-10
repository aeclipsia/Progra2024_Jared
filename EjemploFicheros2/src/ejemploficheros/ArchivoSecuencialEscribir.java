package ejemploficheros;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.OpenOption;

/* Imprescindible poner este import si voy a poner opciones de apertura */
import static java.nio.file.StandardOpenOption.*;

/**
 *  @descrition Lee cadenas de teclado y las escribe en un fichero usando Buffer
 */
public class ArchivoSecuencialEscribir {

	public static void main(String[] args) {
		String linea;
		Scanner sc=new Scanner(System.in);
		Path file= Paths.get("salida.txt");
		Charset charset = Charset.forName("UTF-8");
		
		//Creamos un BufferedWriter de java.io de forma eficiente utilizando Files de java.nio
		try {
			// Crea el fichero si no existe, si existe borra el contenido
			//BufferedWriter writer = Files.newBufferedWriter(file, charset);
			// Añade información al final
			BufferedWriter writer = Files.newBufferedWriter(file, charset,APPEND);
		
			do{
				System.out.println("Anota línea (fin para salir):");
				linea=sc.nextLine();
				if (!linea.equalsIgnoreCase("FIN")){
					writer.write(linea);
					//Escribimos nueva línea para separarlas
					writer.newLine();
				}
			}while(!linea.equalsIgnoreCase("FIN"));
		    writer.close();
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}

}
