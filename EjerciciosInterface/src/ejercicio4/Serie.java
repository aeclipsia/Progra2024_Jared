package ejercicio4;

public class Serie implements Prestable{

	private String title, genre;	
	private int seasons;
	private boolean prestado;
	private static double total;
	
	
	public Serie(String title, String genre, int seasons) {
		super();
		this.title = title;
		this.genre = genre;
		this.seasons = seasons;
		this.prestado = false;
	}
	
	public static double getTotal() {
		return total;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Tipo: Serie | Título: "+title+" | Género: "+genre+" | Nº de temporadas: "+seasons+" | Prestado: "+prestado;
	}

	@Override
	public void prestar() {
		this.prestado=true;
	}
	
	@Override
	public void devolver() {
		this.prestado=false;
		total+=this.seasons*2;
	}

	@Override
	public boolean isEntregado() {
		return prestado;
	}
}
