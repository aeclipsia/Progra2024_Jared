package ejercicio8;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		Path file = Paths.get("fichero/test.txt");
		Charset charset=Charset.forName("UTF-8");
		
		InputStream istream=null;
		
		int c, contador=0;
		char caracter;
		
		System.out.println("Anota un carácter: ");
		caracter=sc.next().charAt(0);
		
		try {
			istream = Files.newInputStream(file);

			while ((c = istream.read()) != -1) {
				if (c==caracter) {
					contador++;
				}
			}
			istream.close();

		} catch (IOException io) {
			System.err.println(io);
		}
		
		System.out.println("El archivo \""+file.getFileName()+"\" contiene "+contador+" ocurrencias de caracter "+caracter+".");
		
		
	}

}
