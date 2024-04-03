package practica3;

import java.util.*;

public class Ej11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int codigo;
		
		
		System.out.println("Código: ");
		codigo=sc.nextInt();
		
		int prov=codigo/1000;
		int tipo=(codigo%1000)/100;
		int num1=((codigo%1000)%100)/10;
		int num2=((codigo%1000)%100)%10;
		
		if (codigo>9999) {
			System.out.println("CÓDIGO NO VÁLIDO");
		}
		
		System.out.println("PROVINCIA: "+prov);
		System.out.println("TIPO DE OPERACIÓN: " +tipo);
		System.out.println("NÚMERO DE OPERACIÓN: "+num1+""+num2);
	}

}
