package practica5;

import java.util.*;

public class Ej8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int emple,mas1k=0;
		double salario;
		
		for (emple = 1; emple <= 10; emple++) {
			System.out.println("Introduce el salario del empleado "+emple+".");
			salario=sc.nextDouble();
			if (salario>=1000) {
				mas1k=mas1k+1;
			}
		}
		System.out.println(mas1k+" empleados ganan más de 1000 euros.");
	}

}
