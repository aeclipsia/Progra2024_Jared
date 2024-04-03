package eval1;

import java.util.*;

public class Eval1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String socio, socioVal, letras="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ", num="0123456789", resVal, segVal;
		int ppl,p=3,plaza=80,menu,copa,barra,bebida,nobebida=0,pplT=0,barraT=0;
		double precio,discount,precioT=0,barraPer,minPrec=0;
		boolean pedido=true,pplValid,menuVal,desc=false,seg,progbreak;
		//bucle de varias noches
		do {
			plaza=80;
			precioT=0;
			pplT=0;
			barraT=0;
			do {
				//bucle de una noche
				
				progbreak=false;
				do {
					//número de personas
					System.out.println("--------------------");
					System.out.println("Plazas disponibles: "+plaza);
					System.out.println("Número de personas para la reserva:");
					ppl=sc.nextInt();
					if (ppl<=0 && ppl!=-1) {
						System.out.println("Anota un número positivo");
						pplValid=false;
						continue;
					}
					if (ppl==-1) {
						progbreak=true;
						break;
					}
					else {
						progbreak=false;
						pplValid=true;
					}
					
					if (ppl>plaza) {
						System.out.println("No hay plazas suficiente");
						pplValid=false;
					}
				} while (pplValid==false);
				
				if (progbreak==true) {
					break;
				}
				
				//pedido de menu
				do {
					System.out.println("Elige el menú");
					System.out.println("1------Menú económico (25 euros)");
					System.out.println("2----Menú degustación (35 euros)");
					System.out.println("3-------Menú estrella (50 euros)");
					menu=sc.nextInt();
						
					//validación del menú
					menuVal = menuVal(menu);
					
					if (menu==1) {
						p=25;
					}
					else if (menu==2) {
						p=35;
					}
					else if (menu==3) {
						p=50;
					}
				} while (menuVal==false);
				//pedido de bebidas
				do {
					System.out.println("Cuántas personas van a querer 2 copas por 9 euros?");
					copa=sc.nextInt();
					System.out.println("Y cuántas van a querer la barra libre por 30 euros?");
					barra=sc.nextInt();
					bebida=copa+barra;
					if (bebida>ppl) {
						System.out.println("Han pedido más bebidas que personas");
						System.out.println("Por favor, anota bien el número de bebidas");
					}
					else {
						System.out.println(copa+" pedido(s) de 2 copas y "+barra+" de barra libre");
					}
				} while (bebida>ppl);
				//contador de personas sin bebida
				nobebida=nobebida+(ppl-bebida);
				//pedir socio
				System.out.println("Tiene carnet de socio?");
				socioVal=sc.next();
				if (socioVal.equalsIgnoreCase("sí") || socioVal.equalsIgnoreCase("si")) {
					System.out.println("Anota su número de carnet");
					socio=sc.next();
					if (socio.length()==4 || socio.length()==5) {
						if (letras.indexOf(socio.charAt(0))!=-1) {
							for (int i = 1; i <= socio.length()-1; i++) {
								if (num.indexOf(socio.charAt(i))!=-1) {
									desc=true;
								}
								else {
									desc=false;
								}
							}
						}
						else {
							desc=false;
						}
					}
					else {
						desc=false;
					}
				}
				else {
					desc=false;
				}
				
				if (desc==true) {
					discount=0.2;
					System.out.println("Número de socio válido");
				}
				else {
					discount=0;
				}
				//calculo de precio
				precio=calcular_precio(ppl, p, copa, barra, discount);
				//mostrar precio y confirmar
				System.out.println("Pago pendiente: "+precio);
				System.out.println("Confirmar reserva?");
				resVal=sc.next();
				if (resVal.equalsIgnoreCase("sí")||resVal.equalsIgnoreCase("si")) {
					System.out.println("Reserva confirmada");
					precioT=precioT+precio;
					pplT=pplT+ppl;
					barraT=barraT+barra;
					//resta de plazas
					plaza=plaza-ppl;
				}
				else {
					System.out.println("Reserva anulada");
				}
				
				if (plaza<=0) {
					pedido=false;
				}
			} while (pedido==true);
			System.out.println("NOCHE TERMINADA");
			if (progbreak==true) {
				System.out.println("Quiere seguir?");
				segVal=sc.next();
				
				if (segVal.equalsIgnoreCase("no")) {
					seg=false;
				}
				else {
					seg=true;
				}
			}
			else {
				System.out.println("Ganancia total: "+precioT);
				System.out.println("Número total de reservas: "+pplT);
				barraPer=(barraT/pplT)*100;
				System.out.println("Personas que se han apuntado a la barra libre: "+barraPer+"%");	
				System.out.println("Quiere seguir?");
				segVal=sc.next();
				
				if (segVal.equalsIgnoreCase("no")) {
					seg=false;
				}
				else {
					seg=true;
				}
			}
		} while (seg==true);
		if (minPrec==0) {
			minPrec=precioT;
		}
		else if (minPrec>precioT) {
			minPrec=precioT;
		}
		
		System.out.println("La mínima recaudación fue de "+minPrec+" euros.");
		
		System.out.println("Hubo "+nobebida+" personas que no han contratado bebidas.");
	}
	public static double calcular_precio(int ppl, int p, int copa, int barra, double desc) {
		double precio;
		precio=((ppl*p)+(copa*9)+(barra*30))-(((ppl*p)+(copa*9)+(barra*30))*desc);
		return precio;
	}
	public static boolean menuVal(int menu) {
		boolean menuVal;
		if (menu==1 || menu==2 || menu==3) {
			menuVal=true;
		}
		else {
			menuVal=false;
		}
		return menuVal;
	}
}