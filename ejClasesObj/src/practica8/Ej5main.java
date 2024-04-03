package practica8;

import java.util.*;

public class Ej5main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		boolean rebaja=false, cont=true;
		
		Almacen fruta1=new Almacen("Platano", "Madrid", 100, 2, 3);
		Almacen fruta2=new Almacen("Manzana", "Barcelona", 125, 3, 5);
		Almacen fruta3=new Almacen("Sandia", "Madrid", 50, 5, 9);
		
		
		System.out.println(fruta1.toString());
		System.out.println(fruta2.toString());
		System.out.println(fruta3.toString());
		
		//valida si fruta 1 y 2 tienen la misma procedencia
		if (fruta1.CheckProc(fruta2)==true) {
			System.out.println("Tienen la misma procedencia.");
		}
		else {
			System.out.println("No tienen la misma procedencia.");
		}
		
		//rebaja el precio del tercero		
		do {
			System.out.println("Cuánto quieres rebajar el precio de venta del tercero");
			double newprice=sc.nextDouble();
			rebaja=fruta3.Rebajar(newprice);
		} while (rebaja==false);
		
		System.out.println(fruta3.toString());
		
		//venta de frutas
		do {
			System.out.println("Qué fruta vas a vender? 1/2/3");
			int fruta=sc.nextInt();
			
			System.out.println("Y de cuántas kilos?");
			int kilo=sc.nextInt();
			
			switch (fruta) {
			case 1:
				fruta1.Vender(kilo);
				break;
				
			case 2:
				fruta2.Vender(kilo);
				break;
				
			case 3:
				fruta3.Vender(kilo);
				break;

			default:
				System.out.println("Error, fruta no existe");
				continue;
			}
			System.out.println("Quieres seguir? S/N");
			char con=sc.next().charAt(0);
			con=Character.toUpperCase(con);
			
			if (con=='S') {
				cont=true;
			}
			else {
				cont=false;
			}
		} while (cont==true);
		
		double benef1=fruta1.getBeneficio();
		double benef2=fruta2.getBeneficio();
		double benef3=fruta3.getBeneficio();
		
		double benefT=benef1+benef2+benef3;
		
		System.out.println("Beneficio total: "+benefT);
	}

}
