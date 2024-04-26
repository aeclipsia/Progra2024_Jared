package ejercicio2;

import java.util.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

/*
 * @author: Jared James Lloyd Bueno
 */

public class Main {

	static Scanner sc=new Scanner(System.in);
	static ArrayList<String> archivosList=new ArrayList<String>();
	
	public static void main(String[] args) {
		System.out.println("Anota el primer directorio");
		String dir1=sc.nextLine();
		
		System.out.println("Anota el segundo directorio");
		String dir2=sc.nextLine();
		
		Path d1=Paths.get(dir1);
		Path d2=Paths.get(dir2);
		
		if (Files.exists(d1) && Files.isDirectory(d1)) {
			try {
				DirectoryStream<Path> directorio1=Files.newDirectoryStream(d1);
				for (Path archivos : directorio1) {
					if (Files.isRegularFile(archivos)) {
						archivosList.add(archivos.getFileName().toString());
					}
				}
			} catch (IOException e) {
				System.err.println("Error");
			}
		}
		else {
			System.err.println("\""+d1.getFileName().toString()+"\" no es un directorio.");
			System.exit(0);
		}
		
		if (Files.exists(d2) && Files.isDirectory(d2)) {
			try {
				DirectoryStream<Path> directorio2=Files.newDirectoryStream(d2);
				for (Path archivos2 : directorio2) {
					if (Files.isRegularFile(archivos2)) {
						if (!archivosList.contains(archivos2.getFileName().toString())) {
							archivosList.add(archivos2.getFileName().toString());
						}
					}
				}
			} catch (IOException e) {
				System.err.println("Error");
			}
		}
		else {
			System.err.println("\""+d2.getFileName().toString()+"\" no es un directorio.");
			System.exit(0);
		}
		
		Collections.sort(archivosList);
		
		for (int i = 0; i < archivosList.size(); i++) {
			if (i!=archivosList.size()-1) {
				System.out.print(archivosList.get(i)+",");
			}
			else {
				System.out.print(archivosList.get(i));
			}
		}
	}

}
