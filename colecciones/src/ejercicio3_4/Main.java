package ejercicio3_4;

import java.util.*;

public class Main {

	static Scanner sc;
	static int op, numEntradas, peliEncontrado;
	
	static Sala peli[]=new Sala[2];
	static LinkedList<Cliente> colaEspera=new LinkedList<Cliente>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc=new Scanner(System.in);
		
		peli[0]=new Sala(1,"Oppenheimer");
		peli[1]=new Sala(2,"Barbie");
		
		
		//menu
		do {
			try {
				System.out.println("1-Llegada de cliente\n2-Comprar entradas\n3-Mostrar información\n4-Salir");
				op=sc.nextInt();
				switch (op) {
				case 1:
					sc.nextLine(); //limpiar buffer
					altaCliente();
					break;
					
				case 2:
					pagarEntrada();
					break;
					
				case 3:
					System.out.println(colaEspera.toString());
					for (int i = 0; i < peli.length; i++) {
						System.out.println("La película "+peli[i].getNomPeli()+" tiene "+peli[i].getDispo()+" plazos disponible");
						System.out.printf("y ha recaudado un total de %.2f euros.\n",peli[i].getRecaudado());
					}
					break;
					
				case 4:
					System.out.println("Gracias!");
					break;

				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Sólo acepta números");
				sc.nextLine();
			}
		} while (op!=4);
	}

	public static void altaCliente() {
		System.out.println("Anota su nombre: ");
		String nombre=sc.nextLine();
		
		System.out.println("Anota la película: ");
		String nomPeli=sc.nextLine();
		
		try {
			peliEncontrado=findPeli(nomPeli);
		} catch (PeliNoEncontradoException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("Cuántas entradas?");
		numEntradas=sc.nextInt();
		
		if (numEntradas>peli[peliEncontrado].getDispo()) {
			System.out.println("No hay plazos disponibles");
			return;
		}
		
		System.out.println("Tipo de cliente:\n1-Normal\n2-Pase\n3-Socio");
		op=sc.nextInt();
		switch (op) {
		case 1:
			colaEspera.add(new Cliente(nombre,nomPeli,numEntradas)); //alta cliente
			break;
			
		case 2:
			colaEspera.add(new Pase(nombre,nomPeli,numEntradas)); //alta cliente
			break;
			
		case 3:
			sc.nextLine(); //limpiar buffer
			System.out.println("Anota carnet de socio ");
			String id=sc.nextLine();
			colaEspera.add(new Socio(nombre,nomPeli,numEntradas,id)); //alta cliente
			break;

		default:
			System.out.println("Anota 1,2 o 3");
			break;
		}
	}
	
	public static void pagarEntrada() {
		try {
			peliEncontrado=findPeli(colaEspera.get(0).getNomPeli());
			
			if (colaEspera.get(0).getNumEntradas()<=peli[peliEncontrado].getDispo()) {
				double importe=(colaEspera.get(0)).pagar(); //pagar
				System.out.printf("Importe: %.2f\n",importe);
				peli[peliEncontrado].addRecaudado(importe); //acumulador de recaudados
				peli[peliEncontrado].minusDispo(colaEspera.get(0).getNumEntradas()); //restar plazos
				colaEspera.remove(0); //quitar de la cola
				
				checkPeli(); //comprueba si la sala sigue disponible y borra todos los de la misma peli si ya está llena
				
				try {
					checkSalas(); //comprueba si las 2 salas siguen teniendo plazos. Si las 2 salas ya están llenas, se termina el programa.
				} catch (SalasFullException e) {
					System.out.println(e.getMessage());
					
					for (int i = 0; i < peli.length; i++) { //se muestra los datos finales antes de irse
						System.out.println("La película "+peli[i].getNomPeli()+" tiene "+peli[i].getDispo()+" plazos disponible");
						System.out.printf("y ha recaudado un total de %.2f euros.\n",peli[i].getRecaudado());
					}
					
					System.exit(0);
				}
			}
			else {
				colaEspera.remove(0);
				System.out.println("No hay suficiente plazos disponibles");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Cola de espera vacía");
		} catch (PeliNoEncontradoException e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	private static void checkPeli() {
		if (peli[peliEncontrado].getDispo()==0) {
			for (int i = colaEspera.size()-1; i >= 0; i--) {
				if (colaEspera.get(i).getNomPeli().equalsIgnoreCase(peli[peliEncontrado].getNomPeli())) {
					colaEspera.remove(i);
				}
			}
			System.out.println("Ya no hay plazos disponibles. Se vacía la cola de esa película");
		}
	}
	
	private static void checkSalas() throws SalasFullException{ 
		for (int i = 0; i < peli.length; i++) {
			if (peli[i].getDispo()!=0) {
				return;
			}
		}
		throw new SalasFullException("Las dos salas están llenas");
	}
	
	public static int findPeli(String nomPeli) throws PeliNoEncontradoException {
		for (int i = 0; i < peli.length; i++) {
			if (nomPeli.equalsIgnoreCase(peli[i].getNomPeli())) {
				return i;
			}
		}
		throw new PeliNoEncontradoException("Peli no encontrado");
	}
	
}
