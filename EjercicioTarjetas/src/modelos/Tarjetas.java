package modelos;

import java.time.*;

public class Tarjetas {

	private int numero, cuenta, bloqueada;
	private String titular, tipo, clave;
	private double limite;
	private LocalDate caducidad;
	
	public Tarjetas(int numero, int cuenta, String titular, String tipo, String clave, double limite) {
		super();
		this.numero = numero;
		this.cuenta = cuenta;
		this.titular = titular;
		this.tipo = tipo;
		this.clave = clave;
		this.limite = limite;
	}

	public Tarjetas(int numero, int cuenta, String titular, double limite, String tipo, LocalDate caducidad, int bloqueada) {
		this.numero = numero;
		this.cuenta = cuenta;
		this.titular = titular;
		this.tipo = tipo;
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "Tarjetas [numero=" + numero + ", cuenta=" + cuenta + ", bloqueada=" + bloqueada + ", titular=" + titular
				+ ", tipo=" + tipo + ", limite=" + limite + ", caducidad=" + caducidad + "]";
	}
	
	
	
}
