package controlej;

import java.util.*;

public class Control_2021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		String type,full;
		double litros,precio,disc,importe=0,pay;
		
		
		//datos
		System.out.println("Qué tipo de combustible?");
		type=sc.nextLine();
		
		switch (type) {
		case "gasolina":
		case "Gasolina":
		case "GASOLINA":
					System.out.println("Quieres llenar el depósito o no?");
					full=sc.nextLine();
					switch (full) {
					case "si":
					case "Si":
					case "sí":
					case "Sí":
					case "SÍ":
					case "SI":	
							System.out.println("Cuántos litros?");
							litros=sc.nextDouble();
							
							if (litros>10 && litros<=20) {
								disc=0.05;
								precio=(litros*1.52)-((litros*1.52)*disc);
								System.out.printf("Importe a pagar: %.2f euros\n",precio);
							}
							else if (litros>20) {
								disc=0.15;
								precio=(litros*1.52)-((litros*1.52)*disc);
								System.out.printf("Importe a pagar: %.2f euros\n",precio);
							}
						break;		
					
					case "no":
					case "No":
					case "NO":	
							do {
								System.out.println("Importe a repostar");
								importe=sc.nextDouble();
							} while (importe<10);
							
							double imp=Math.round(importe/5);
							System.out.printf("Importe a pagar: %.2f euros\n",imp);
						break;

					default:
						System.out.println("Error");
						System.exit(0);
						break;
					}
			break;

		case "diesel":
		case "Diesel":
		case "DIESEL":
			System.out.println("Quieres llenar el depósito o no?");
			full=sc.nextLine();
			switch (full) {
			case "si":
			case "Si":
			case "sí":
			case "Sí":
			case "SÍ":
			case "SI":	
					System.out.println("Cuántos litros?");
					litros=sc.nextDouble();
					
					if (litros>10 && litros<=20) {
						disc=0.1;
						precio=(litros*1.38)-((litros*1.38)*disc);
						System.out.printf("Importe a pagar: %.2f euros\n",precio);
					}
					else if (litros>20) {
						disc=0.15;
						precio=(litros*1.38)-((litros*1.38)*disc);
						System.out.printf("Importe a pagar: %.2f euros\n",precio);
					}
				break;		
			
			case "no":
			case "No":
			case "NO":	
					do {
						System.out.println("Importe a repostar");
						importe=sc.nextDouble();
					} while (importe<10);
					
					double imp=Math.round(importe/5);
					System.out.printf("Importe a pagar: %.2f euros\n",imp);
				break;

			default:
				System.out.println("Error");
				System.exit(0);
				break;
			}
			break;	
			
		case "biodiesel":
		case "Biodiesel":
		case "BIODIESEL":
			System.out.println("Quieres llenar el depósito o no?");
			full=sc.nextLine();
			switch (full) {
			case "si":
			case "Si":
			case "sí":
			case "Sí":
			case "SÍ":
			case "SI":	
					System.out.println("Cuántos litros?");
					litros=sc.nextDouble();
					
					if (litros>10 && litros<=20) {
						disc=0.1;
						precio=(litros*1.71)-((litros*1.71)*disc);
						System.out.printf("Importe a pagar: %.2f euros\n",precio);
					}
					else if (litros>20) {
						disc=0.15;
						precio=(litros*1.71)-((litros*1.71)*disc);
						System.out.printf("Importe a pagar: %.2f euros\n",precio);
					}
				break;		
			
			case "no":
			case "No":
			case "NO":	
					do {
						System.out.println("Importe a repostar");
						importe=sc.nextDouble();
					} while (importe<10);
					
					double imp=Math.round(importe/5);
					System.out.printf("Importe a pagar: %.2f euros\n",imp);
				break;

			default:
				System.out.println("Error");
				System.exit(0);
				break;
			}
			break;	
					
			
		default:
			System.out.println("Error!");
			System.exit(0);
			break;
		}
		
		System.out.println("Sólo se paga en efectivo, introduce el importe: ");
		pay=sc.nextDouble();
		
		double monedas;
		
		int div20=(int)pay/20;
		int div10=(int)(pay%20)/10;
		int div5=(int)(((pay%20)%10)/5);
		monedas=(((pay%20)%10)%5);
		
		System.out.printf("%d billetes de 20, %d billetes de 10, %d billetes de 5 y %.2f euros", div20,div10,div5,monedas);
	}

}
