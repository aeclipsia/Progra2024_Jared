package ejemplosarrays;

import java.util.Scanner;

public class ejemplo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia,mes,año;
		String meses[] = { "enero", "febrero", "marzo" };
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Anota dia:");
			dia = sc.nextInt();
		} while (dia < 1 || dia > 31);
		
		do {
			System.out.println("Anota mes:");
			mes = sc.nextInt();
		}while(mes<1 || mes>12);
		
		do {
			System.out.println("Anota año:");
			año=sc.nextInt();
		}while(año<1000 || año>9999);
		
		System.out.println(dia+ " de "+ meses[mes-1]+" del "+año);

	}

}
