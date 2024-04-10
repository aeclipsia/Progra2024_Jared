package ejercicio7;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Path file = Paths.get("fichero/test.txt");
		Charset charset=Charset.forName("UTF-8");
		
		InputStream istream=null;
		
		int c, contador=0;
		try {
			istream = Files.newInputStream(file);

			while ((c = istream.read()) != -1) {
				contador++;
			}
			istream.close();

		} catch (IOException io) {
			System.err.println(io);
		}
		
		System.out.println("El archivo \""+file.getFileName()+"\" contiene "+contador+" carácteres.");
		
		
	}

}
