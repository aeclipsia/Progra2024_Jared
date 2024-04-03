//NOMBRE: JARED JAMES LLOYD
//APELLIDO: BUENO

//FECHA: 02/10/2023

package apartamento;

import java.util.*;

public class Programa_apartamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		boolean garaje;
		int planta;
		double precio=0;
		char puerta;
		
		//input
		System.out.println("Quieres garaje? (true/false)");
		garaje=sc.nextBoolean();
		
		System.out.println("Elija una planta: ");
		planta=sc.nextInt();
		
		//precio por dia sin descuento
		
		switch (planta) {
		
		//planta 1 y planta 2 no tiene suplemento
		case 1:
		case 2:
			if (garaje==true) {
				precio=100;
				System.out.println("El precio por día sin descuento será: "+precio);
			}
			else 
			if (garaje==false){
				precio=75;
				System.out.println("El precio por día sin descuento será: "+precio);
			}	
			break;
			
		//planta 3 a 5 tienen que pagar 5 euros de suplemento
		case 3:
		case 4:
		case 5:
			if (garaje==true) {
				precio=100+5;
				System.out.println("El precio por día sin descuento será: "+precio);
			}
			else {
				precio=75+5;
				System.out.println("El precio por día sin descuento será: "+precio);
			}
			break;
			
		//planta 6 a 9 pagan 7 euros de suplemento pero 6 tienen condiciones especiales	
		case 7:
		case 8:
		case 9:
			if (garaje==true) {
				precio=100+7;
				System.out.println("El precio por día sin descuento será: "+precio);
			}
			else {
				precio=75+7;
				System.out.println("El precio por día sin descuento será: "+precio);
			}
			break;

			
		//planta 10 pagan 10 euros de suplemento
		case 10:
			if (garaje==true) {
				precio=100+10;
				System.out.println("El precio por día sin descuento será: "+precio);
			}
			else {
				precio=75+10;
				System.out.println("El precio por día sin descuento será: "+precio);
			}
			break;

		//planta 6 paga 7 euros de suplemento y las puertas A y B pagan 5 euros más	
		case 6:
			sc.nextLine();
			System.out.println("Anota puerta: ");
			puerta=sc.next().charAt(0);
			switch (puerta) {
			case 'A':
			case 'a':
			case 'B':
			case 'b':
				if (garaje==true) {
					precio=100+7+5;
					System.out.println("El precio por día sin descuento será: "+precio);
				}
				else {
					precio=75+7+5;
					System.out.println("El precio por día sin descuento será: "+precio);
				}
				break;

			default:
				System.out.println("ERROR! PUERTA NO ENCONTRADA");
				System.exit(0);
				break;
			}
			break;
		
		//plantas que no están entre 1 y 10 (ya que 10 es la última)	
		default:
			System.out.println("ERROR! PLANTA NO ENCONTRADO!");
			System.exit(0);
			break;
		}
			
		//input de días
		int dia,semana;
		double preciodesc, desc;
		
		System.out.println("Anota número de noches que quieres alquilar: ");
		dia=sc.nextInt();
		
		//operación de calculo de número de semanas
		semana=dia/7;
		
		if (semana>=1 && semana<2) {
			if (garaje==true) {
				desc=0.2;
				preciodesc=precio-(precio*desc);
				System.out.println("El precio final por día será: "+preciodesc);
			}
			else {
				desc=0.15;
				preciodesc=precio-(precio*desc);
				System.out.println("El precio final por día será: "+preciodesc);
			}
		}
		else if (semana>=2) {
			desc=0.25;
			preciodesc=precio-(precio*desc);
			System.out.println("El precio final por día será: "+preciodesc);
		}
		else {
			preciodesc=precio;
			System.out.println("El precio final por día será "+preciodesc);
		}
		
		//precio total
		double preciototal;
		
		preciototal=preciodesc*dia;
		System.out.println("Precio total: "+preciototal);
		
		//día de entrada y salida
		char diasem;
		int diasextra=dia%7, numday=0, diasalida;
		
		System.out.println("Anota día de entrada (L,M,X,J,V,S,D)");
		diasem=sc.next().charAt(0);
		
		
		//convertir día en dato numérico
		switch (diasem) {
		case 'L':
		case 'l':
			numday=1;
			break;
		case 'M':
		case 'm':
			numday=2;
			break;
		case 'X':
		case 'x':
			numday=3;
			break;
		case 'J':
		case 'j':
			numday=4;
			break;
		case 'V':
		case 'v':
			numday=5;
			break;
		case 'S':
		case 's':
			numday=6;
			break;
		case 'D':
		case 'd':
			numday=7;
			break;
		default:
			System.out.println("ERROR! DIA INCORRECTA");
			System.exit(0);
			break;
		}
		
		//operar dias
		diasalida=numday+diasextra;
		//ESTA PARTE NO ESTÁ EN EL EXAMEN. ESTO ES CORECCIÓN
		diasalida=diasalida%7;
		//FIN DE CORECCIÓN
		
		//convertir número en día
		switch (diasalida) {
		case 1:
			System.out.println("Saldrás en Lunes");
			break;
			
		case 2:
			System.out.println("Saldrás en Martes");
			break;
			
		case 3:
			System.out.println("Saldrás en Miércoles");
			break;
			
		case 4:
			System.out.println("Saldrás en Jueves");
			break;
			
		case 5:
			System.out.println("Saldrás en Viernes");
			break;
			
		case 6:
			System.out.println("Saldrás en Sabado");
			break;
			
		case 7:
			System.out.println("Saldrás en Domingo");
			break;

		default:
			System.out.println("ERROR!");
			System.exit(0);
			break;
		}
	}
}