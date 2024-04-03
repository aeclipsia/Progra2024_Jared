package arraysejercicios;

import java.util.*;

public class Ej8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		Futbol equipos[]=new Futbol[3];
		
		for (int i = 0; i < equipos.length; i++) {
			equipos[i]=crearEquipos(sc);
		}
		
		boolean continuar=true, eqVal;
		String eq1, eq2, nombre;
		int g1, g2, pos1, pos2, op;
		
		//partidos
		do {			
			System.out.println("1-Anotar partido\n2-Ordenar equipos\n3-Mostrar información\n4-Salir");
			op=sc.nextInt();
			sc.nextLine();
			
			switch (op) {
			case 1:
				do {
					eqVal=true;
					System.out.println("Equipo 1: ");
					eq1=sc.nextLine();
					
					pos1=validarEquipo(equipos, eq1);
					
					eqVal = validarPos(equipos, eqVal, pos1);
					
				} while (eqVal==false);
				
				
				do {
					eqVal=true;
					System.out.println("Equipo 2: ");
					eq2=sc.nextLine();
					
					pos2=validarEquipo(equipos, eq2);
					
					eqVal = validarPos(equipos, eqVal, pos2);
					
				} while (eqVal==false);
				
				System.out.println("Nº de goles del equipo 1: ");
				g1=sc.nextInt();
				
				System.out.println("Nº de goles del equipo 2: ");
				g2=sc.nextInt();
				
				Futbol.Partido(equipos[pos1], equipos[pos2], g1, g2);
				break;
				
			case 2:
				ordenarEquipo(equipos,equipos.length);
				break;
				
			case 3:
				for (int i = 0; i < equipos.length; i++) {
					System.out.println(equipos[i].toString());
				}
				break;

			case 4:
				continuar=false;
				break;
				
			default:
				break;
			}
			
		} while (continuar==true);
		
	}

	public static boolean validarPos(Futbol[] equipos, boolean eqVal, int pos1) {
		String eq1;
		if (pos1==-1) {
			eqVal=false;
		}
		else {
			eqVal=true;
		}
		return eqVal;
	}

	public static int validarEquipo(Futbol[] equipos, String eq) {
		String nombre;
		for (int i = 0; i < equipos.length; i++) {
			nombre=equipos[i].getEquipo();
			if (eq.equalsIgnoreCase(nombre)) {
				return i;
			}
		}
		return -1;
	}
	
	public static Futbol crearEquipos(Scanner sc) {
		System.out.println("Anota el nombre del equipo: ");
		String nombre=sc.nextLine();
		
		Futbol equipo = new Futbol (nombre);
		return equipo;
	}
	
	public static void ordenarEquipo(Futbol v[],int l) {
		int j, k;
		Futbol aux;
		for (j = 1; j < l; j++) {
			for (k = 0; k < l - j ; k++) 
				if (v[k].getPuntos() < v[k+1].getPuntos()) {
					aux=v[k];
					v[k]=v[k+1];
					v[k+1]=aux;
			}
		}
	}
	
	public static void burbuja(Futbol v[], int TAM) {
		int j, k;
		Futbol aux;
		for (j = 1; j < TAM; j++) // Doy tantas vueltas como elementos tenga mi array menos 1
			for (k = 0; k < TAM - j; k++) // En cada vuelta llevo el elemento mayor al final del array.
				if (v[k].getPuntos() < v[k + 1].getPuntos()) // Si un elemento es mayor que el siguiente, los intercambio
				{
					aux = v[k];
					v[k] = v[k + 1];
					v[k + 1] = aux;
				}
	}

}
