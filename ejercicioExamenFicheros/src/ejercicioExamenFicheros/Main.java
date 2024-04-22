package ejercicioExamenFicheros;

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.nio.file.StandardOpenOption.*;

public class Main {

	static BufferedReader reader = null;
	static BufferedWriter writer = null;
	static Charset charset = Charset.forName("UTF-8");
	static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/LL/yy");
	static DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
	static LinkedList<Usuarios> listaUsuarios = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		
		Path dirUser = Paths.get("usuarios");
				
		checkIfExists(dirUser);
		crearArchivosUsuarios();
		crearVector(dirUser);
		Collections.sort(listaUsuarios);
		mostrarVector();
		
	}

	private static void mostrarVector() {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.println(listaUsuarios.get(i).toString());
		}
	}

	private static void crearVector(Path dirUser) {
		try {
			DirectoryStream<Path> stream=Files.newDirectoryStream(dirUser);
			for (Path path : stream) {
				String cod = path.getFileName().toString().replace(".txt","");
				listaUsuarios.add(new Usuarios(cod));
				try {
					reader = Files.newBufferedReader(path);
					String line = null;
					while ((line = reader.readLine()) != null) {
						String split[] = line.split(",");
						for (int i = 0; i < listaUsuarios.size(); i++) {
							if (cod.equals(listaUsuarios.get(i).getCodigo())) {
								listaUsuarios.get(i).addMinutos(Integer.parseInt(split[1]));
							}
						}
					}
				} catch (IOException x) {
					System.err.format("IOException: %s%n", x);
				} finally {
					if (reader != null) {
						reader.close();
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Error");
		}
	}

	private static void crearArchivosUsuarios() throws IOException {
		
		try {
			reader = Files.newBufferedReader(Paths.get("gimnasio.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split=line.split(",");
				String nombreArchivo = split[0];
				writer = Files.newBufferedWriter(Paths.get("usuarios/"+nombreArchivo+".txt"),charset,CREATE,APPEND);
				LocalDate fecha = LocalDate.parse(split[1],formatoFecha);
				LocalTime entrada = LocalTime.parse(split[2],formatoHora);
				LocalTime salida = LocalTime.parse(split[3],formatoHora);
				writer.write(fecha.toString()+","+ChronoUnit.MINUTES.between(entrada, salida));
				writer.newLine();
				writer.close();
				
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	private static void checkIfExists(Path dirUser) {
		if (Files.exists(dirUser)) {
			if (Files.isDirectory(dirUser)) {
				try {
					DirectoryStream<Path> stream=Files.newDirectoryStream(dirUser);
					for (Path path : stream) {
						if (path.getFileName().toString().endsWith(".txt")) {
							Files.delete(path);
						}
					}
				} catch (IOException e) {
					System.err.println("Error");
				}
			}
		}
		else {
			try {
				Files.createDirectory(dirUser);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
