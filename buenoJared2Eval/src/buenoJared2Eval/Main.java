package buenoJared2Eval;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeParseException;

/*
 * @author Jared James Lloyd Bueno
 */

public class Main {

	static Scanner sc;
	static Arreglos arr[] = new Arreglos[10];
	static Empleados emple[] = new Empleados[20];
	static int op,nowArreglos=0;
	
	public static void main(String[] args) {
		
		int emplecount=0, pos;
		String codinput,fechainput;
		boolean codExists=false, fechaVal;
		
		sc=new Scanner(System.in);
		
		//creación de empleados. Sí hay menos de 2 se pregunta el código automáticamente. Sí hay más de 2, se pregunta al usuario si quiere añadir
		for (int i = 0; i < emple.length; i++) {
			if (emplecount<2) {
				altaEmple(i);
				emplecount++;
			}
			else {
				try {
					System.out.println("Quieres añadir otro empleado?\n0-no\n1-sí");
					op=sc.nextInt();
					sc.nextLine();
					
					if (op==1) {
						altaEmple(i);
						emplecount++;
					}
					else {
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Anota 0 o 1");
					sc.nextLine();
					continue;
				}
			}
		}
				
		//menú
		do {
			try {
				System.out.println("1-Llegada cliente\n2-Asignar empleado\n3-Finalizar arreglo\n4-Ordenar el array\n5-Actualizar precio de arreglos normales"
						+ "\n6-Salir");
				op=sc.nextInt();
				
				switch (op) {
				case 1:
					if (nowArreglos<arr.length) {
						arr[nowArreglos]=altaArreglo();
						
						nowArreglos++; //contador de arreglos dentro del array
					}
					break;
					
				case 2:
					int posEmple;
					sc.nextLine(); //limpiar buffer
					
					System.out.println("Anota el código del empleado");
					codinput=sc.next();
					
					for (posEmple = 0; posEmple < emplecount; posEmple++) {
						if (emple[posEmple].getCod().equalsIgnoreCase(codinput)) {
							codExists=true;
							break;
						}
						else {
							codExists=false;
						}
					}
					
					if (codExists==true) {
						try {
							pos=buscarUrgente();
							
							arr[pos].setCodEmple(codinput);
							
							emple[posEmple].addAssigned();
						} catch (NoHayPendientesException e) {
							System.out.println(e.getMessage());
						}
					}
					else {
						System.out.println("Empleado no encontrado");
					}
					
					break;
					
				case 3:
					System.out.println("Número de arreglo: ");
					op=sc.nextInt();
					
					try {
						pos=buscarArreglos(op);
						
						if (arr[pos].isFinalizado()) {
							throw new ArregloYaFinalizadoException("Arreglo ya está finalizado");
						}
						else if (arr[pos].getCodEmple()==null) {
							throw new ArregloNoInicializadoException("Arreglo no está inicializado");
						}
						
						if (arr[pos] instanceof Normal) {
							System.out.println("Minútos usados en repararlo");
							op=sc.nextInt();
							
							((Normal) arr[pos]).setMins(op);
							System.out.println(arr[pos].finalizar());
						}
						else if (arr[pos] instanceof Garantia) {
							System.out.println(arr[pos].finalizar());
						}
						else if (arr[pos] instanceof Urgente) {
							sc.nextLine(); //limpiar buffer
							do {
								fechaVal=true;
								System.out.println("Fecha al terminar con formato yyyy-mm-dd");
								fechainput=sc.nextLine();
								try {
									((Urgente) arr[pos]).setFechafin(LocalDate.parse(fechainput));
									System.out.println(arr[pos].finalizar());
								} catch (DateTimeParseException e) {
									fechaVal=false;
									System.out.println("Formato incorrecto o fecha inválido");
								}
							} while (fechaVal==false);
							
						}
						
						for (int j = 0; j < emplecount; j++) {
							if (emple[j].getCod().equalsIgnoreCase(arr[pos].getCodEmple())) {
								emple[j].addFinished();
							}
						}

						
					} catch (ArregloNoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (ArregloYaFinalizadoException e) {
						System.out.println(e.getMessage());
					} catch (ArregloNoInicializadoException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 4:
					ordenar();
					
					//mostrar para ver está bien ordenado
					for (int i = 0; i < nowArreglos; i++) {
						System.out.println(arr[i].getClass().getSimpleName()+" "+arr[i].toString());
					}
					
					break;
					
				case 5:
					for (int i = 0; i < nowArreglos; i++) {
						if (arr[i]instanceof Normal && arr[i].isFinalizado()==true && arr[i].importe<=10) {
							((Normal)arr[i]).changeMinimo();
						}
					}
					
					//mostrar para ver si se ha cambiado bien

					for (int i = 0; i < nowArreglos; i++) {
						System.out.println(arr[i].getClass().getSimpleName()+" "+arr[i].toString());
					}
					
					break;
					
				case 6:
					break;

				default:
					System.out.println("Anota números entre 1 y 6");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Anota un número");
				sc.nextLine();
			}
		} while (op!=6);
		
		for (int i = 0; i < emplecount; i++) {
			System.out.println(emple[i].toString());
		}
		
		System.out.println("Hay "+Normal.getCountType()+" arreglos normales, "+Garantia.getCountType()+" de garantias y "+Urgente.getCountType()+" arreglos urgentes");
		
	}
	
	public static void altaEmple(int i) {
		String cod;
		boolean codVal;
		
		do {
			System.out.println("Anota código de empleado con formato Xnnn (X=Letra mayús n=1 a 3 dígitos)");
			cod=sc.nextLine();
			codVal=validarCod(cod);
			if (codVal==false) {
				System.out.println("Formato de código incorrecto");
			}
		} while (codVal==false);
		
		emple[i]=new Empleados (cod);
		
	}
	
	public static boolean validarCod(String cod) {
		if (cod.length()>4 || cod.length()<2) {
			return false;
		}
		if (cod.charAt(0)>='A' && cod.charAt(0)<='Z') {
			try {
				Integer.parseInt(cod.substring(1));
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return false;
	}
	
	public static Arreglos altaArreglo() {
		Arreglos a = null;
		String fechaentrega;
		boolean fechaVal;
		LocalDate fechaConvertida;
		
		System.out.println("Tipo de arreglo: \n1-normal\n2-garantia\n3-urgente");
		op=sc.nextInt();
		sc.nextLine();
		
		switch (op) {
		case 1:
			a = new Normal();
			break;
			
		case 2:
			a = new Garantia();
			break;
			
		case 3:
			do {
				fechaVal=true;
				System.out.println("Con un formato yyyy-mm-dd, anota la fecha de entrega");
				fechaentrega=sc.nextLine();
				try {
					fechaConvertida=LocalDate.parse(fechaentrega);
					a = new Urgente(fechaConvertida);
				} catch (DateTimeParseException e) {
					fechaVal=false;
					System.out.println("Formato incorrecto o fecha inválido");
				}
			} while (fechaVal==false);
			break;
		}
		return a;
	}
	
	public static int buscarUrgente() throws NoHayPendientesException{
		for (int i = 0; i < nowArreglos; i++) {
			if (arr[i].getClass().getSimpleName().equalsIgnoreCase("Urgente") && arr[i].isFinalizado()==false && arr[i].getCodEmple()==null) {
				return i;
			}
		}
		try {
			int pos=buscarPendiente();
			return pos;
		} catch (NoHayPendientesException e) {
			throw new NoHayPendientesException("No hay arreglos pendientes");
		}
	}
	
	public static int buscarPendiente() throws NoHayPendientesException{
		for (int i = 0; i < nowArreglos; i++) {
			if (arr[i].isFinalizado()==false && arr[i].getCodEmple()==null) {
				return i;
			}
		}
		throw new NoHayPendientesException("No hay arreglos pendientes");
	}
	
	public static int buscarArreglos(int op) throws ArregloNoEncontradoException{
		int i;
		
		for (i = 0; i < nowArreglos; i++) {
			if (op==arr[i].getNumArreglo()) {
				return i;
			}
		}
		throw new ArregloNoEncontradoException("Arreglo no encontrado");
	}
	
	public static void ordenar() {
		Arreglos aux;
		int j, k;
		for (j = 1; j < nowArreglos; j++) {
			for (k = 0; k < nowArreglos - j ; k++) {
				if (arr[k].isFinalizado()==true) {
					aux=arr[k];
					arr[k]=arr[k+1];
					arr[k+1]=aux;
				}
			}
		}
	}
	
}
