package practica8;

import java.util.Iterator;

public class Etiqueta {

	private int alto, ancho;
	private char caracter;

	//es la parte que recoge los datos
	public Etiqueta(int alto, int ancho, char caracter) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.caracter = caracter;
	}
	
	//es la parte que dibuja según los datos
	public void dibujar(){
		for (int i = 1; i <= alto; i++) {
			if (i==1 || i==alto) {
				for (int j = 1; j <= ancho; j++) {
					System.out.print(caracter);
				}
			}
			else {
				for (int j = 1; j <= ancho; j++) {
					if (j==1||j==ancho) {
						System.out.print(caracter);
					}
					else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}
