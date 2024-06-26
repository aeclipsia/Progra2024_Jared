package ejercicio2;

import java.time.LocalDate;
import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static ArrayList<Caducable> arr=new ArrayList<Caducable>();
	
	public static void main(String[] args) {

		arr.add(new Carnet(LocalDate.of(2025, 10, 13)));
		arr.add(new Medicamento(LocalDate.of(2024, 04, 01)));
		arr.add(new Carnet(LocalDate.of(2024, 03, 31)));
		arr.add(new Medicamento(LocalDate.of(2024, 04, 06)));
		
		for (Caducable i : arr) {
			System.out.println("Caducado? "+i.isCaducado());
			System.out.println("Días: "+i.diasParaCaducado());
		}
		
	}

}
