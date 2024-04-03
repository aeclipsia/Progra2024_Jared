package ejercicio6;

import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static HashMap<String, Integer> nacionalidades=new HashMap<>();
	static String op;
	public static void main(String[] args) {
		do {
			System.out.println("Anota la nacionalidad");
			op=sc.nextLine();
			op=op.toUpperCase();
			
			if (op.equalsIgnoreCase("fin")) {
				break;
			}
			else if (nacionalidades.containsKey(op)) {
				nacionalidades.replace(op, nacionalidades.get(op)+1);
			}
			else if (!nacionalidades.containsKey(op)){
				nacionalidades.put(op, 1);
			}
		} while (!op.equalsIgnoreCase("fin"));
		
		for (String i : nacionalidades.keySet()) {
			System.out.println("Hay "+nacionalidades.get(i)+" alumnos de "+i);
		}
		
	}

}