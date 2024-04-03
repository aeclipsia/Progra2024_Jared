package ejercicio4;

public class Videojuegos implements Prestable{

	private String title, genre, publisher;
	private int estH;
	private boolean prestado;
	private static double total;
	
	
	public Videojuegos(String title, String genre, String publisher, int estH) {
		super();
		this.title = title;
		this.genre = genre;
		this.publisher = publisher;
		this.estH = estH;
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
		return "Tipo: Videojuego | Título: "+title+" | Género: "+genre+" | Compañía: "+publisher+" | Horas estimadas: "+estH+" | Prestado: "+prestado;
	}
	
	@Override
	public void prestar() {
		this.prestado=true;
		
	}
	
	@Override
	public void devolver() {
		this.prestado=false;
		total+=this.estH*0.5;
	}

	@Override
	public boolean isEntregado() {
		return prestado;
	}

}
