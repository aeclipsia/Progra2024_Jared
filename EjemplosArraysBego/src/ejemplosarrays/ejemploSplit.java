package ejemplosarrays;

public class ejemploSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String cadena="lunes/martes/miercoles/jueves/viernes/sabado/domingo";
		String resultado[]=cadena.split("/");
		for (int i = 0; i < resultado.length; i++) {
			System.out.println(resultado[i]);
		}
		
	}

}
