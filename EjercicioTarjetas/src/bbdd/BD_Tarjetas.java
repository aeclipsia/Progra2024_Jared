package bbdd;
import java.sql.*;
import java.text.SimpleDateFormat;
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
		String cadenaSQL="SELECT * from cuentas WHERE titular1='"+dni+"'";
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
	
	public boolean altaCredito() {
		return false;
	}
	
}
