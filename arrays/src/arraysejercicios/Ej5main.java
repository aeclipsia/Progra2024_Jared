package arraysejercicios;

import java.util.*;

import arraysejercicios.Ej5Vehiculos;

public class Ej5main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int ope, d, veh;
		char continuar;
		boolean cont=false,opVal;
		
		//Creación de vehículos
		Ej5Vehiculos v[] = new Ej5Vehiculos[2];
		
		for (int i = 0; i < v.length; i++) {
			v[i]=crearVehiculo(sc);
		}
		
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
					for (int i = 0; i < v.length; i++) {
						System.out.println((i+1)+":"+v[i].toString());
					}
					veh=sc.nextInt();
					if (veh<1 || veh>5) {
						opVal=false;
					}
				} while (opVal==false);
				
				(v[veh-1]).Alquilar(d);
				
				break;
				
			case 2:
				do {
					opVal=true;
					System.out.println("Qué coche quieres devolver?");
					for (int i = 0; i < v.length; i++) {
						System.out.println((i+1)+":"+v[i].toString());
					}
					veh=sc.nextInt();
					if (veh<1 || veh>5) {
						opVal=false;
					}
				} while (opVal==false);
				
				(v[veh-1]).Devolver();
				
				break;	
				
			case 3:
				do {
					opVal=true;
					
					System.out.println("Cuál de los coches te interesa?");
					for (int i = 0; i < v.length; i++) {
						System.out.println((i+1)+":"+v[i].toString());
					}
					veh=sc.nextInt();
					if (veh<1 || veh>5) {
						opVal=false;
					}
				} while (opVal==false);
				
				(v[veh-1]).Disponible();
				
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
		
		ordenarGanancias(v,v.length);
		
		for (int i = 0; i < v.length; i++) {
			v[i].TotalVehiculo();
		}
		
		Ej5Vehiculos.TotalEmpresa();
		
	}


	public static Ej5Vehiculos crearVehiculo(Scanner sc) {
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
		
		Ej5Vehiculos vehiculo = new Ej5Vehiculos(mat,modelo,yy,cat);
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

	public static void ordenarGanancias(Ej5Vehiculos v[],int l) {
		int j, k;
		Ej5Vehiculos aux;
		for (j = 1; j < l; j++) {
			for (k = 0; k < l - j ; k++) {
				if (v[k].getGanancias() > v[k+1].getGanancias()) {
					aux=v[k];
					v[k]=v[k+1];
					v[k+1]=aux;
				}
			}
		}
	}
	
}
