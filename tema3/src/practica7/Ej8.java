package practica7;

import java.util.Scanner;

public class Ej8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int d, m, y;
		boolean continuar=false;
		char cont;
		
		do {
			System.out.println("Fecha de nacimiento");
			System.out.println("Día: ");
			d=sc.nextInt();
			System.out.println("Mes: ");
			m=sc.nextInt();
			System.out.println("Año: ");
			y=sc.nextInt();
			
			lucknum(d, m, y);
			
			System.out.println("Quiere continuar? S=sí N=no");
			cont=sc.next().charAt(0);
			cont=Character.toUpperCase(cont);
			
			if (cont=='N') {
				continuar=false;
			}
		} while (continuar==true);
		
		System.out.println("Fin del programa");
	}

	public static void lucknum(int d, int m, int y) {
		int total;
		int div1;
		int div2;
		int div3;
		int div4;
		int luckynum;
		total=d+m+y;
		
		div1=total/1000;
		div2=(total%1000)/100;
		div3=((total%1000)%100)/10;
		div4=((total%1000)%100)%10;
		luckynum=div1+div2+div3+div4;
		
		if (luckynum/10!=0) {
			int div5=luckynum/10;
			int div6=luckynum%10;
			luckynum=div5+div6;
		}
		
		System.out.println("Su lucky number es el "+luckynum);
	}
		
}
