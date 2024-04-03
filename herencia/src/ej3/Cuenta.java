package ej3;

public class Cuenta {

	private int num;
	protected String titulares[]=new String [3];
	private static double interest = 0.03;
	private double saldo;
	
	public Cuenta(int num, double saldo, String titulares[]) {
		this.num = num;
		this.saldo = saldo;
		this.titulares = titulares;
		}
	
	
	
}
