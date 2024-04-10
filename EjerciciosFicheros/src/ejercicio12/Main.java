package ejercicio12;

import static java.nio.file.StandardOpenOption.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		Path fileIn = Paths.get("fichero/entrada2.txt");
		Path fileOut = Paths.get("fichero/salida.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		BufferedWriter writer2 = null;
		
		boolean cambio=true;
		String cadena;
		
		System.out.println("Anota una cadena");
		cadena=sc.nextLine();
		
		try {
			// Creamos un BuffereredReader de java.io
			reader = Files.newBufferedReader(fileIn, charset);
			writer = Files.newBufferedWriter(fileOut, charset);
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.indexOf(cadena)!=-1) {
					writer.write(line);
					writer.newLine();
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {
			if (reader != null) {
				reader.close();
				writer.close();

			}
		}
	}

}
