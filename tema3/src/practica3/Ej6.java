package practica3;

import java.util.*;


public class Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		double price,pay,disc;
		
		//Input precio
		System.out.println("¿Cuanto cuesta?");
		price=sc.nextDouble();
		
		if (price<6) {
				pay=price;
				System.out.printf("El artículo vale %.2f",pay);
		}
			else 
				if (price>=6 && price<60) {
					disc=price*0.05;
					pay=price-disc;
					System.out.printf("El artículo vale %.2f",pay);
		}
			else {
					disc=price*0.1;
					pay=price-disc;
					System.out.printf("El artículo vale %.2f",pay);
		}
	}

}
