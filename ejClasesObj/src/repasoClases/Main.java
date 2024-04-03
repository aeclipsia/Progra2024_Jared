package repasoClases;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String mat, modelo;
		int yy, cat, ope, d, veh;
		char continuar;
		boolean matVal=false,cont=false,opVal;
		
		//Creación de vehículos
		Vehiculos v1 = crearVehiculo(sc);
		Vehiculos v2 = crearVehiculo(sc);
		
		//Operaciones de vehículos
		do {
			cont=true;
			
			System.out.println("1=alquilar");
			System.out.println("2=devolver");
			System.out.println("3=disponibilidad");
			ope=sc.nextInt();
			
			switch (ope) {
			case 1:
				System.out.println("Cuantas días quieres alquilar?");
				d=sc.nextInt();
				do {
					opVal=true;
					System.out.println("Qué vehículo?");
					System.out.println("1:"+v1.toString());
					System.out.println("2:"+v2.toString());
					veh=sc.nextInt();
					switch (veh) {
					case 1:
						v1.Alquilar(d);
						break;

					case 2:
						v2.Alquilar(d);
						break;	
					
					default:
						System.out.println("Opción no valida");
						opVal=false;
						break;
					}
				} while (opVal==false);
				break;
				
			case 2:
				do {
					opVal=true;
					System.out.println("Qué coche quieres devolver?");
					System.out.println("1:"+v1.toString());
					System.out.println("2:"+v2.toString());
					veh=sc.nextInt();
					switch (veh) {
					case 1:
						v1.Devolver();
						break;

					case 2:
						v2.Devolver();;
						break;	
						
					default:
						System.out.println("Opción no valida");
						opVal=false;
						break;
					}
				} while (opVal==false);
				break;	
				
			case 3:
				do {
					opVal=true;
					
					System.out.println("Cuál de los coches te interesa?");
					System.out.println("1:"+v1.toString());
					System.out.println("2:"+v2.toString());
					veh=sc.nextInt();
					switch (veh) {
					case 1:
						v1.Disponible();
						break;
						
					case 2:
						v2.Disponible();
						break;	

					default:
						System.out.println("Opción no valida");
						opVal=true;
						break;
					}
				} while (opVal==false);
				break;

			default:
				System.out.println("Opción no valida");
				cont=false;
				break;
			}
			
			System.out.println("Quieres seguir? S/N");
			continuar=sc.next().charAt(0);
			continuar=Character.toUpperCase(continuar);
			
			switch (continuar) {
			case 'S':
				cont=true;
				break;
				
			case 'N':
				cont=false;
				break;

			default:
				cont=true;
				break;
			}
		} while (cont==true);
		
		v1.TotalVehiculo();
		v2.TotalVehiculo();
		
		Vehiculos.TotalEmpresa();

		
	}


	public static Vehiculos crearVehiculo(Scanner sc) {
		String mat, modelo, letras="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int yy, cat;
		boolean matVal;
		System.out.println("Anota el modelo del vehículo: ");
		modelo=sc.nextLine();
		
		do {
			matVal=true;
			
			System.out.println("Anota su matricula ");
			mat=sc.nextLine();
			
			matVal = validarMat(mat, letras, matVal);
			
			if (matVal==false) {
				System.out.println("Matricula invalida");
			}
			else {
				System.out.println("Matricula valida");
			}
		} while (matVal==false);
		
		System.out.println("Anota el año de matriculación: ");
		yy=sc.nextInt();
		
		System.out.println("Anota su categoría: (1 o 2)");
		cat=sc.nextInt();
		sc.nextLine();
		
		Vehiculos vehiculo = new Vehiculos(mat,modelo,yy,cat);
		return vehiculo;
	}

	
	public static boolean validarMat(String mat, String letras, boolean matVal) {
		if (mat.length()!=7) {
			matVal=false;
		}
		else {
			if (Integer.parseInt(mat.substring(0,4))>0 || Integer.parseInt(mat.substring(0,4))<9999) {
				for (int i = 4; i < mat.length(); i++) {
					
					char letraMat=Character.toUpperCase(mat.charAt(i));
					
					if (letras.indexOf(letraMat)==-1) {
						matVal=false;
					}
					
					
				}
			}
			else {
				matVal=false;
			}
		}
		return matVal;
	}

}
