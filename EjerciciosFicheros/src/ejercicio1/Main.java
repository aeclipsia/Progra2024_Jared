package ejercicio1;

import java.nio.file.*;
import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		System.out.println("Anota la ruta y el archivo");
		String ruta=sc.nextLine();
		Path archi=Paths.get(ruta);

		if (!Files.exists(archi)) {
			System.out.println("No existe el archivo");
		}
		
		for (int i = 0; i < archi.getNameCount(); i++) {
			System.out.println(archi.getName(i));
		}
		
	}

}
