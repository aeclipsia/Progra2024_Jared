package restaurante;

import java.util.*;

public class Main {

	static Scanner sc;

	static Comensal mesas[]=new Comensal[4];
	
	public static void main(String[] args) {
		
		sc=new Scanner(System.in);
		
		int op,mesaPos=0,mesa1,mesa2;
		
		//menu
		do {
			System.out.println("1-Llegada de clientes\n"
					+ "2-Servir mesa\n"
					+ "3-Pagar\n"
					+ "4-Juntar 2 mesas\n"
					+ "5-Mostrar información\n"
					+ "6-Salir");
			op=sc.nextInt();
			
			switch (op) {
			case 1: //alta mesa
				
				try {
					mesaPos=buscarMesaDisponible();
					
					mesas[mesaPos]=inComensal();
				} catch (NoMesasDisponible e) {
					System.out.println(e.getMessage());
					break;
				}
				
				break;
				
			case 2: //servir
				System.out.println("Anota el número de mesa");
				op=sc.nextInt();
				
				try {
					mesaPos=buscarMesa(op);
					if (mesas[mesaPos].getPedirTry()<=3) {
						System.out.println("En esta mesa hay "+mesas[mesaPos].getNComensal()+" comensales.");
						pedir(mesaPos);
					}
					else {
						System.out.println("Ya pediste más de 3 veces");
					}
				} catch (MesaNoEncontradaException e) {
					System.out.println(e.getMessage());
					break;
				}				
				break;
				
			case 3: //pagar
				System.out.println("Anota el número de mesa");
				op=sc.nextInt();
				
				try {
					mesaPos=buscarMesa(op);
					
					mesas[mesaPos].pagar();
					
					if (mesas[mesaPos].getJuntado()==true) {
						mesas[mesas[mesaPos].mesaJuntado]=null;
						
						mesas[mesaPos].changeJuntado();
					}
					
					mesas[mesaPos]=null;
				} catch (MesaNoEncontradaException e) {
					System.out.println(e.getMessage());
					break;
				}
				break;
				
			case 4:
				System.out.println("Anota las mesas para juntar:\n"
						+ "Primera mesa: ");
				mesa1=sc.nextInt();
				System.out.println("Segunda mesa: ");
				mesa2=sc.nextInt();
				
				try {
					juntarMesas(mesa1,mesa2);
				} catch (MesaJuntarInvalidException e) {
					System.out.println(e.getMessage());
					break;
				}
				break;
				
			case 5:
				for (int i = 0; i < mesas.length; i++) {
					if (mesas[i]!=null) {
						System.out.println(mesas[i].toString());
					}
				}
				
				System.out.println(" personas pidieron del tipo Normal");
				System.out.println(" personas pidieron del tipo Tenedor");
				System.out.println(" personas pidieron del tipo Gourmet");

				break;

			default:
				break;
			}
		} while (op!=6);
		
		
	}
	
	public static Comensal inComensal() {
		int nComensales=(int)(Math.random()*5)+1;
		
		int grupo;
		boolean codVal;
		String cod;
		
		Comensal x=null;
		
		System.out.println("Grupo:\n"
				+ "1-Normal\n"
				+ "2-Tenedor\n"
				+ "3-Gourmet");
		grupo=sc.nextInt();
		
		switch (grupo) {
		case 1:
			x = new Normal(nComensales, 1);
			
			System.out.println("Número de comensales: "+x.getNComensal());
			
			break;
		case 2:
			sc.nextLine();
			do {
				codVal=true;
				System.out.println("Anota su código de descuento con formato 'TExx' ");
				cod=sc.nextLine();
				
				codVal=Tenedor.validarCodigo(cod);
				
				if (codVal==false) {
					System.out.println("Código no válido");
				}
			} while (codVal==false);			
			
			x = new Tenedor(nComensales, cod, 2);
			System.out.println("Número de comensales: "+x.getNComensal());
			break;
			
		case 3:
			x = new Gourmet(nComensales, 3);
			System.out.println("Número de comensales: "+x.getNComensal());
			break;

		default:
			break;
		}
		
		x.addContador(nComensales, grupo);
		
		return x;
		
	}
	
	public static int buscarMesaDisponible() throws NoMesasDisponible{
		for (int i = 0; i < mesas.length; i++) {
			if (mesas[i]==null) {
				return i;
			}
		}
		throw new NoMesasDisponible("No hay mesas disponible");
	}
	
	public static int buscarMesa(int op) throws MesaNoEncontradaException{
		for (int i = 0; i < mesas.length; i++) {
			if (mesas[i]!=null && i==op) {
				return i;
			}
		}
		throw new MesaNoEncontradaException("Mesa no encontrada");
	}
	
	public static void pedir(int mesaPos) {
		System.out.println("Anota número de raciones: ");
		int racion = sc.nextInt();
		if (mesas[mesaPos].getRacion()+racion<=mesas[mesaPos].getNComensal()) {
			mesas[mesaPos].addRacion(racion);
		}
		else {
			System.out.println("Valor no válido");
		}
		
		System.out.println("Anota número de bebidas: ");
		int bebida = sc.nextInt();
		
		if (mesas[mesaPos].getBebida()+bebida<=mesas[mesaPos].getNComensal()) {
			mesas[mesaPos].addBebida(bebida);
		}
		else {
			System.out.println("Valor no válido");
		}
		
		mesas[mesaPos].addPedirTry();
	}

	public static void juntarMesas(int mesa1, int mesa2) throws MesaJuntarInvalidException{
		try {
			if (mesas[mesa1].getNComensal()+mesas[mesa2].getNComensal()>20) {
				throw new MesaJuntarInvalidException("El número de comensales totales son más de 5");
			}
			if (mesas[mesa1].getTipo()!=mesas[mesa2].getTipo()) {
				throw new MesaJuntarInvalidException("No son del mismo tipo");
			}
			if (mesa1<mesa2) {
				switch (mesas[mesa1].getTipo()) {
				case 1:
					mesas[mesa1]=new Normal(mesas[mesa1].getNComensal()+mesas[mesa2].getNComensal(),1);
					
					mesas[mesa2]=new Normal(0,1); //una mesa con 0 comensales pero no NULL para indicar q está juntado
					System.out.println("Número de comensales: "+mesas[mesa1].getNComensal());
					
					
					mesas[mesa1].changeJuntado();
					
					mesas[mesa1].setMesaJuntado(mesa2);
					break;
					
				case 2:
					boolean codVal;
					String cod;
					
					do {
						codVal=true;
						
						System.out.println("Anota su código de descuento con formato 'TExx' ");
						cod=sc.nextLine();
						
						codVal=Tenedor.validarCodigo(cod);
						
						if (codVal==false) {
							System.out.println("Código no válido");
						}
					} while (codVal==false);
					
					mesas[mesa1]=new Tenedor(mesas[mesa1].getNComensal()+mesas[mesa2].getNComensal(), cod, 2);
					
					mesas[mesa2]=new Normal(0,1);
					System.out.println("Número de comensales: "+mesas[mesa1].getNComensal());
					
					mesas[mesa1].changeJuntado();
					
					mesas[mesa1].setMesaJuntado(mesa2);
					break;
					
				case 3:
					mesas[mesa1]=new Gourmet(mesas[mesa1].getNComensal()+mesas[mesa2].getNComensal(),3);
					
					mesas[mesa2]=new Normal(0,1);
					System.out.println("Número de comensales: "+mesas[mesa1].getNComensal());
					
					mesas[mesa1].changeJuntado();
					
					mesas[mesa1].setMesaJuntado(mesa2);
					break;

				default:
					break;
				}
			}
			else {
				switch (mesas[mesa2].getTipo()) {
				case 1:
					mesas[mesa2]=new Normal(mesas[mesa2].getNComensal()+mesas[mesa1].getNComensal(),1);
					
					mesas[mesa1]=new Normal(0,1); //una mesa con 0 comensales pero no NULL para indicar q está juntado
					System.out.println("Número de comensales: "+mesas[mesa1].getNComensal());
					
					
					mesas[mesa2].changeJuntado();
					
					mesas[mesa2].setMesaJuntado(mesa2);
					break;
					
				case 2:
					boolean codVal;
					String cod;
					
					do {
						codVal=true;
						
						System.out.println("Anota su código de descuento con formato 'TExx' ");
						cod=sc.nextLine();
						
						codVal=Tenedor.validarCodigo(cod);
						
						if (codVal==false) {
							System.out.println("Código no válido");
						}
					} while (codVal==false);
					
					mesas[mesa2]=new Tenedor(mesas[mesa2].getNComensal()+mesas[mesa1].getNComensal(), cod, 2);
					
					mesas[mesa1]=new Normal(0,1);
					System.out.println("Número de comensales: "+mesas[mesa2].getNComensal());
					
					mesas[mesa2].changeJuntado();
					
					mesas[mesa2].setMesaJuntado(mesa1);
					break;
					
				case 3:
					mesas[mesa2]=new Gourmet(mesas[mesa2].getNComensal()+mesas[mesa1].getNComensal(),3);
					
					mesas[mesa1]=new Normal(0,1);
					System.out.println("Número de comensales: "+mesas[mesa2].getNComensal());
					
					mesas[mesa2].changeJuntado();
					
					mesas[mesa2].setMesaJuntado(mesa1);
					break;

				default:
					break;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Alguna de las mesas están vacías");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("El restaurante solo tiene 4 mesas");
		}			
	}
	
}
