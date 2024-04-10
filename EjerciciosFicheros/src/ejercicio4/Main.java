package ejercicio4;

import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Anota un directorio: ");
		String dir=sc.nextLine();
		
		if (!Files.exists(Paths.get(dir))) {
			System.out.println("No existe el directorio");
			System.exit(0);
		}
		
		System.out.println("Anota un caracter: ");
		char car=sc.next().charAt(0);
		
		if (Files.isDirectory(Paths.get(dir))) {
			System.out.println("Se ha encontrado "+dir);
			try {
				DirectoryStream<Path> stream=Files.newDirectoryStream(Paths.get(dir));
				for (Path path : stream) {
					if (Files.isRegularFile(path) && path.getFileName().toString().charAt(0)==car) {
						System.out.println("Se borra "+path.getFileName());
						Files.delete(path);
						continue;
					}
				}
			} catch (IOException e) {
				System.err.println("Error");
			}
		}

	}

}
