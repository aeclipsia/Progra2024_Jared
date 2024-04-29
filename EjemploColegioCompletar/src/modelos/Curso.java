package modelos;

public class Curso {

	private String descripcion;
	private String curso;
	private String aula;
	
	public Curso(String descripcion, String curso, String aula) {
		super();
		this.descripcion = descripcion;
		this.curso = curso;
		this.aula = aula;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}
	
	
	
	
	
}
