package arraysejercicios;

import java.util.*;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		int carga, pos, op;
		double rebaja, kilos;
		String fruta, proc;
		boolean sufi;
		
		//creacion del array y cargamentos
		do {
			System.out.println("Cuantos cargamentos tienes? ");
			carga=sc.nextInt();
		} while (carga<=0||carga>10);
		Almacen frutas[]=new Almacen[carga];
		int tam=frutas.length;
		
		do {
			sc.nextLine();
			System.out.println("1-Alta\n2-Rebajar\n3-Vender\n4-Beneficio Total\n5-Borrar\n6-Salir");
			op=sc.nextInt();
			switch (op) {
			case 1:
				//dar de alta a un cargamento
				for (int i = 0; i < frutas.length; i++) {
					frutas[i]=crearCargamento(sc);
				}
				break;
				
			case 2:
				//rebajar precio
				System.out.println("Qué fruta quieres rebajar? ");
				fruta=sc.nextLine();
				
				System.out.println("Procedencia de la fruta: ");
				proc=sc.nextLine();
				
				System.out.println("Precio a rebajar: ");
				rebaja=sc.nextDouble();
				
				pos=buscarRebaja(frutas,fruta,proc,rebaja,tam);
				if (pos==-1) {
					System.err.println("No encontrado");
				}
				else {
					frutas[pos].Rebajar(rebaja);
				}
				break;
				
			case 3:
				//vender fruta
				System.out.println("Qué fruta va a vender? ");
				fruta=sc.nextLine();
				
				pos=0;
				
				do {
					sufi=true;
					pos=buscarVender(frutas,fruta,pos,tam);
					if (pos==-1) {
						System.err.println("No encontrado");
					}
					else {
						System.out.println("Cuántos kilos: ");
						kilos=sc.nextDouble();
						
						sufi=frutas[pos].Vender(kilos);
					}
				} while (sufi==false);
				break;
				
			case 4:
				//Mostrar beneficio del almacen
				Almacen.getTotal();
				break;
				
			case 5:
				//borrar cargamentos con 0 kilos
				for (int i = 0; i < tam; i++) {
					pos=buscarKilos(frutas,tam);
					if (pos==-1) {
						System.err.println("No encontrado");
					}
					else {
						for (int j = pos; j < tam-1; j++) {
							frutas[j]=frutas[j+1];
						}
						frutas[tam-1]=null;
						tam--;
					}
				}
				break;
				
			case 6:
				System.out.println("Programa terminada");
				break;	

			default:
				System.out.println("Opción no válido");
				continue;
			}
			
		} while (op!=6);
				
	}
	
	public static Almacen crearCargamento(Scanner sc) {
		String fruta, proc;
		int k,costK,sellK;
		
		System.out.println("Fruta: ");
		fruta=sc.nextLine();
		System.out.println("Procedencia: ");
		proc=sc.nextLine();
		System.out.println("Kilos: ");
		k=sc.nextInt();
		System.out.println("Coste por Kilo: ");
		costK=sc.nextInt();
		System.out.println("Venta por Kilo");
		sellK=sc.nextInt();
		
		Almacen frutas=new Almacen(fruta,proc,k,costK,sellK);
		return frutas;
	}
	
	public static int buscarVender(Almacen frutas[], String fruta, int index, int tam) {
		for (int i = index; i < tam; i++) {
			if (fruta.equalsIgnoreCase(frutas[i].getFruta())) {
				return i;
			}
		}
		return -1;
	}
	
	public static int buscarRebaja(Almacen frutas[], String fruta, String proc, double rebaja, int tam) {
		for (int j = 0; j < tam; j++) {
			if (fruta.equalsIgnoreCase(frutas[j].getFruta()) && proc.equalsIgnoreCase(frutas[j].getProc())) {
				return j;
			}
		}
		return -1;
	}
	
	public static int buscarKilos(Almacen frutas[],int tam) {
		for (int i = 0; i < tam; i++) {
			if (frutas[i].getKilos()==0) {
				return i;
			}
		}
		return -1;
	}

}
