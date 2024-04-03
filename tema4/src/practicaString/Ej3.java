package practicaString;

import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String nombre, apellido, codAp;
		char codNom, con;
		boolean cont=true;
		
		do {
			System.out.println("Anota el nombre");
			nombre=sc.nextLine();
			
			codNom=codNombre(nombre);
			codNom=Character.toUpperCase(codNom);
			
			System.out.println("Anota el primer apellido");
			apellido=sc.nextLine();
			
			codAp=codApellido(apellido);
			codAp=codAp.toUpperCase();
			
			System.out.println(codNom+"-"+codAp);
			
			System.out.println("Continua?");
			System.out.println("S = sí");
			System.out.println("N = no");
			con=sc.nextLine().charAt(0);
			con=Character.toUpperCase(con);
			
			if (con=='N') {
				cont=false;
			}
		} while (cont==true);
		
		System.out.println("Fin del programa");
	}
	
	
	public static char codNombre(String nombre) {
		char codNom;
		
		codNom=nombre.charAt(0);
		
		return codNom;
	}
	
	public static String codApellido(String apellido) {
		Scanner type = new Scanner(System.in);
		
		String codAp, seg;
			if (apellido.length()<3) {
				System.out.println("Anota el segundo apellido");
				seg=type.nextLine();
				
				if (seg.length()<3) {
					if (apellido.length()>=seg.length()) {
						codAp=apellido;
					}
					else {
						codAp=seg;
					}
				}
				else {
					codAp=seg.substring(0,3);
				}
			}
			else {
				codAp=apellido.substring(0,3);
			}
		return codAp;
	}

}
