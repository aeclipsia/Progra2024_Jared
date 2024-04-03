package ej1;

import java.util.*;

public class Buenojaredjameslloyd1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		char continuar, domi, jubi;
		String cod, letra, letraVal = "P", guion, guionVal = "-", secc, precio, codFin = "P0-000";
		int seccConv, uni, zona, lacTotal = 0;
		double presupuesto, precioConv, precioCompra, precioTotal = 0, env = 0, precioFinal, porcJubi, jubiTotal = 0,
				perTotal = 0, max = 0, max2 = 0;
		boolean presVal = true, codVal = true, contProd = true, compraVal = false, domiVal = false, zonaVal = false,
				masPer = false;

		do {
			lacTotal = 0;
			masPer = true;
			precioTotal = 0;
			// validacion de presupuesto
			do {
				presVal = true;
				System.out.println("Anota presupuesto máximo: ");
				presupuesto = sc.nextDouble();
				sc.nextLine();

				if (presupuesto < 0) {
					System.out.println("Presupuesto no válido, debe ser positivo");
					presVal = false;
				} else if (presupuesto == 0) {
					masPer = false;
				}
			} while (presVal == false);

			if (masPer == false) {
				break;
			}

			// productos
			do {
				// validacion de codigo
				do {
					codVal = true;
					System.out.println("Anota código de producto: (PX-XXX)");
					cod = sc.next();
					sc.nextLine();

					letra = cod.substring(0, 1);
					secc = cod.substring(1, 2);
					guion = cod.substring(2, 3);
					precio = cod.substring(3);

					codVal = validarCodigo(cod, letra, letraVal, guion, guionVal, codVal);
				} while (codVal == false);

				if (cod.equals(codFin)) {
					contProd = false;
					break;
				}

				// precio por unidad
				System.out.println("El precio es de " + Integer.parseInt(precio) + " euros unidad");

				// validacion de compra (si supera el presupuesto)
				do {
					compraVal = true;
					// pedir unidades
					System.out.println("Anota unidades");
					
					/*
					 do while para validar las unidades que sean positivos
					 */
					uni = sc.nextInt();
					sc.nextLine();
					if (uni == 0) {
						continue;
					} else {
						precioCompra = calcPrecio(secc, precio, uni);
					}
					if ((precioTotal + precioCompra) <= presupuesto) {
						precioTotal = precioTotal + precioCompra;
					} else {
						System.out.println("Ha superado el presupuesto de " + presupuesto + " euros");
						compraVal = false;
						continue;
					}
					if (Integer.parseInt(secc) == 4) {
						lacTotal = lacTotal + uni;
					}

					System.out.println("Lleva gastados " + precioTotal + " euros");

				} while (compraVal == false);

				// seguir?
				System.out.println("Desea anotar otro producto? S/N");
				continuar = sc.next().charAt(0);
				continuar = Character.toUpperCase(continuar);
				sc.nextLine();
				switch (continuar) {
				case 'S':
					contProd = true;
					break;

				case 'N':
					contProd = false;
					break;

				default:
					contProd = true;
					break;
				}

			} while (contProd == true);

			// envio a domicilio
			do {
				domiVal = true;

				System.out.println("Envío a domicilio? S/N");
				domi = sc.next().charAt(0);
				domi = Character.toUpperCase(domi);
				sc.nextLine();

				switch (domi) {
				case 'S':
					System.out.println("Jubilado?");
					jubi = sc.next().charAt(0);
					jubi = Character.toUpperCase(jubi);
					sc.nextLine();

					do {
						zonaVal = true;
						env = 0;
						System.out.println("Anota zona (1/2/3)");
						zona = sc.nextInt();
						sc.nextLine();
						switch (zona) {
						case 1:
							if (jubi == 'S') {
								System.out.println("Su envío será gratis");
								env = 0;
								jubiTotal = jubiTotal + 1;
							} else {
								env = 5;
							}
							break;

						case 2:
							if (jubi == 'S') {
								System.out.println("Su envío será gratis");
								env = 0;
								jubiTotal = jubiTotal + 1;
							} else {
								env = 7;
							}
							break;

						case 3:
							if (jubi == 'S') {
								System.out.println("Su envío será gratis");
								env = 0;
								jubiTotal = jubiTotal + 1;
							} else {
								env = 10;
							}
							break;

						default:
							System.out.println("Zona no válida");
							zonaVal = false;
							break;
						}
						System.out.println("Gasto de envío: " + env);
					} while (zonaVal == false);

					break;

				case 'N':
					env = 0;
					break;

				default:
					System.out.println("Error, anota S o N");
					domiVal = false;
					break;
				}
			} while (domiVal == false);
			precioFinal = precioTotal + env;

			if (precioFinal > max2) {
				if (precioFinal > max) {
					max2 = max;
					max = precioFinal;
				} else {
					max2 = precioFinal;
				}
			}

			System.out.println("Precio total: " + precioFinal);
			System.out.println("Ha comprado " + lacTotal + " unidades de lácteos");

			perTotal = perTotal + 1;

		} while (masPer == true);
		porcJubi = (jubiTotal / perTotal) * 100;
		System.out.println("Porcentaje envíos realizados a jubilados: " + porcJubi);
		System.out.println("Compras más caras " + max + " " + max2);
	}

	public static double calcPrecio(String secc, String precio, int uni) {
		int seccConv;
		double precioConv;
		double precioCompra;
		seccConv = Integer.parseInt(secc);
		precioConv = Integer.parseInt(precio);
		switch (seccConv) {
		case 3:
			precioCompra = (precioConv * uni) * 0.8;
			System.out.println("Producto de pescadería, descuento del 20%");
			System.out.println("Total: " + precioCompra);
			break;

		case 4:
			if (uni > 3) {
				System.out.println("Producto lacteo, al comprar más de 3, tienes un descuento de 2 euros");
				precioCompra = (precioConv * uni) - 2;
				System.out.println("Total: " + precioCompra);
			} else {
				precioCompra = (precioConv * uni);
				System.out.println("Sin descuento");
				System.out.println("Total: " + precioCompra);
			}
			break;

		default:
			precioCompra = (precioConv * uni);
			System.out.println("Sin descuento");
			System.out.println("Total: " + precioCompra);
			break;
		}
		return precioCompra;
	}

	public static boolean validarCodigo(String cod, String letra, String letraVal, String guion, String guionVal,
			boolean codVal) {
		if (cod.length() != 6) {
			System.out.println("Error! El código debe tener 5 caracteres");
			codVal = false;
		}
		if (!letra.equals(letraVal)) {
			System.out.println("Error! El código debe empezar por P en mayúscula");
			codVal = false;
		}
		if (!guion.equals(guionVal)) {
			System.out.println("Error! El código debe tener el formato PX-XXX");
			codVal = false;
		}
		return codVal;
	}

}
