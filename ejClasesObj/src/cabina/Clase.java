package cabina;

public class Clase {

	private int numCab;
	private static int contA,contC,contM;
	private double precio, recauT;
	private static boolean abierto=true;
	
	public Clase(int numCab) {
		this.numCab = numCab;
	}
	
	public void pagarVehiculo(char v, int km) {
		char vehiculo=Character.toUpperCase(v);
		
		if (abierto==true) {
			switch (vehiculo) {
			case 'A':
				contA=contA+1;
				precio=0.2*km;
				System.out.println("Precio: "+precio);
				break;
				
			case 'M':
				contM=contM+1;
				precio=0.1*km;
				System.out.println("Precio: "+precio);
				break;
				
			case 'C':
				contC=contC+1;
				precio=5;
				System.out.println("Precio: "+precio);
				break;

			default:
				System.err.println("Error");
				break;
			}
			recauT=recauT+precio;
		}
		else {
			System.err.println("Cabina cerrada");
		}
	}
	
	public boolean abrirCabina(int a) {
		if (a==0) {
			abierto=false;
		}
		else if (a==1) {
			abierto=true;
		} 
		else {
			
		}
		return abierto;
	}
	
	public static void whichCabina(Clase a, Clase b) {
		int countA, countB;
		
		if (a.abierto==true) {
			countA=1;
			System.out.println("Cabina 1 abierto");
		}
		else {
			countA=0;
			System.out.println("Cabina 1 cerrado");
		}
		
		if (b.abierto==true) {
			countB=1;
			System.out.println("Cabina 2 abierto");
		}
		else {
			countB=0;
			System.out.println("Cabina 2 cerrado");
		}
		int countCabina=countA+countB;
		System.out.println("Se encuentra "+countCabina+" cabina(s) abiertas");
	}
	
	public void recaudadoTotal() {
		System.out.println("Total recaudado por la cabina "+recauT);
	}

	@Override
	public String toString() {
		if (abierto==true) {
			return "Cabina "+numCab+" está abierta";
		}
		else {
			return "Cabina "+numCab+" está cerrada";
		}
	}
	
	public String info() {
		return "En la cabina "+numCab+" ha pasado "+contA+" automóviles, "+contC+" camiones y "+contM+" motos";
	}
	
	public static void mayorTrafico(Clase a, Clase b, char v) {
		char vehiculo=Character.toLowerCase(v);
		
		switch (vehiculo) {
		case 'a':
			if (a.contA>b.contA) {
				System.out.println("En la cabina 1 ha pasado más automóviles que en la cabina 2.");
			}
			else {
				System.out.println("En la cabina 2 ha pasado más automóviles que en la cabina 1.");
			}
			break;
			
		case 'c':
			if (a.contC>b.contC) {
				System.out.println("En la cabina 1 ha pasado más camiones que en la cabina 2.");
			}
			else {
				System.out.println("En la cabina 2 ha pasado más camiones que en la cabina 1.");
			}
			break;
			
		case 'm':
			if (a.contM>b.contM) {
				System.out.println("En la cabina 1 ha pasado más motos que en la cabina 2.");
			}
			else {
				System.out.println("En la cabina 2 ha pasado más motos que en la cabina 1.");
			}
			break;

		default:
			break;
		}
	}
	
}
