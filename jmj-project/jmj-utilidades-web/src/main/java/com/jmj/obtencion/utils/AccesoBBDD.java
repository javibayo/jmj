package com.jmj.obtencion.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.jmj.beans.AnuncioO;

public class AccesoBBDD {

	private static Configuration config=new Configuration();
	private static String url = new Configuration().getConfig("anuncios.bbdd.url");
	private static String user = new Configuration().getConfig("anuncios.bbdd.user");
	private static String password = new Configuration().getConfig("anuncios.bbdd.password");
	private static Logger logger = Logger.getLogger(AccesoBBDD.class);
	
	public static void insertaAnuncioBBDD(AnuncioO a) {
		// TODO Auto-generated method stub
		// Se registra el Driver de MySQL
	    try {
	    	logger.debug("Registrando driver");
			DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
		
		    // Se obtiene una conexión con la base de datos. Hay que
		    // cambiar el usuario "root" y la clave "la_clave" por las
		    // adecuadas a la base de datos que estemos usando.
		    Connection conexion = DriverManager.getConnection (url, user, password);
		    
		    // Se crea un Statement, para realizar la consulta
		    Statement s = conexion.createStatement();
		    
		    // Se realiza la consulta. Los resultados se guardan en el 
		    // ResultSet rs
		    ResultSet rs = s.executeQuery ("select * from persona");
		    
		    logger.debug("Salida consulta query: "+rs.toString());
		    
		    // Se recorre el ResultSet, mostrando por pantalla los resultados.
		    while (rs.next())
		    {
		    	logger.debug(rs.getInt ("Id") + " " + rs.getString (2)+ 
		            " " + rs.getDate(3));
		    }
		    
		    // Se cierra la conexión con la base de datos.
		    conexion.close();
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
