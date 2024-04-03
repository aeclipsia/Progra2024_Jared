package practica4;

import java.util.*;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		//segundos a horas, minutos y segundos
		int ini,s,m,h;
		
		System.out.println("Escribe los segundos transcurridos: ");
		ini=sc.nextInt();
		
		//operaciones
		h=ini/3600;
		m=(ini%3600)/60;
		s=(ini%3600)%60;
		
		System.out.println(h+" horas, "+m+" minutos y "+s+" segundos.");
		System.out.printf("Son %02d:%02d:%02d horas\n", h,m,s);
		
		//horas, minutos y segundos a segundos
		
		int input,seg,min,hr,output;
		
		System.out.println("Hora: ");
		hr=sc.nextInt();
		
		System.out.println("Minutos: ");
		min=sc.nextInt();
		
		System.out.println("Segundos: ");
		seg=sc.nextInt();
		
		//operaciones
		
		output=hr*3600+min*60+seg;
		System.out.println("Son "+output+" segundos.");
	}

}
