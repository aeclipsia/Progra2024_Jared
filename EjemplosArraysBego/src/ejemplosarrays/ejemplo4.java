package ejemplosarrays;

import java.util.Locale;
import java.util.Scanner;

public class ejemplo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double temperaturas[] = new double[7];
		String diaBuscar;
		boolean correcto;
		int pos;
		double max, min;
		int posmax, posmin;
		
		max=min=posmax=posmin=0;

		String dias[] = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		for (int i = 0; i < dias.length; i++) {
			System.out.println("Anota temperatura del " + dias[i] + ":");
			temperaturas[i] = sc.nextDouble();

			if (i==0 || temperaturas[i] > max) {
				max = temperaturas[i];
				posmax = i;
			}
			if (i==0 || temperaturas[i] < min) {
				min = temperaturas[i];
				posmin = i;
			}

		}

		System.out.println("La temperatura más alta fue el "+dias[posmax]+" con "+max+" grados");
		System.out.println("La temperatura más baja fue el "+dias[posmin]+" con "+min+" grados");
		
		System.out.println("Temperaturas leidas:");
		for (int i = 0; i < dias.length; i++) {
			System.out.println(dias[i] + ":" + temperaturas[i]);
		}
		sc.nextLine();

		do {
			System.out.println("Anota día para ver su temperatura:");
			diaBuscar = sc.nextLine().toUpperCase();
			pos = validarDia(diaBuscar, dias);
			if (pos == -1)
				System.out.println("Dia incorrecto");

		} while (pos == -1);

		System.out.println("La temperatura fue de:" + temperaturas[pos] + " grados");

	}

	public static int validarDia(String dia, String dias[]) {

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].equalsIgnoreCase(dia)) {
				return i;
			}
		}

		return -1;
	}

}
