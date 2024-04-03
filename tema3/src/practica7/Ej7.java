package practica7;

import java.util.*;

public class Ej7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int d,plus,total,count=0,rest=0;
		String mes;
		
		System.out.println("Anota el número");
		d=sc.nextInt();
				
		total=d;
		
		for (int m = 1; m <=12; m++) {	
			plus=diaMes(m);	
			
			if (total<=plus) {
				rest=total;
				break;
			}	
						
			total=total-plus;
			count=count+1;			
		}
		
		mes=charMes(count+1);
		
		System.out.println(rest+" de "+mes);
	}
	public static int diaMes(int m) {
		int d=0;
		
		if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
			d=31;
		}
		else if (m==2) {
			d=28;
		}
		else {
			d=30;
		}
		
		return d;
	}
	
	public static String charMes(int m) {
		String mes="Error";
		
		switch (m) {
		case 1:
			mes="Enero";
			break;

		case 2:
			mes="Febrero";
			break;
			
		case 3:
			mes="Marzo";
			break;
			
		case 4:
			mes="Abril";
			break;
			
		case 5:
			mes="Mayo";
			break;
			
		case 6:
			mes="Junio";
			break;
			
		case 7:
			mes="Julio";
			break;
			
		case 8:
			mes="Agosto";
			break;
			
		case 9:
			mes="Septiembre";
			break;
			
		case 10:
			mes="Octubre";
			break;
			
		case 11:
			mes="Noviembre";
			break;
			
		case 12:
			mes="Diciembre";
			break;
		}
		return mes;
	}
	
}