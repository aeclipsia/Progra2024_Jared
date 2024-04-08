package ejemplosficheros;
import java.nio.file.*;
import java.io.*;
import java.util.*;
public class EjemplosPath {

	public static void main(String[] args) {
			
		//CREAR UN PATH A PARTIR DE UNA CADENA, usamos la barra /  o \\
		Path ruta1=Paths.get("ficheros/text.txt"); 
		//Path ruta1=Paths.get("c:/prueba/micarpeta");
		infoPath(ruta1);
		Path ruta2=Paths.get("../hola.txt");
		infoPath(ruta2);
				
		
		// C�MO OBTENER UN PATH A PARTIR DE DATOS ANOTADOS DE TECLADO
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una ruta:");
		String ruta=sc.nextLine();
		System.out.println("Introduce el nombre de un archivo:");
		String archivo=sc.nextLine();
		Path ruta3=Paths.get(ruta+"/"+archivo);		
		System.out.println(ruta3.toString());
		infoPath(ruta3);
		
	}
	
	public static void infoPath(Path p){
		//M�TODOS CLASE PATH
		System.out.println("-----------"+p.toString());
		System.out.println("getFileName:"+ p.getFileName());
		System.out.println("getName(0):"+ p.getName(0));
		System.out.println("getNameCount:"+ p.getNameCount());
		System.out.println("subpath(0,2):"+ p.subpath(0,2));
		System.out.println("getParent:"+ p.getParent());
		System.out.println("getRoot:"+ p.getRoot());
		System.out.println("Path absoluto:"+p.toAbsolutePath());
		try{
			System.out.println("realPath:"+p.toRealPath());
		}
		catch( IOException e){
			System.out.println("Error no existe el fichero");
		}
	}

}

