package ejemploficheros;
import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MayusculasConBuffered {

	public static void main(String[] args) throws IOException {
		Path fileIn = Paths.get("entrada.txt");
		Path fileOut = Paths.get("salida.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(fileIn, charset);
			writer = Files.newBufferedWriter(fileOut, charset,APPEND);
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
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
