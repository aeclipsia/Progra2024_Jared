package practica6;

import java.util.*;

public class Ej8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int d, m, y, total, div1, div2, div3, div4, luckynum;
		
		System.out.println("Fecha de nacimiento");
		System.out.println("Día: ");
		d=sc.nextInt();
		System.out.println("Mes: ");
		m=sc.nextInt();
		System.out.println("Año: ");
		y=sc.nextInt();
		
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
