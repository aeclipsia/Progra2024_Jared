package cabina;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Clase cab1=new Clase(1);
		Clase cab2=new Clase(2);
		
		//se muestra las cabinas abiertas
		Clase.whichCabina(cab1, cab2);
		//entra el primer vehículo
		cab1.pagarVehiculo('A', 45);
		//se cierra la cabina 1
		cab1.abrirCabina(0);
		System.out.println(cab1.toString());
		//el segundo vehículo intenta entrar
		cab1.pagarVehiculo('M', 37);
		//se abre la cabina 1
		cab1.abrirCabina(1);
		System.out.println(cab1.toString());
		//entra el tercer vehiculo
		cab1.pagarVehiculo('C', 52);
		//total recaudado por la cabina 1
		cab1.recaudadoTotal();
		
		
		//entra 2 vehículos en la cabina 2
		cab2.pagarVehiculo('m', 10);
		cab2.pagarVehiculo('a', 20);
		//se cierra la cabina 2
		cab2.abrirCabina(0);
		System.out.println(cab2.toString());
		//el tercer vehículo intenta entrar
		cab2.pagarVehiculo('A', 51);
		
		//total recaudado por la cabina 2
		cab2.recaudadoTotal();
		
		//pedir info
		System.out.println(cab1.info());
		System.out.println(cab2.info());
		
		//en cual de las dos cabinas han pasado más vehículos
		Clase.mayorTrafico(cab1, cab2, 'a');
		Clase.mayorTrafico(cab1, cab2, 'm');
		Clase.mayorTrafico(cab1, cab2, 'c');
	}

}
