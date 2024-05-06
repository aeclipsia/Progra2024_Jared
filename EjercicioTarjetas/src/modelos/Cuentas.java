package modelos;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Cuentas {

	private int num;
	private String titu1, titu2, titu3;
	private double saldo;
	private LocalDate fecha;
	public Cuentas(int num, String titu1, String titu2, String titu3, double saldo, LocalDate fecha) {
		super();
		this.num = num;
		this.titu1 = titu1;
		this.titu2 = titu2;
		this.titu3 = titu3;
		this.saldo = saldo;
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Cuentas [número=" + num + ", titular1=" + titu1 + ", titular2=" + titu2 + ", titular3=" + titu3 + ", saldo=" + saldo
				+ ", fecha=" + fecha + "]";
	}
	
	

}
