package controlej;

import java.util.*;

public class Control_2022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String destino,famnum;
		double precioini,disc,discfam,bill,equipaje,extraequip,payequip;
		int edad;
		System.out.println("Destino: ");
		destino=sc.nextLine();
		
		System.out.println("Es parte de una familia numerosa?");
		famnum=sc.nextLine();
		
		
		//descuento de familia numerosa
		switch (famnum) {
		case "Sí":
		case "Si":
		case "sí":
		case "si":
		case "SI":
		case "SÍ":
			discfam=0.2;
			break;

		default:
			discfam=0;
			break;
		}
		
		
		System.out.println("Cuántos años tiene?");
		edad=sc.nextInt();
		
		
		//descuento de edad
		if (edad<14) 
			disc=0.5;
		else
			if (edad>=14 && edad<18)
				disc=0.2;
		else
			if (edad>=65)
				disc=0.3;
		else
				disc=0;
		
			//comparacion de descuentos
		if (disc<=discfam)
				disc=discfam;
		
		System.out.println("Cuántos kilos de equipaje traes?");
		equipaje=sc.nextDouble();
		
		if (equipaje<20) {
			payequip=0;
		}
		else {
			extraequip=equipaje-20;
			payequip=2.5*extraequip;
		}
		
		switch (destino) {
		case "Barcelona":
		case "barcelona":
		case "b":
		case "B":
		case "BARCELONA":
			precioini=75;
			
				bill=precioini-(precioini*disc)+payequip;
				System.out.printf("Tendrás que pagar %.2f euros\n",bill);
			break;

		case "Zaragoza":
		case "zaragoza":
		case "Z":
		case "z":
		case "ZARAGOZA":
			precioini=40;

				bill=precioini-(precioini*disc)+payequip;
				System.out.printf("Tendrás que pagar %.2f euros\n",bill);
			break;
		
		default:
			System.out.println("Destino incorrecto");
			System.exit(0);
			break;
		}
		
		System.out.println(disc);
		
		//Apartado de hora
		
		int hs,ms,hl,ml,hv,mv,dia;
		System.out.println("hora de salida");
		hs=sc.nextInt();
		
		System.out.println("minuto de salida");
		ms=sc.nextInt();
		
		System.out.println("hora de llegada");
		hl=sc.nextInt();
		
		System.out.println("minuto de llegada");
		ml=sc.nextInt();
		
		System.out.printf("Hora de salida: %02d:%02d\n", hs,ms);
		System.out.printf("Hora de llegada: %02d:%02d\n", hl,ml);
		
		//calculo de tiempo de viaje
		mv=ml-ms;
		hv=hl-hs;
		
		if (mv<0 && hv>0) {
			hv=hl-hs-1;
			mv=60+mv;
			System.out.printf("Tiempo de viaje: %02d:%02d\n", hv,mv);
		}
		else 
			if (hv<0 && mv>0) {
			hv=24+hv;
			mv=ml-ms;
			System.out.printf("Tiempo de viaje: %02d:%02d\n", hv,mv);
		}
			else 
				if (hv<0 && mv<0) {
				hv=24+hv;
				mv=60+mv;
				System.out.printf("Tiempo de viaje: %02d:%02d\n", hv,mv);
			}
		else {
			hv=hl-hs;
			mv=ml-ms;
			System.out.printf("Tiempo de viaje: %02d:%02d\n", hv,mv);
		}
		
		
	}
}
