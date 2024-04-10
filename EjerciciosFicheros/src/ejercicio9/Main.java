package ejercicio9;

import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Anota un directorio: ");
		String dir=sc.nextLine();
		Charset charset=Charset.forName("UTF-8");
		BufferedReader reader=null;
		
		if (!Files.exists(Paths.get(dir))) {
			System.out.println("No existe el directorio");
			System.exit(0);
		}
		if (Files.isDirectory(Paths.get(dir))) {
			System.out.println("Se ha encontrado el directorio "+dir+" y contiene:");
			try {
				DirectoryStream<Path> stream=Files.newDirectoryStream(Paths.get(dir));
				for (Path path : stream) {
					if (Files.isRegularFile(path)) {
						try {
							System.out.println("\""+path.getFileName()+"\":");
							// Creamos un BuffereReader de java.io
							reader = Files.newBufferedReader(path, charset);
							String line = null;
							while ((line = reader.readLine()) != null) {
								System.out.println("\t"+line);
							}
						} catch (IOException x) {
							System.err.format("IOException: %s%n", x);
						} finally {

							if (reader != null) {
								reader.close();
							}
						}
					}
				}
			} catch (IOException e) {
				System.err.println("Error");
			}
		}
	}

}
