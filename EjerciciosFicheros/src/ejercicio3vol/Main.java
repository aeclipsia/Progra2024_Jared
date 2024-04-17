package ejercicio3vol;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Anota el fichero");
		String d=sc.nextLine();

		Path file = Paths.get(d);
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;

		System.out.println("Anota una cadena");
		String c=sc.nextLine();
		
		boolean encontrado=false;
		
		try {
			reader = Files.newBufferedReader(file, charset);
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.indexOf(c)!=-1) {
					encontrado=true;
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {

			if (reader != null) {
				reader.close();
			}
		}
		
		if (encontrado) {
			System.out.println("La palabra "+c+" está en el fichero.");
		}
		else {
			System.out.println("La palabra "+c+" no está en el fichero.");
		}
	}

}
