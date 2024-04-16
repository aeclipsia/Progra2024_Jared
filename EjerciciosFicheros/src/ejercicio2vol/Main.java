package ejercicio2vol;
import static java.nio.file.StandardOpenOption.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		System.out.println("Anota el directorio: ");
		String dir=sc.nextLine();
		
		if (Files.isDirectory(Paths.get(dir))) {
			System.out.println("Se ha encontrado "+dir);
			try {
				DirectoryStream<Path> stream=Files.newDirectoryStream(Paths.get(dir));
				for (Path path : stream) {
					if (Files.isRegularFile(path)) {
						Path fileIn = path;
						Path fileOut = Paths.get(path.getFileName().toString().toUpperCase());
						Charset charset = Charset.forName("UTF-8");
						BufferedReader reader = null;
						BufferedWriter writer = null;
						try {
							reader = Files.newBufferedReader(fileIn, charset);
							writer = Files.newBufferedWriter(fileOut, charset);
							String line = null;
							while ((line = reader.readLine()) != null) {
								writer.write(line.toUpperCase());
								writer.newLine();
							}
						} catch (IOException x) {
							System.err.format("IOException: %s%n", x);
						} finally {
							if (reader != null) {
								reader.close();
								writer.close();
							}
						}
					}
				}
			} catch (IOException e) {
				System.err.println("Error");
			}
		}
	}

}
