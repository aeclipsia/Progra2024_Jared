package practica3;

import java.util.*;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		final double fijo=2,price100=0.5,price150=0.7,price=1;
		double valant,valact,pago;
		
		//Input de contador
		System.out.println("Valor anterior del contador: ");
		valant=sc.nextDouble();
		
		System.out.println("Valor actual del contador: ");
		valact=sc.nextDouble();
		
		double consumo=valact-valant,div1,div2;
		
		//division de consumo
		if (consumo>=250) {
			div1=consumo-250;
				pago=2+0.5*100+0.7*150+1*div1;
				System.out.printf("Tienes que pagar %.2f euros",pago);
		}
		else if (consumo>100 && consumo<250) {
			div2=consumo-100;
				pago=2+0.5*100+0.7*div2;
				System.out.printf("Tienes que pagar %.2f euros",pago);
		}
		else {
			pago=2+0.5*consumo;
			System.out.printf("Tienes que pagar %.2f euros",pago);
		}
	}
}
