package ejercicio11;
import static java.nio.file.StandardOpenOption.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException {
		Path fileIn = Paths.get("fichero/entrada.txt");
		Path fileOut = Paths.get("fichero/f1.txt");
		Path fileOut2 = Paths.get("fichero/f2.txt");
		Path fileOut3 = Paths.get("fichero/f3.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		BufferedWriter writer = null;
		BufferedWriter writer2 = null;
		BufferedWriter writer3 = null;
		int count1=0;
		int count2=0;
		
		boolean cambio=true;
		
		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(fileIn, charset);
			writer = Files.newBufferedWriter(fileOut, charset);
			writer2 = Files.newBufferedWriter(fileOut2, charset);
			String line = null;
			while ((line = reader.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					if (cambio==true) {
						writer.write(line.charAt(i));
						cambio=false;
					}
					else {
						writer2.write(line.charAt(i));
						cambio=true;
					}
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {
			if (reader != null) {
				reader.close();
				writer.close();
				writer2.close();
			}
		}
		
		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(fileIn, charset);
			reader1 = Files.newBufferedReader(fileOut, charset);
			reader2 = Files.newBufferedReader(fileOut2, charset);
			writer3 = Files.newBufferedWriter(fileOut3, charset);
			String linebase = reader.readLine();
			String line = null;
			String line2 = null;
			for (int i = 0; i < linebase.length(); i++) {
				if (i%2==0) {
					while ((line=reader1.readLine())!=null) {
						writer3.write(line.charAt(count1));
						count1++;
					}
				}
				else {
					while ((line2=reader2.readLine())!=null) {
						writer3.write(line2.charAt(count2));
						count2++;
					}
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {
			if (reader1 != null && reader2 != null) {
				reader1.close();
				reader2.close();
				writer3.close();
			}
		}
		
	}

}
