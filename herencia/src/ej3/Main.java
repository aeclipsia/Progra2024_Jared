package ej3;

import java.util.*;

public class Main {

	static Scanner sc;
	static int op;
	static int contador=0;
	static Cuenta cuentas[] = new Cuenta[50];
	static String titulares[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc = new Scanner (System.in);
		
		int nCuentas=0;
		
		System.out.println("1-Alta\n2-Cancela\n3-Interés");
		op=sc.nextInt();
		switch (op) {
		case 1:
			cuentas[contador]=altaCuenta();
			contador++;
			nCuentas++;
			break;

		default:
			break;
		}
		
	}
	
	public static Cuenta altaCuenta() {
		
		String nif;
		int num, nTitulares;
		double saldo;
		Cuenta c;
		
		System.out.println("Cuenta normal (1) o cuentón (2)?");
		op=sc.nextInt();
		
		switch (op) {
		case 1:
			num=(int)(Math.random()*100); //num de cuenta
			
			System.out.println("Saldo inicial");
			saldo=sc.nextDouble();
			sc.nextLine();
			
			System.out.println("Cuántos titulares va a tener? Máximo de 3");
			nTitulares=sc.nextInt();
			sc.nextLine();
			
			titulares = new String[nTitulares];
			
			for (int i = 0; i < nTitulares; i++) {
				System.out.println("Anota el NIF del titular "+(i+1));
				nif=sc.next();
				
				titulares[i]=new String(nif);
			}
			
			c = new Cuenta(num,saldo, titulares);
			
			break;
			
		case 2:
			boolean saldoVal=false;
			
			num=(int)(Math.random()*100); //num de cuenta
			
			do {
				saldoVal=true;
				System.out.println("Saldo inicial (debe ser al menos 600 euros al ser un cuentón)");
				saldo=sc.nextDouble();
				
				if (saldo<600) {
					System.out.println("Saldo mínimo 600");
				}
			} while (saldoVal==false);
			
			System.out.println("Cuántos titulares va a tener? Máximo de 3");
			nTitulares=sc.nextInt();
			sc.nextLine();
			
			titulares = new String[nTitulares];
			
			for (int i = 0; i < nTitulares; i++) {
				System.out.println("Anota el NIF del titular "+(i+1));
				nif=sc.next();
				
				titulares[i]=new String(nif);
			}
			
			c = new Cuenton(num,saldo, titulares);
			
			return c;
		}
		
		return c=null;
	}

}
