package ej1;

public class Repartidor {
	private int id,nPedidos;
	private double ganancias;
	private static int totalPedidos;
	
	
	public Repartidor(int id) {
		this.id = id;
	}
	

	public int getId() {
		return this.id;
	}
	
	public double getGanancias() {
		return this.ganancias;
	}
	
	public int getnPedidos() {
		return this.nPedidos;
	}
	
	public static int getTotalPedidos() {
		return totalPedidos;
	}
	
	public void realizarPedido(double importe,double propinas) {
		totalPedidos++;
		nPedidos++;
		ganancias+=importe*0.2+propinas;
	}

	@Override
	public String toString() {
		return "Repartidor [id=" + id + ", nPedidos=" + nPedidos + ", ganancias=" + ganancias + "]";
	}
	
	
	
	
	
}