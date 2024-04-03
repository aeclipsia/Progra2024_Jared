package practica3;

import java.util.*;

public class Ej9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		int h,m,s;
		
		//Input
		System.out.println("Anota las horas");
		h=sc.nextInt();
		
		System.out.println("Anota los minutos");
		m=sc.nextInt();

		System.out.println("Anota los segundos");
		s=sc.nextInt();

		if (s>=59) {
			if (m>=59 && h>=23){
				h=00;
				m=00;
				s=00;
				System.out.printf("%02d:%02d:%02d horas",h,m,s);
			}
			else if (m>=59) {
				h=h+1;
				m=0;
				s=0;
				System.out.printf("%02d:%02d:%02d horas",h,m,s);
			}
			else {
				m=m+1;
				s=0;
				System.out.printf("%02d:%02d:%02d horas",h,m,s);
			}
		}
		else  {
			s=s+1;
			System.out.printf("%02d:%02d:%02d horas",h,m,s);
		}
		
	}

}
