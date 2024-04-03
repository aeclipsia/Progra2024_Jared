package practica8;

import java.util.*;

public class Ej4main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		Repartidor rep1=new Repartidor(1111);
		Repartidor rep2=new Repartidor(2222);
		
		rep1.Pedido(40, 2);
		rep1.Pedido(10, 2);
		rep2.Pedido(30, 3);
		
		int pedido1=rep1.getNumPedido();
		int pedido2=rep2.getNumPedido();
		int pedidoT=pedido1+pedido2;
		
		System.out.println("Número total de pedidos: "+pedidoT);
		
		
		System.out.println(rep1.toString());
		System.out.println(rep2.toString());
	}

}
