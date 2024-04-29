package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import colegio.*;
import modelos.Alumno;
import modelos.Curso;

public class BD_Colegio extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Colegio(String file){
		super(file);
	}
	
	public  int añadir_Alumno( Alumno al) throws ErrorBaseDatos{	
		String cadenaSQL="INSERT INTO alumnos VALUES('" + al.getNombre() + "','" +
		al.getDni()+"','"+ al.getTelenono() +"',"+ al.getMatricula()+",'"+
				al.getCurso()+"','"+al.getFechaMatricula()+"')"; 	
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){			
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}
	
	public  int borrar_Alumno(int mat) throws ErrorBaseDatos{	
		String cadenaSQL="DELETE FROM alumnos WHERE matricula='"+mat+"'"; 	
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){			
			throw new ErrorBaseDatos("No se puede borrar");
		}
	}
	
	public  int añadir_Curso(Curso cur) throws ErrorBaseDatos{	
		String cadenaSQL="INSERT INTO cursos VALUES('" + cur.getCurso() + "','" +
		cur.getDescripcion()+"','"+ cur.getAula() +"')"; 	
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){			
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}
	
	public  Vector<Alumno> listadoAlumnosCurso(String curso) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from alumnos WHERE curso='"+curso+"'";
		Vector<Alumno> listaCursos=new Vector<Alumno>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fechaMatricula");
				LocalDate fBuena=f.toLocalDate();
				listaCursos.add(new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),fBuena));
				
			}
			s.close();
			this.cerrar();
			return listaCursos;
		}
		catch ( SQLException e){		
			throw new ErrorBaseDatos("Listando alumnos curso");	
		}
	}
	
	
	public  Vector<String> listadoCursos() throws ErrorBaseDatos{
		String cadenaSQL="SELECT curso from cursos";
		Vector<String> listaCursos=new Vector<String>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaCursos.add(reg.getString(1));
			}			
			s.close();
			this.cerrar();
			return listaCursos;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new ErrorBaseDatos("Listando cursos");
			
		}
	}
	
	public  void listadoAlumnosPorCurso() throws ErrorBaseDatos{
		String cadenaSQL="SELECT curso from cursos";
	    String curso="";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				curso=reg.getString(1);
				System.out.println("CURSO:"+curso);
				Statement s2=c.createStatement();
				ResultSet reg2=s2.executeQuery("select nombre from alumnos where curso='"+curso+"'");
				while ( reg2.next()){
					System.out.println("\t"+reg2.getString(1));
				}			
				s2.close();
			}			
			s.close();
			this.cerrar();
			return;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			throw new ErrorBaseDatos("Listando cursos");
			
		}
	}
	
}
