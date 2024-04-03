package ejemplosarrays;

import java.util.Arrays;

public class ejemplo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String cadena="12.7$48$13.93$5.8";
		String arraycad[]=cadena.split("\\$");
		double arraydeci[]=new double[arraycad.length];		
		
		for (int i = 0; i < arraycad.length; i++) {
			arraydeci[i]=Double.parseDouble(arraycad[i]);
		}
		
		Arrays.sort(arraydeci);
		
		for (int i = 0; i < arraydeci.length; i++) {
			System.out.print(arraydeci[i]+"\t");
		}
		
	}

}
