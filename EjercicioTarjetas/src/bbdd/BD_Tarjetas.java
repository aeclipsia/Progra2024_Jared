package bbdd;
import java.sql.*;
import java.util.*;
import java.time.*;

import modelos.*;
import tarjetas.*;

public class BD_Tarjetas extends BD_Conector{

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Tarjetas(String file){
		super(file);
	}
	
	public ArrayList<Cuentas> buscarCuentas(String dni) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from cuentas WHERE titular1='"+dni+"' or titular2='"+dni+"' or titular3='"+dni+"'";
		ArrayList<Cuentas> listaCuentas=new ArrayList<>();
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while (reg.next()) {
				listaCuentas.add(new Cuentas(reg.getInt("número"),reg.getString("titular1"),reg.getString("titular2"),reg.getString("titular3"),reg.getDouble("saldo"),reg.getDate("fecha").toLocalDate()));
			}
			s.close();
			this.cerrar();
			return listaCuentas;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public boolean buscarCuentas2(int cuenta) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from cuentas WHERE número = '"+cuenta+"'";
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if (reg.next()) {
				return true;
			}
			s.close();
			this.cerrar();
			return false;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public boolean buscarTarjeta(int numT) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from tarjetas WHERE numero = '"+numT+"'";
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if (reg.next()) {
				return true;
			}
			s.close();
			this.cerrar();
			return false;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public int buscarTarjetasMax() throws ErrorBaseDatos{
		String cadenaSQL="SELECT numero from tarjetas";
		int max=Integer.MIN_VALUE;
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while (reg.next()) {
				if (reg.getInt(1)>max) {
					max=reg.getInt(1);
				}
			}
			s.close();
			this.cerrar();
			return max;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public boolean authenticar(int numT,String clave) throws ErrorBaseDatos{
		String cadenaSQL="SELECT clave from tarjetas WHERE numero = '"+numT+"'";
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if (reg.next() && reg.getString(1).equals(clave)) {
				return true;
			}
			s.close();
			this.cerrar();
			return false;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public boolean isDebit(int numT) throws ErrorBaseDatos {
		String cadenaSQL="SELECT tipo from tarjetas WHERE numero = '"+numT+"'";
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if (reg.next() && reg.getString(1).equals("D")) {
				return true;
			}
			s.close();
			this.cerrar();
			return false;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public boolean belowLimit(int numT, double importe) throws ErrorBaseDatos {
		String cadenaSQL="SELECT limite from tarjetas WHERE numero = '"+numT+"'";
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if (reg.next() && (reg.getDouble(1))-importe>=0) {
				return true;
			}
			s.close();
			this.cerrar();
			return false;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public boolean isBlocked(int numT) throws ErrorBaseDatos {
		String cadenaSQL="SELECT bloqueada from tarjetas WHERE numero = '"+numT+"'";
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if (reg.next() && reg.getInt(1)==0) {
				return true;
			}
			s.close();
			this.cerrar();
			return false;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public int sacar(int numT, double importe) throws ErrorBaseDatos {
		String cadenaSQL="SELECT cuenta,tipo from tarjetas WHERE numero = '"+numT+"'";
		int res=0; //contador de filas modificadas
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if (reg.next()) {
				int num=reg.getInt(1);
				String tipo=reg.getString(2);
				
				Statement s2=c.createStatement();
				ResultSet reg2=s2.executeQuery("SELECT saldo from cuentas WHERE número='"+num+"'");
				if (reg2.next()) {
					double saldo=reg2.getDouble(1);
					if (tipo.equals("D")) {
						if (saldo-importe<0) {
							throw new ErrorBaseDatos("Saldo negativo");
						}
						else {
							res=s2.executeUpdate("UPDATE cuentas set saldo='"+(saldo-importe)+"' WHERE número='"+num+"'");
						}
					}
					else {
						res=s2.executeUpdate("INSERT into movimientos VALUES (0,'"+numT+"','0','"+importe+"','"+LocalDate.now()+"')");
					}
				}
				s2.close();
			}
			s.close();
			this.cerrar();
			return res;
		} catch (SQLException e) {
			throw new ErrorBaseDatos(" Error");
		}		
	}
	
	public void cargarCredito(int numT) throws ErrorBaseDatos {
		String cadenaSQL="SELECT * from movimientos WHERE tarjeta='"+numT+"'";
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while (reg.next()) {
				if (reg.getInt(3)==0) {
					Statement s2=c.createStatement();
					ResultSet reg2=s2.executeQuery("SELECT tarjetas.numero, cuentas.número, cuentas.saldo FROM cuentas INNER JOIN tarjetas ON tarjetas.cuenta=cuentas.número WHERE tarjetas.numero='"+numT+"'");
					while (reg2.next()) {
						//System.out.println(reg2.getInt(1)+","+reg2.getInt(2)+","+reg2.getDouble(3));
						Statement s3=c.createStatement();
						int resultadoFilas=s3.executeUpdate("UPDATE cuentas set saldo='"+(reg2.getDouble(3)-reg.getDouble(4))+"' WHERE número='"+reg2.getInt(2)+"'");
						if (resultadoFilas<=0) {
							throw new ErrorBaseDatos("No se ha actualizado ninguna fila");
						}
					}
				}
			}
			s.executeUpdate("UPDATE movimientos set cargado='1' WHERE tarjeta='"+numT+"'");
			s.close();
			this.cerrar();
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public boolean checkNumTarjetaDuplicado(int numT) throws ErrorBaseDatos{
		String cadenaSQL="SELECT numero from tarjetas";
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while (reg.next()) {
				if (reg.getInt(1)==numT) {
					return true;
				}
			}
			s.close();
			this.cerrar();
			return false;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
	public void altaCredito(Cuentas a, int numTarjeta, String titular, double limite, String clave) throws ErrorBaseDatos {
		String cadenaSQL="INSERT INTO tarjetas VALUES('"+numTarjeta+"','"+a.getNum()+"','"+titular+"','"
				+limite+"','C','"+LocalDate.now().plusYears(1)+"','"+clave+"','0')"; 
		
		try{
			this.abrir();
			s=c.createStatement();
			s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
		}
		catch ( SQLException e){			
			throw new ErrorBaseDatos(" No se puede realizar el alta");
		}
	}
	
	public void altaDebito(int numC, String titular, String clave) throws ErrorBaseDatos {
		String cadenaSQL="INSERT INTO tarjetas VALUES('"+(buscarTarjetasMax()+1)+"','"+numC+
				"','"+titular+"','0','D','"+LocalDate.now().plusMonths(6)+"','"+clave+"','0')";
		try{
			this.abrir();
			s=c.createStatement();
			s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
		}
		catch ( SQLException e){			
			throw new ErrorBaseDatos(" No se puede realizar el alta");
		}
	}
	
	public void altaMovimientosFicheros(ArrayList<Movimientos> lista) throws ErrorBaseDatos {
		String cadenaSQL="INSERT INTO tarjetas VALUES(?,?,?,?)";
		try{
			this.abrir();
			PreparedStatement p=c.prepareStatement(cadenaSQL);

			for (Movimientos m : lista) {
				p.setInt(1, m.getTarjeta());
				p.setInt(2, m.getCargado());
				p.setDouble(3, m.getImporte());
				p.setDate(4, java.sql.Date.valueOf(m.getFecha()));
			}
			p.executeUpdate();
			
			p.close();
			this.cerrar();
		}
		catch ( SQLException e){			
			throw new ErrorBaseDatos(" No se puede realizar el alta");
		}
	}
	
	public ArrayList<Tarjetas> infoTitular(String titular) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from tarjetas WHERE titular= '"+titular+"' and caducidad < '"+LocalDate.now()+"'";
		ArrayList<Tarjetas> listaTarjetas=new ArrayList<>();
		try {
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while (reg.next()) {
				listaTarjetas.add(new Tarjetas(reg.getInt(1),reg.getInt(2),reg.getString(3),reg.getDouble(4),reg.getString(5),reg.getDate(6).toLocalDate(),reg.getInt(8)));
			}
			s.close();
			this.cerrar();
			return listaTarjetas;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error");
		}
	}
	
}
