package ejercicio13;

import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static HashMap<String, Double> alumno=new HashMap<String, Double>();
	static LinkedHashMap<String, Double> sortedMap=new LinkedHashMap<>();
	static ArrayList<Double> nota=new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		
		System.out.println("Anota el fichero");
		Path file = Paths.get(sc.nextLine());
		
		if (!Files.exists(file)) {
			System.err.println("El fichero no existe");
			System.exit(0);
		}
		
		try {
			reader = Files.newBufferedReader(file, charset);
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split=line.split(",");
				alumno.put(split[0], Double.parseDouble(split[1]));
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		
		/*
		for (String i : alumno.keySet()) {
			System.out.println(i+","+alumno.get(i));
		}
		*/
		
		
		for (String i : alumno.keySet()) {
            nota.add(alumno.get(i));  //meter notas en un arraylist nota
        }
        Collections.sort(nota, new Comparator<Double>() { //declarar un comparador
            public int compare(Double nota, Double nota1) {
                return (nota1).compareTo(nota);
            }
        });
        for (Double n : nota) { //meter los datos en un LinkedHashMap
            for (Entry<String, Double> entry : alumno.entrySet()) {
                if (entry.getValue().equals(n)) {
                    sortedMap.put(entry.getKey(), n);
                }
            }
        }
        
        for (String i: sortedMap.keySet()) { //imprimir LinkedHashMap
        	System.out.println(i+", "+alumno.get(i));
        }
  
		
	}

}
