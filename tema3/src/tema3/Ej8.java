package tema3;

import java.util.*;

public class Ej8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		System.out.println("Anota tu peso en kg: ");
		double peso=sc.nextDouble();
		
		System.out.println("Anota tu altura en m: ");
		double altura=sc.nextDouble();
		
		double IMC=peso/(altura*altura);
		System.out.println(IMC);
		
		if (IMC<16) 
			System.out.println("Criterio de ingresar en el hospital");
			else 
				if (IMC<=17 && IMC>=16) 
				System.out.println("Infrapeso");
				else 
					if (IMC>17 && IMC<=18) 
					System.out.println("Bajo peso");
						else 
							if (IMC>18 && IMC<=25) 
							System.out.println("Peso normal (saludable)");
								else 
									if (IMC>25 && IMC<=30) 
									System.out.println("Obesidad de Grado I");
										else 
											if (IMC>30 && IMC<=35) 
											System.out.println("Sobrepeso crónico (Obesidad de Grado II)");
												else 
													if (IMC>35 && IMC<=40) 
													System.out.println("Obesidad premórbida (Obesidad de Grado III)");
														else 
															if (IMC>40) 
															System.out.println("Obesidad mórbida (Obesidad de Grado IV)");
	}
}
