package vendedoresArrays;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre, marca;
		String marcas[] = { "nike", "adidas", "converse" };
		Vendedor vendedores[] = new Vendedor[8];
		int nVen = 0, posVen, posMar;
		String seguir = "S";

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduce nombre del comercial:");
			nombre = sc.nextLine();
			vendedores[nVen] = new Vendedor(nombre);
			nVen++;
			if (nVen >= 2 && nVen < 8) {
				System.out.println("Otro comercial?(S/N)");
				seguir = sc.nextLine();
			} else if (nVen == 8)
				seguir = "N";

		} while (seguir.equalsIgnoreCase("S"));

		System.out.println("Introduce nombre del empleado:");
		nombre = sc.nextLine();

		while (nombre.equalsIgnoreCase("FIN") == false) {
			posVen = buscarComercial(vendedores, nVen, nombre);
			if (posVen == -1) {
				System.out.println("No existe ese comercial");
				System.out.println("Introduce nombre del empleado:");
				nombre = sc.nextLine();
				continue;
			}
			do {
				System.out.println("Anota marca:");
				marca = sc.nextLine();
				posMar = buscarMarca(marcas, marca);
				if (posMar == -1)
					System.out.println("No existe esa marca");
			} while (posMar == -1);

			System.out.println("Anota número de ventas:");
			int nVentas = sc.nextInt();

			vendedores[posVen].vender(nVentas, posMar);
			System.out.println("Ventas anotadas");

			sc.nextLine();
			System.out.println("Introduce nombre del empleado:");
			nombre = sc.nextLine();
		}

		ordenar(vendedores, nVen);

		System.out.println("Los vendedores ordenados quedarían:");
		for (int i = 0; i < nVen; i++)
			System.out.println(vendedores[i].toString());

		System.out.println("Anota número de unidades:");
		int unidades = sc.nextInt();

		for (int i = 0; i < nVen; i++) {
			if (vendedores[i].getTotalVentas() < unidades) {
				// Borrar vendedor i
				for (int j = i; j < nVen - 1; j++)
					vendedores[j] = vendedores[j + 1];
				vendedores[nVen - 1] = null;
				nVen--;
				i--;
			}
		}
		
		System.out.println("Array después de borrar:");
		for (int i = 0; i < nVen; i++)
			System.out.println(vendedores[i].toString());

	}

	public static int buscarComercial(Vendedor v[], int nV, String nombre) {
		for (int i = 0; i < nV; i++) {
			if (v[i].getNombre().equalsIgnoreCase(nombre))
				return i;
		}
		return -1;
	}

	public static int buscarMarca(String marcas[], String marca) {
		for (int i = 0; i < marcas.length; i++)
			if (marcas[i].equalsIgnoreCase(marca))
				return i;
		return -1;
	}

	public static void ordenar(Vendedor v[], int nV) {
		int j, k;
		Vendedor aux;
		for (j = 1; j < nV; j++) // Doy tantas vueltas como elementos tenga mi array

			for (k = 0; k < nV - j; k++) // En cada vuelta llevo el elemento mayor al

				if (v[k].getTotalVentas() < v[k + 1].getTotalVentas()
						|| (v[k].getTotalVentas() == v[k + 1].getTotalVentas()
								&& v[k].getNombre().compareTo(v[k + 1].getNombre()) > 0)) // Si un elemento es mayor que
																							// el siguiente, los

				{
					aux = v[k];
					v[k] = v[k + 1];
					v[k + 1] = aux;
				}
	}

}
