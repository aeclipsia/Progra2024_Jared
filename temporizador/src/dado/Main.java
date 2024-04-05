package dado;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		/* Simular durante <tiempo> el lanzamiento de un dado, pasado ese
		 * tiempo mostrar la cantidad de seises que han salido */

		Timer time = new Timer();
		Dado dado = new Dado();
		
		time.schedule(dado,0,500);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		time.cancel();
		System.out.println("Ha salido el seis "+dado.getCount()+" veces.");
	}

}
