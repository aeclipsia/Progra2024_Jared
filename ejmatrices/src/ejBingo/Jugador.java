package ejBingo;

import java.util.*;

public class Jugador {

	Random r=new Random();
	
	private String nombre;
	private Boolean repetir;
	private int columna=5, fila=4;
	private int carton[][]=new int[fila][columna];
	private int valor;
	private int aux;
		
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
		crearCarton();
	}

	public void crearCarton() {
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				do {
					valor=(int)(Math.random()*20)+1+(20*i);				
				} while (esRepetido(valor,i,j)==true);
				carton[i][j]=valor;
			}
			Arrays.sort(carton[i]);
		}
	}
	
	public boolean esRepetido(int n, int fila, int columna) {
		for (int j = 0; j < columna; j++) {
			if (carton[fila][j]==n) {
				return true;
			}
		}
		return false;
	}
	
	
	public void tachar(int bola) {
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				if (bola==carton[i][j]) {
					carton[i][j]=0;
				}
			}
		}
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public boolean linea() {
		boolean line;
		
		for (int i = 0; i < fila; i++) {
			if (carton[i][0]==0 &&
				carton[i][1]==0 &&
				carton[i][2]==0 &&
				carton[i][3]==0 &&
				carton[i][4]==0) {
				line=true;
				return line;
			}
		}
		line=false;
		return line;
	}
	
	public boolean bingo() {
		boolean bingo=true;
		
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				if (carton[i][j]!=0) {
					bingo=false;
				}
			}
		}
		
		return bingo;
		
	}


	public void showCarton() {
		
		System.out.println("Carton:");
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				System.out.print("\t"+carton[i][j]);
			}				
			System.out.println();
		}
	}
	
	
	
}
