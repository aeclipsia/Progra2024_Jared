package practicaString;

import java.util.*;

public class Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String pais;
		int count=0;
		char ini,con;
		boolean cont=true;
		
		System.out.println("anota la letra");
		ini=sc.nextLine().charAt(0);
		ini=Character.toUpperCase(ini);
		
		do {
			
			System.out.println("anota un pais europeo");
			pais=sc.nextLine();
			pais=pais.toUpperCase();
			
			if (pais.charAt(0)==ini) {
				count=count+1;
			}
			
			System.out.println("Quieres continuar? S=sí N=no");
			con=sc.nextLine().charAt(0);
			con=Character.toUpperCase(con);
			
			if (con=='N') {
				cont=false;
			}
		} while (cont==true);
		
		System.out.println(count+" pais europeos que empieza con "+ini);
	}

}
