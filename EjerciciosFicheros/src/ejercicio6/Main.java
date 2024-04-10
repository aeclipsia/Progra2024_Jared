package ejercicio6;

import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Anota un directorio: ");
		String dir=sc.nextLine();
		
		Path p=Paths.get(dir);
		
		if (!Files.exists(Paths.get(dir))) {
			System.out.println("No existe el directorio");
			System.exit(0);
		}
		do {
			try {
				p=borrarDentro(p);
			} catch (DirectoryNotEmptyException e) {
				return;
			} catch (IOException e) {
				System.out.println("error de permisos");
			}
		} while (Files.exists(Paths.get(dir)));
	}

	private static Path borrarDentro(Path p) throws IOException, DirectoryNotEmptyException {
		DirectoryStream<Path> stream=Files.newDirectoryStream(p);
		for (Path path : stream) {
			if (Files.isDirectory(path)) {
				return path;
			}
		}
		return p;
	}

}
