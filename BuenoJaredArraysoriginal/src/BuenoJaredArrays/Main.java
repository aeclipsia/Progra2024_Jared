package BuenoJaredArrays;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		//Creación de arrays
		Contratos objeto[]=new Contratos[20];
		
		Contratos contratoTarifa[]=new Contratos[20];
		
		char op;
		String telefono, t,tarifas[]= {"joven","normal","especial"};
		int posTarifa=0, nT=0, posTel=0, menuOp;
		boolean seguir, opVal;
		
		
		//menu
		
		do {
			seguir=true;
			
			System.out.println("1-Alta\n2-Llamada\n3-Salir");
			menuOp=sc.nextInt();
			
			switch (menuOp) {
			case 1:
				//Dar de alta a contratos
				for (int i = 0; i < objeto.length; i++) {
					telefono=crearTelefono(sc);
					
					do {
						System.out.println("Tarifa: \nJoven\nNormal\nEspecial");
						t=sc.next();
						
						posTarifa=buscarTarifa(t,tarifas);
						
						if (posTarifa==-1) {
							System.err.println("Tarifa no válida");
							continue;
						}
						else {
							break;
						}
					} while (posTarifa==-1);
					
					objeto[i]=crearObjeto(telefono,t);
					
					nT=i;
					
					do {
						System.out.println("Quiere seguir? S/N");
						op=sc.next().charAt(0);
						op=Character.toUpperCase(op);
						
						switch (op) {
						case 'S':
							opVal=true;
							break;
							
						case 'N':
							opVal=true;
							i=objeto.length;
							break;

						default:
							System.err.println("Opción no válida");
							opVal=false;
							break;
						}
					} while (opVal==false);
				}
				break;
				
			case 2:
				//Llamadas
				
				System.out.println("Anota telefono");
				telefono=sc.next();
				
				posTel=buscarTelefono(telefono,objeto,nT);
				
				if (posTel==-1) {
					System.err.println("Telefono no encontrado");
				}
				else if (posTel==0) {
					System.out.println("Duración de la llamada en minutos: ");
					int mins=sc.nextInt();
					
					objeto[posTel].Llamada(mins, posTarifa);
				}
				else {
					System.out.println("Duración de la llamada en minutos: ");
					int mins=sc.nextInt();
					
					objeto[posTel].Llamada(mins, posTarifa);
				}
				break;
				
			case 3:
				seguir=false;
				break;

			default:
				System.err.println("Opción no válida");
				continue;
			}
		} while (seguir==true);
				
		
		//Colocar en array tarifas especificas
		System.out.println("Anota el tipo de tarifa");
		t=sc.next();
		
		posTarifa=buscarTarifa(t,tarifas);
		
		
		for (int i = 0; i < nT; i++) {
			contratoTarifa[i]=crearArray2(objeto, tarifas, posTarifa, nT);
		}
		
		for (int i = 0; i < contratoTarifa.length; i++) {
			System.out.println();
		}
		
		//Ordenar el array
		ordenar(objeto, nT);

		for (int i = 0; i <= nT; i++) {
			System.out.println(objeto[i].toString());
		}
		
		//Borrar

			for (int j = 0; j < nT - 1; j++)
				objeto[j] = objeto[j + 1];

			objeto[nT - 1] = null;
			nT--;
			for (int i = 0; i <= nT-3; i++)
				System.out.println(objeto[i]);
		
	}
	
	public static void ordenar(Contratos t[], int nT) {
		int j, k;
		Contratos aux;
		for (j = 1; j < nT; j++) {
			for (k = 0; k < nT - j; k++) {
				if (t[k].getLlamadas() > t[k + 1].getLlamadas()) {
					aux = t[k];
					t[k] = t[k + 1];
					t[k + 1] = aux;
				}
			}
		}
	}

	public static Contratos crearArray2(Contratos[] objeto, String[] tarifas, int posTarifa, int nT) {
		for (int i = 0; i < nT; i++) {
			if (objeto[i].getTarifa().equalsIgnoreCase(tarifas[posTarifa])) {
				Contratos contratoTarifa=new Contratos(objeto[i].getTelefono(),objeto[i].getTarifa());
				return contratoTarifa;
			}
		}
		return null;
	}
	
	public static Contratos crearObjeto(String telefono, String tarifa) {
		Contratos objeto=new Contratos(telefono, tarifa);
		return objeto;
	}
	
	
	public static String crearTelefono(Scanner sc) {
		String telefono="0";
		boolean telVal=false;
		
		do {
			telVal=true;
			
			System.out.println("Anota el telefono");
			telefono=sc.next();
			
			if (telefono.length()!=9) {
				System.err.println("Telefono no válido");
				telVal=false;
			}
			else {
				for (int i = 0; i < telefono.length(); i++) {
					if (!Character.isDigit(telefono.charAt(i))) {
						telVal=false;
					}
				}
			}
		} while (telVal==false);
		
		System.out.println("Telefono válido");
		
		return telefono;
		
	}
	
	public static int buscarTarifa(String t, String tarifas[]) {
		for (int i = 0; i < tarifas.length; i++) {
			if (t.equalsIgnoreCase(tarifas[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public static int buscarTelefono(String telefono, Contratos objeto[], int nT) {
		for (int i = 0; i <= nT; i++) {
			if (telefono.equalsIgnoreCase(objeto[i].getTelefono())) {
				return i;
			}
		}
		if (nT==0) {
			if (telefono.equalsIgnoreCase(objeto[0].getTelefono())) {
				return 0;
			}
		}
		else {
			
		}
		return -1;
	}

}
