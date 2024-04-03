package buenojaredjameslloyd2;

public class Tarjeta {

	private int numTarj, mm, yy, ope;
	private static int opetotal;
	private double saldo;
	private String titular, pswd;
	private boolean block;
	
	//constructor
	public Tarjeta(int numTarj, String pswd, int mm, int yy, double saldo, String titular) {
		super();
		this.numTarj = numTarj;
		this.pswd = pswd;
		this.mm = mm;
		this.yy = yy;
		this.saldo = saldo;
		this.titular = titular;
		this.block = false;
		this.ope = 0;
	}
	
	//pagar
	public void Pagar(String pswd, int mm, int yy, double pago) {
		if (block==true) {
			System.err.println("Pago rechazado, tarjeta bloqueada");
		}
		else {
			if (!this.pswd.equals(pswd)) {
				System.err.println("Contraseña incorrecta");
			}
			else {
				if (yy>this.yy) {
					System.err.println("Tarjeta caducada");
				}
				else if (yy==this.yy) {
					if (mm>this.mm) {
						System.err.println("Tarjeta caducada");
					}
					else {
						if (this.saldo-pago>=0) {
							this.saldo=this.saldo-pago;
							System.out.println("Pago aceptado, nuevo saldo: "+this.saldo);
							ope=ope+1;
						}
						else {
							System.err.println("Operación rechazada, saldo insuficiente");
						}
					}
				}
				else {
					if (this.saldo-pago>=0) {
						this.saldo=this.saldo-pago;
						System.out.println("Pago aceptado, nuevo saldo: "+this.saldo);
						ope=ope+1;
					}
					else {
						System.err.println("Operación rechazada, saldo insuficiente");
					}
				}
			}
		}
	}
	
	//recargar
	public void Recargar(double ingreso) {
		this.saldo=this.saldo+ingreso;
		System.out.println("Has ingresado "+ingreso);
		System.out.println("Nuevo saldo: "+this.saldo);
		ope=ope+1;
	}
	
	//bloqueo
	public void Bloqueo(boolean block) {
		if (block==true) {
			System.out.println("Tarjeta bloqueada");
			this.block=true;
		}
		else {
			System.out.println("Tarjeta desbloqueada");
			this.block=false;
		}
	}



	//info
	public String toString() {
		return "Número de tarjeta: "+numTarj+", Titular: "+titular+", Saldo: "+saldo+", Contraseña: ****, Fecha de validez: "+mm+"/"+yy;
	}
	
	//misma tarjeta
	public static void mismaTarjeta(Tarjeta tar1, Tarjeta tar2) {
		if ((tar1.numTarj==tar2.numTarj) && (tar1.titular.equals(tar2.titular))) {
			System.out.println("Son las mismas tarjetas");
		}
		else {
			System.out.println("No son las mismas tarjetas");
		}
	}
	
	//operaciones
	public static void opeTotal(Tarjeta tar1, Tarjeta tar2) {
		opetotal=tar1.ope+tar2.ope;
		System.out.println("Se han realizado "+tar1.ope+" operaciones en la primera tarjeta y "+tar2.ope+" operaciones en la segunda.");
		System.out.println("En total se ha realizado "+opetotal+" operaciones entre todas las tarjetas.");
	}
}
