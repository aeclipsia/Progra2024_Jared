package ejercicio14;
import static java.nio.file.StandardOpenOption.APPEND;

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
		Path fileIn = Paths.get("fichero/ej14.txt");
		Path fileOut = Paths.get("fichero/salida14.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(fileIn, charset);
			writer = Files.newBufferedWriter(fileOut, charset);
			String line = null;
			
			System.out.println("Anota palabra");
			String palabra=sc.nextLine();
			
			while ((line = reader.readLine()) != null) {
				String[] palabras=line.split(" ");
				for (int i = 0; i < palabras.length; i++) {
					if (!palabra.equals(palabras[i])) {
						writer.write(palabras[i]+" ");
					}
				}
				writer.newLine();
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
