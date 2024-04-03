package arraysejercicios;

import java.util.*;
public class Examen2022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int op,nV=0,unidades,pos, pos2;
		
		Vendedores vendedor[] = new Vendedores[8];
		String marcas[]= {"nike","adidas","converse"};
		String ven, marcaInput;
		
		
		//menu para dar de alta a los vendedores
		for (int i = 0; i < vendedor.length; i++) {
			System.out.println("1-Alta\n2-Salir");
			op=sc.nextInt();
			
			switch (op) {
			case 1:
				vendedor[i]=crearVendedor(sc, i);
				nV=i;
				break;
				
			case 2:
				if (i<2) {
					System.err.println("Tiene que haber un mínimo de 2 vendedores");
					i=i-1;
					break;
				}
				else {
					nV=i;
					i=vendedor.length;
					break;
				}

			default:
				System.err.println("Error, opción no válido");
				i=i-1;
				break;
			}
		}
		
		System.out.println("-------------------------------------------------------");
		
		//Ventas
		do{
			pos=0;
			
			System.out.println("Anota el nombre del vendedor");
			ven=sc.next();
			pos=buscarVendedor(vendedor,ven,nV);
			
			if (ven.equalsIgnoreCase("fin")) {
				System.err.println("FIN");
				break;
			}
			
			if (pos==-1) {
				System.err.println("Nombre no válido");
				continue;
			}
			else {
				do {
					System.out.println("Anota marca");
					marcaInput=sc.next();
					pos2=buscarMarca(marcas,marcaInput);
					if (pos2==-1) {
						System.err.println("Marca no válida");
						continue;
					}
					else {
						System.out.println("Unidades vendidas de "+marcaInput+":");
						unidades=sc.nextInt();
						
						vendedor[pos].Vender(unidades, pos2);
					}
				} while (pos2==-1);
			}
		}while(!ven.equalsIgnoreCase("fin")) ;
		
		//Ordenar
		ordenar(vendedor, nV);
		
		for (int j = 0; j < nV; j++) {
			System.out.println(vendedor[j].toString());
		}
		
		//Borrar
		System.out.println("Anota las unidades");
		unidades=sc.nextInt();
		borrar(vendedor, nV, unidades);
		
		for (int i = 0; i < nV; i++) {
			System.out.println(vendedor[i].toString());
		}
		
		
		
	}
	
	public static void borrar(Vendedores v[], int nV, int unidades) {
		for (int i = 0; i < nV; i++) {
			for (int j = i; j < nV - 1; j++)
				v[j] = v[j + 1];
			v[nV - 1] = null;
			nV--;
			i--;
		}
	}
	
	public static void ordenar(Vendedores v[], int nV) {
		int j, k;
		Vendedores aux;
		for (j = 1; j < nV; j++)
			for (k = 0; k < nV - j; k++)
				if (v[k].gettotalVentas() < v[k + 1].gettotalVentas() ||
						(v[k].gettotalVentas()==v[k+1].gettotalVentas() && v[k].getNombre().compareTo(v[k+1].getNombre())>0)) {
					aux = v[k];
					v[k] = v[k + 1];
					v[k + 1] = aux;
				}
	}
	
	public static int buscarMarca(String marcas[],String marcaInput) {
		for (int i = 0; i < marcas.length; i++) {
			if (marcaInput.equalsIgnoreCase(marcas[i])) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static int buscarVendedor(Vendedores vendedor[],String ven, int nV) {
		for (int i = 0; i < nV; i++) {
			if (vendedor[i].getNombre().equalsIgnoreCase(ven)) {
				return i;
			}
		}
		return -1;
	}
	
	public static Vendedores crearVendedor(Scanner sc, int i) {
		String nomVen;
		
		System.out.println("Nombre del vendedor "+(i+1)+":");
		nomVen=sc.next();
		
		Vendedores vendedor = new Vendedores (nomVen);
		return vendedor;
	}

}
