package ejercicio10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	
	public static void main(String[] args) {
		Path entrada = Paths.get("fichero/test.txt");
		Path salida = Paths.get("fichero/testSinVocales.txt");
		// Array de bytes para leer todos los bytes del archivo
		InputStream istream=null;
		OutputStream ostream=null;
		int c;
		try {
			istream = Files.newInputStream(entrada);
			ostream = Files.newOutputStream(salida);
			while ((c = istream.read()) != -1) {
				if (Character.toUpperCase(c)!='A' &&
						Character.toUpperCase(c)!='E'&&
						Character.toUpperCase(c)!='I'&&
						Character.toUpperCase(c)!='O'&&
						Character.toUpperCase(c)!='U') {
					ostream.write(c);
				}
			}
			istream.close();
			ostream.close();
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
