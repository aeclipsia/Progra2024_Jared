package practica7;

import java.util.*;

public class Ej6 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int dd=32,mm,yy,sum=0,max;
		char con;
		boolean es30,cont=true;
		
		do {
			System.out.println("Anota el año");
			yy=sc.nextInt();
			
			System.out.println("Anota el mes");
			mm=sc.nextInt();
			if (mm==1 || mm==3 || mm==5 || mm==7 || mm==8 || mm==10 || mm==12) {
				max=31;
				dd = validaDia(sc, max);
			}
			else if (mm==2) {
				if (yy%4==0 || (yy/10)%4==0) {
					max=29;
				}
				else {
					max=28;
				}
				dd = validaDia(sc, max);
			}
			else {
				max=30;
				dd = validaDia(sc, max);
			}
			
			
			for (int i = 1; i <= mm; i++) {
				
				if (i==mm) {
					sum=sum+dd;
				}
				else if (i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) {
					sum=sum+31;
				}
				else if (i==2) {
					if (yy%4==0 || (yy/10)%4==0) {
						sum=sum+29;
					}
					else {
						sum=sum+28;
					}
				}
				else {
					sum=sum+30;
				}
			}
			
			System.out.println(sum+" días");
			
			System.out.println("Quiere continuar? S=sí N=no");
			con=sc.next().charAt(0);
			con=Character.toUpperCase(con);
			
			if (con=='S') {
				cont=true;
			}
			else {
				cont=false;
			}
			
			
		} while (cont==true);
		
	}
		
		

	public static int validaDia(Scanner sc, int max) {
		int dd;
		do {
			System.out.println("Anota el día");
			dd=sc.nextInt();
			
			if (dd>max) {
				System.out.println("Error!");
			}
		} while (dd>max);
		return dd;
	}

}
