package ejercicio5;

import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Anota un directorio: ");
		String dir=sc.nextLine();
		
		if (!Files.exists(Paths.get(dir))) {
			System.out.println("No existe el directorio");
			System.exit(0);
		}
		else {
			try {
				Files.delete(Paths.get(dir));
			} catch (DirectoryNotEmptyException e) {
				System.out.println("El directorio no está vacio. Seguro que quiere borrarlo?\n1-sí\n2-no");
				int op=sc.nextInt();
				
				switch (op) {
				case 1:
					try {
						if (Files.isDirectory(Paths.get(dir))) {
							try {
								DirectoryStream<Path> stream=Files.newDirectoryStream(Paths.get(dir));
								for (Path path : stream) {
									if (Files.isRegularFile(path)) {
										Files.delete(path);
										continue;
									}
								}
							} catch (IOException e3) {
								System.err.println("Error");
							}
						}
						Files.delete(Paths.get(dir));
					} catch (IOException e2) {
						System.out.println("Error de permisos");
					}
					break;

				default:
					break;
				}
			} catch (IOException e) {
				System.out.println("Error de permisos");
			}
		}
		
		
	}

}
