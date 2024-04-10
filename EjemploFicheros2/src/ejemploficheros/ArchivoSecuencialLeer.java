package ejemploficheros;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @descrition Clase que arbre un archivo en forma secuencial, con stream y
 *             buffer para leer las l�neas del archivo
 * 
 */
public class ArchivoSecuencialLeer {

	public static void main(String[] args) throws IOException {
		Path file = Paths.get("entrada.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;

		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(file, charset);
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {

			if (reader != null) {
				reader.close();
			}
		}
	}

}
