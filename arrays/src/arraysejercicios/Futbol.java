package arraysejercicios;

public class Futbol {

	private String equipo;
	private int victorias, derrotas, gEquipo, gOponente, puntos;
	
	
	public Futbol(String equipo) {
		super();
		this.equipo = equipo;
		this.victorias = victorias;
		this.derrotas = derrotas;
		this.gEquipo = gEquipo;
		this.gOponente = gOponente;
		this.puntos = puntos;
	}
	
	public static void Partido(Futbol equipo1, Futbol equipo2, int gol1, int gol2){
		equipo1.gEquipo+=gol1;
		equipo1.gOponente+=gol2;
		equipo2.gEquipo+=gol2;
		equipo2.gOponente+=gol1;
		
		if (gol1>gol2) {
			equipo1.victorias++;
			equipo2.derrotas++;
			equipo1.puntos=equipo1.puntos+3;
		}
		else if (gol1<gol2) {
			equipo2.victorias++;
			equipo1.derrotas++;
			equipo2.puntos=equipo2.puntos+3;
		}
		else if (gol1==gol2) {
			equipo1.puntos=equipo1.puntos+1;
			equipo2.puntos=equipo2.puntos+1;
		}
	}
	
	public String getEquipo() {
		return equipo;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String toString() {
		return equipo+"--- W: "+victorias+" L: "+derrotas+" Goles a favor: "+gEquipo+" Goles en contra: "+gOponente+" Puntos: "+puntos;
	}
	
	
		
}
