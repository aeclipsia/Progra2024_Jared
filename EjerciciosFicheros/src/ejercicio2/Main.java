package ejercicio2;

import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;
import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Anota la ruta: ");
		String ruta=sc.nextLine();
		
		System.out.println("Archivo que copiar: ");
		String ar1=sc.nextLine();
		
		System.out.println("Archivo destino: ");
		String ar2=sc.nextLine();
		
		Path p1=Paths.get(ruta+"/"+ar1);
		Path p2=Paths.get(ruta+"/"+ar2);
		
		try {
			Files.copy(p1, p2);
		} catch (NoSuchFileException e) {
			System.err.println("No existe el archivo");
		} catch (FileAlreadyExistsException e) {
			System.out.println("Ya existe el archivo, quiere reemplazarlo?\n1-Sí\n2-No");
			int op=sc.nextInt();
			
			switch (op) {
			case 1:
				try {
					Files.copy(p1, p2, REPLACE_EXISTING);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;

			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
