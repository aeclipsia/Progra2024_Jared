package controlbucles2022;

import java.util.*;

public class Ej {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
Scanner sc = new Scanner(System.in);
		
		String des;
		char destino='a';
		double kilo=1,espM=0,espB=0,precio, precioB,total=0,totalB=0,impmed, max=0;
		int count=0; 
		
		
		do {
			
			if (espM>=100 && espB>=100) {
				System.out.println("Los dos contenedores están llenos");
				break;
			}
			
			System.out.println("Anota el destino");
			System.out.println("M = Madrid");
			System.out.println("B = Barcelona");
			System.out.println("S = Salir");
			destino=sc.next().charAt(0);
			
			
			switch (destino) {
			case 'M':
			case 'm':
				do {
					if (espM>=100) {
						System.out.println("El contenedor a Madrid ya está lleno, sólo puedes poner más paquetes en Barcelona");
						continue;
					}
					
					des="Madrid";
					System.out.println("Anota el peso de su paquete");
					kilo=sc.nextDouble();
					
					if (kilo<0 || kilo>60) {
						System.out.println("Error!");
						continue;
					}
					
					if (espM+kilo>100) {
						System.out.println("Error!");
						System.out.println("Contenedor "+des+" lleno");
						continue;
					}
					else {
						espM=espM+kilo;
						System.out.println("Espacio ocupado de Madrid: "+espM);
					}
					
					if (kilo>0 && kilo<=10) {
						precio=kilo*0.5;
						
						System.out.printf("Gastos de envío: %.2f\n",precio);
						
						total=total+precio;
						count=count+1;
					}
					else if (kilo>10 && kilo<=60) {
						precio=((kilo-10)*0.7)+(10*0.5);
						
						System.out.printf("Gastos de envío: %.2f\n",precio);
						
						total=total+precio;
						count=count+1;
					}
					
				} while (kilo<0 || kilo>60);				
				break;
				
			case 'B':
			case 'b':
				do {
					if (espB>=100) {
						System.out.println("El contenedor a Barcelona ya está lleno, sólo puedes poner más paquetes en Madrid");
						continue;
					}
					
					des="Barcelona";
					System.out.println("Anota el peso de su paquete");
					kilo=sc.nextDouble();
					
					if (kilo<0 || kilo>60) {
						System.out.println("Error!");
						continue;
					}
					
					if (espB+kilo>65) {
						System.out.println("Error!");
						System.out.println("Contenedor "+des+" lleno");
						continue;
					}
					else {
						espB=espB+kilo;
						System.out.println("Espacio ocupado de Barcelona: "+espB);
					}
					
					if (kilo>0 && kilo<=10) {
						precioB=(kilo*0.5)*1.2;
						
						System.out.printf("Gastos de envío: %.2f\n",precioB);
						
						totalB=totalB+precioB;
						count=count+1;
					}
					else if (kilo>10 && kilo<=60) {
						precioB=(((kilo-10)*0.7)+(10*0.5))*1.2;
						
						System.out.printf("Gastos de envío: %.2f\n",precioB);
						
						totalB=totalB+precioB;
						count=count+1;
					}
					
					if (max<=kilo) {
						max=kilo;
					}
					
				} while (kilo<0 || kilo>60);				
				break;
				
			case 'S':
			case 's':
				System.out.println("El programa se termina");
				break;
				
			default:
				System.out.println("ERROR! ANOTA 'M', 'B' o 'S' ");
				break;
			}
			
		} while (destino!='s' || destino!='S');
		
		impmed=total/count; //importe medio de Madrid
		System.out.printf("Importe medio de los paquetes de Madrid: %.2f",impmed);
		
		System.out.println("El peso del paquete más pesado que viaja a Barcelona es de "+max+"kg.");
		
	}

}