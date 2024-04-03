package practica5;

import java.util.*;

public class Ej16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int cod=1,count=0;
		double ventaenl, precioporl;
		
		for (cod = 1; cod < 6; cod++) {
			
			System.out.println("Para el artículo "+cod+", cuántos litros has vendido?");
			ventaenl=sc.nextDouble();
			
			System.out.println("Cuánto vale por litro?");
			precioporl=sc.nextDouble();
			
			if (cod==1) {
				System.out.println("Litros vendidos del artículo 1: "+ventaenl);
			}
			
			double pay=ventaenl*precioporl;
			System.out.println("Facturación total: "+pay);
				
			if (pay>600) {
				count=count+1;
			}
		}
		
		System.out.println("Se emitieron "+count+" facturas de más de 600 euros");
	}

}
