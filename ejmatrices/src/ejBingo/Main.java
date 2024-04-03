package ejBingo;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int numJ,bola, cont=0;
		int pool[] = new int[80];
		boolean linea=false,bingo=false,bolaVal;
		String lineanom="0", bingonom="0";
		
		do {
			System.out.println("Cuántos jugadores: ");
			numJ=sc.nextInt();
		} while (numJ<=0||numJ>10);
		
		Jugador jugadores[]=new Jugador[numJ];
		
		for (int i = 0; i < numJ; i++) {
			jugadores[i]=crearJugador(sc,i);
		}
		
		mostrarCarton(jugadores);


		//sacar bolas
		Random r=new Random();
		
		do {
			
			do {
				bola=r.nextInt(80)+1;
				
				if (pool[bola-1]!=0) {
					bolaVal=false;
				}
				else {
					pool[bola-1]=1;
					System.out.println("Bola: "+bola);
					bolaVal=true;
				}
			} while (bolaVal==false);
			
			
			for (int i = 0; i < jugadores.length; i++) {
				jugadores[i].tachar(bola);
			}
			
			mostrarCarton(jugadores);
			
			for (int i = 0; i < numJ; i++) {
				linea=jugadores[i].linea();
				bingo=jugadores[i].bingo();
				if (linea==true && cont==0) {
					lineanom=jugadores[i].getNombre();
					cont++;
				}
				if (bingo==true) {
					bingonom=jugadores[i].getNombre();
					break;
				}
			}
		} while (bingo==false);
		
		System.out.println("Jugador "+lineanom+" ha conseguido la primera linea");
		System.out.println("Jugador "+bingonom+" ha conseguido un bingo");
	}

	public static void mostrarCarton(Jugador[] jugadores) {
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i].showCarton();
		}
	}
	
	public static Jugador crearJugador(Scanner sc, int i) {
		String nombre;
		
		System.out.println("Anota nombre del jugador "+(i+1)+":");
		nombre=sc.next();
		
		Jugador jugadores = new Jugador(nombre);
		return jugadores;
	}

}
