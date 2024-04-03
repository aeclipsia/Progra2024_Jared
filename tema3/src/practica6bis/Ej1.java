package practica6bis;

import java.util.*;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int num,rest,numinv;
		
		System.out.println("Escribe un número");
		num=sc.nextInt();
		
		numinv=0;
		
		do {
			rest=num%10; //System.out.println(rest);
			numinv=numinv*10 + rest; //System.out.println(numinv);
			num=num/10;	//System.out.println(num);
		} while (num!=0);
		
		
		System.out.println(numinv);
	}

}
