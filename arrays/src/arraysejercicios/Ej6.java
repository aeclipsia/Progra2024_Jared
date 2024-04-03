package arraysejercicios;

import java.util.*;

public class Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		Garaje garajes[]=new Garaje[5];
		
		int op, numeroGaraje;
		double plus;
		boolean garajeExist, continuar;
		
		for (int i = 0; i < garajes.length; i++) {
			garajes[i]=crearGaraje(sc);
		}
		
		sc.nextLine();
		
		do {
			continuar=true;
			System.out.println("----------------------------------");
			System.out.println("1-Alquilar");
			System.out.println("2-Mostrar precio");
			System.out.println("3-Mostrar información");
			System.out.println("4-Subir precio");
			System.out.println("5-Mostrar beneficios de la empresa");
			System.out.println("6-Salir");
			System.out.println("----------------------------------");
			op=sc.nextInt();
			
			switch (op) {
			case 1:
				System.out.println("Anota ID del garaje");
				numeroGaraje=sc.nextInt();
				garajeExist=false;
				for (int i = 0; i < garajes.length; i++) {
					int identificador=garajes[i].getID();
					
					if (identificador==numeroGaraje) {
						garajes[i].Alquilar();
						garajeExist=true;
						break;
					}
				}
				if (garajeExist==false) {
					System.err.println("Garaje no existe");
				}
				break;
				
			case 2:
				System.out.println("Anota ID del garaje");
				numeroGaraje=sc.nextInt();
				for (int i = 0; i < garajes.length; i++) {
					int identificador=garajes[i].getID();
					
					if (identificador==numeroGaraje) {
						System.out.println("Precio: "+garajes[i].getPrecio());
						break;
					}
				}
				break;
				
			case 3:
				for (int i = 0; i < garajes.length; i++) {
						garajes[i].info();
				}
				break;
				
			case 4:
				System.out.println("Anota el aumento de precio en porcentaje: ");
				plus=sc.nextDouble();
				
				System.out.println("Anota ID del garaje");
				numeroGaraje=sc.nextInt();
				for (int i = 0; i < garajes.length; i++) {
					int identificador=garajes[i].getID();
					
					if (identificador==numeroGaraje) {
						garajes[i].plusPrecio(plus);
						break;
					}
				}
				break;
				
			case 5:
				System.out.println("Beneficio total de la empresa: "+Garaje.getBeneficios());
				break;
				
			case 6:
				continuar=false;
				System.err.println("Programa terminada");
				break;

			default:
				System.err.println("Opción no válida");
				break;
			}
		} while (continuar==true);
	}

	public static Garaje crearGaraje(Scanner sc) {
		int id, planta;
		double metros;
		boolean plantaVal=false;
		
		System.out.println("ID del garaje: ");
		id=sc.nextInt();
		
		do {
			plantaVal=true;
			System.out.println("Planta (-1/0/1/2): ");
			planta=sc.nextInt();
			if (planta<(-1)||planta>2) {
				System.err.println("Planta no válida");
				plantaVal=false;
			}
		} while (plantaVal==false);
		
		System.out.println("Tamaño en metros cuadrados: ");
		metros=sc.nextDouble();
		
		Garaje garaje = new Garaje(id,planta,metros);
		
		return garaje;
	}

}
