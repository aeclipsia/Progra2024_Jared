package buenojaredjameslloyd2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tarjeta tar1 = new Tarjeta(6102, "0123", 11, 23, 1000, "Cristiano Ronaldo");
		Tarjeta tar2 = new Tarjeta(2537, "7777", 1, 25, 12000, "Lionel Messi");
		
		//Cristiano Ronaldo va a pagar pero pone mal la contraseña
		tar1.Pagar("0124", 11, 23, 800);
		System.out.println(tar1.toString());
		
		//Lionel Messi va a pagar
		tar2.Pagar("7777", 12, 24, 10000);
		System.out.println(tar2.toString());
		
		//Lionel Messi bloquea su tarjeta
		tar2.Bloqueo(true);
		
		//Cristiano Ronaldo va a pagar
		tar1.Pagar("0123", 11, 23, 800);
		System.out.println(tar1.toString());
		
		//Ronaldo bloquea su tarjeta
		tar1.Bloqueo(true);
		
		//Ronaldo intenta pagar con su tarjeta bloqueada
		tar1.Pagar("0123", 2, 23, 10);
		
		//Ronaldo desbloquea su tarjeta y reintenta pagar
		tar1.Bloqueo(false);
		tar1.Pagar("0123", 2, 23, 10);
		
		//Lionel Messi va a pagar pero tiene la tarjeta bloqueada
		tar2.Pagar("7777", 1, 24, 500);
		
		//Lionel Messi desbloquea su tarjeta y reintenta pagar
		tar2.Bloqueo(false);
		tar2.Pagar("7777", 1, 24, 500);
		System.out.println(tar2.toString());
		
		//Cristiano Ronaldo va a comprar pero no tiene suficiente saldo en la tarjeta
		tar1.Pagar("0123", 10, 23, 400);
		
		//Lionel Messi ingresa en su cuenta 100 000 euros
		tar2.Recargar(100000);
		
		//Tienen la misma tarjeta?
		Tarjeta.mismaTarjeta(tar1, tar2);
		
		//Messi tiene otra tarjeta, es la misma?
		Tarjeta tar3 = new Tarjeta(2537, "7777", 1, 25, 120, "Lionel Messi");
		Tarjeta.mismaTarjeta(tar2, tar3);
		
		//Cuantas operaciones se ha realizado con la tarjeta de Ronaldo y de Messi?
		Tarjeta.opeTotal(tar1, tar2);
	}

}
