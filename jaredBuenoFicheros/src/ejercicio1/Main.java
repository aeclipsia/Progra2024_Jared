package ejercicio1;

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
	static String[] autoContent;
	static String[] propContent;
	static LinkedList<Automovil> informe=new LinkedList<Automovil>();
	static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
	static boolean dniMatch;
	
	public static void main(String[] args) throws IOException {
		
		Path auto=Paths.get("auto.txt");
		Path propietario=Paths.get("propietario.txt");
		Charset charset=Charset.forName("UTF-8");
		BufferedReader readerAuto=null;
		BufferedReader readerPropietario=null;
		BufferedWriter log=null;
		
		String lineAuto=null;
		try {
			readerAuto=Files.newBufferedReader(auto, charset);
			
			String lineProp=null;
			
			while ((lineAuto=readerAuto.readLine())!=null) {
				dniMatch=false;
				
				autoContent=lineAuto.split(",");
				
				String matricula=autoContent[0];
				Double precio=Double.parseDouble(autoContent[2]);
				String dni=autoContent[3];
				try {
					LocalDate fecha_compra=LocalDate.parse(autoContent[1],formatoFecha);
					
					readerPropietario=Files.newBufferedReader(propietario, charset);
					
					while ((lineProp=readerPropietario.readLine())!=null) {
						propContent=lineProp.split(",");
						if (dni.equals(propContent[0])) {
							dniMatch=true;
							
							String nombre=propContent[1];
							String apellido=propContent[2];
							
							informe.add(new Automovil(matricula,fecha_compra,precio,dni,nombre,apellido));
						}
					}
				} catch (DateTimeParseException e) {
					log = Files.newBufferedWriter(Paths.get("log.txt"), CREATE, APPEND);
					log.write(matricula+": Fecha incorrecta");
					log.newLine();
					log.close();
					continue;
				} finally {
					if (readerPropietario != null) {
						readerPropietario.close();
					}
				}
				
				if (!dniMatch) {
					log = Files.newBufferedWriter(Paths.get("log.txt"), CREATE, APPEND);
					log.write(matricula+": No aparece en los propietarios");
					log.newLine();
					log.close();
					continue;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (readerAuto != null) {
				readerAuto.close();
				readerPropietario.close();
			}
		}
		
		Collections.sort(informe);
		
		for (int i = 0; i < informe.size(); i++) {
			System.out.println(informe.get(i));
		}
	}

}
