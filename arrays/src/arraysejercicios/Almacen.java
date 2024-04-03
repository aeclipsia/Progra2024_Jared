package arraysejercicios;

import arraysejercicios.Almacen;

public class Almacen {

	private String fruta, proc;
	private double kilo,costPerK,sellPerK,benef,precio;
	private static double benefT;
	
	
	public Almacen(String fruta, String proc, double kilo, double costPerK, double sellPerK) {
		super();
		this.fruta = fruta;
		this.proc = proc;
		this.kilo = kilo;
		this.costPerK = costPerK;
		this.sellPerK = sellPerK;
	}
	
	public boolean Rebajar(double newprice) {
		if (this.sellPerK-newprice<=this.costPerK) {
			System.out.println("Error");
			return false;
		}
		else {
			this.sellPerK=this.sellPerK-newprice;	
			return true;
		}
	}
	
	public boolean Vender(double k) {
		if (k>kilo) {
			System.out.println("No hay suficiente cantidad");
			return false;
		}
		else {
			precio=k*sellPerK;
			System.out.println("Precio:"+precio);
			benef=benef+precio;
			benefT+=benef;
			kilo=kilo-k;
			System.out.println("Solo queda "+kilo+" kilos de "+this.fruta);
			return true;
		}
	}
	
	public String getFruta() {
		return fruta;
	}
	
	public String getProc() {
		return proc;
	}	
	public boolean CheckProc(Almacen b) {
		if (this.proc.equalsIgnoreCase(b.proc)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double getKilos() {
		return kilo;
	}
	
	public double getBeneficio() {
		return benef;
	}
	
	public static void getTotal() {
		System.out.println("Beneficio total de la empresa: "+benefT);
	}

	@Override
	public String toString() {
		return kilo+" kilos de "+fruta+" de "+proc+", comprado por "+costPerK+" euros y vendido por "+sellPerK+" euros.";
	}
	
	
	
}
