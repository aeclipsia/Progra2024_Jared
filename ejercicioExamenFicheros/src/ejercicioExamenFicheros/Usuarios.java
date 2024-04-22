package ejercicioExamenFicheros;

public class Usuarios implements Comparable <Usuarios>{

	private String codigo;
	private int minutos;
	
	public Usuarios(String codigo) {
		super();
		this.codigo = codigo;
		this.minutos = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public void addMinutos(int minutos) {
		this.minutos+=minutos;
	}

	@Override
	public String toString() {
		return "Usuarios [codigo=" + codigo + ", minutos=" + minutos + "]";
	}
	
	public int compareTo(Usuarios u) {
		if (u.minutos>this.minutos) {
			return 1;
		}
		else if (u.minutos<this.minutos) {
			return -1;
		}
		else {
			return (this.codigo.compareToIgnoreCase(u.codigo));
		}
	}
	
	
	
}
