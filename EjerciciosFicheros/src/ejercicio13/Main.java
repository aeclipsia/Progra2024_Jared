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
	static HashMap<String, Integer> alumno=new HashMap<String, Integer>();
	static LinkedHashMap<String, Integer> sortedMap=new LinkedHashMap<>();
	static ArrayList<Integer> nota=new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		Path file = Paths.get("fichero/alumnos.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;

		try {
			reader = Files.newBufferedReader(file, charset);
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split=line.split(",");
				alumno.put(split[0], Integer.parseInt(split[1]));
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
		
		
		for (Map.Entry<String, Integer> entry : alumno.entrySet()) {
            nota.add(entry.getValue());  //meter notas en un arraylist nota
        }
        Collections.sort(nota, new Comparator<Integer>() { //declarar un comparador
            public int compare(Integer nota, Integer nota1) {
                return (nota1).compareTo(nota);
            }
        });
        for (Integer n : nota) { //meter los datos en un LinkedHashMap
            for (Entry<String, Integer> entry : alumno.entrySet()) {
                if (entry.getValue().equals(n)) {
                    sortedMap.put(entry.getKey(), n);
                }
            }
        }
        
        for (String i: sortedMap.keySet()) { //imprimir LinkedHashMap
        	System.out.println(i+","+alumno.get(i));
        }
  
		
	}

}
