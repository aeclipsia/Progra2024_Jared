package ejercicio1vol;

import java.nio.file.*;
import java.util.*;
import java.io.IOException;
import java.io.IOException.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Anota un directorio: ");
		String dir=sc.nextLine();
		
		System.out.println("Anota un segundo directorio: ");
		String dir2=sc.nextLine();
		
		if (!Files.exists(Paths.get(dir))) {
			System.err.println("No existe el directorio "+dir);
			System.exit(0);
		}
		
		if (!Files.exists(Paths.get(dir2))) {
			System.err.println("No existe el directorio "+dir2);
			System.exit(0);
		}
		
		if (Files.isDirectory(Paths.get(dir))&&Files.isDirectory(Paths.get(dir2))) {
			try {
				DirectoryStream<Path> stream=Files.newDirectoryStream(Paths.get(dir));
				for (Path path : stream) {
					DirectoryStream<Path> stream2=Files.newDirectoryStream(Paths.get(dir2));
					for (Path path2 : stream2) {
						if (path.getFileName().equals(path2.getFileName())) {
							System.out.println("Se ha encontrado dos archivos con el mismo nombre: "+path+"\nBorrar?\n1-Sí\n2-No");
							int op=sc.nextInt();
							switch (op) {
							case 1:
								System.out.println("Cuál de los dos?\n1-"+path+"\n2-"+path2);
								op=sc.nextInt();
								
								switch (op) {
								case 1:
									System.out.println("Se borra "+path);
									Files.delete(path);
									break;
									
								case 2:
									System.out.println("Se borra "+path2);
									Files.delete(path2);
									break;

								default:
									break;
								}
								
								break;
								
							case 2:
								System.out.println("No se borra nada");
								break;

							default:
								break;
							}
						}
					}
					stream2.close();
				}
				stream.close();
			} catch (IOException e) {
				System.err.println("Error");
			}
		}
		else {
			System.err.println("Uno de los intoducidos no es un directorio");
			System.exit(0);
		}
		
		System.err.println("Programa terminada");
	}

}
