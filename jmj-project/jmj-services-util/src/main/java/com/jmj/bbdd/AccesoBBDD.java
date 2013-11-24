package com.jmj.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.jmj.constantes.CxDatosBBDD;




public class AccesoBBDD {
	
	private static AccesoBBDD accesoBD = null;
	private static Connection conn = null;
	
	private static final Logger LOGGER = Logger.getLogger(AccesoBBDD.class);

	private AccesoBBDD(boolean jdbc) throws SQLException 
	{
		try 
		{
			if (jdbc)
			{
				conectarBBDD();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();	
			LOGGER.error("Error SQLException AccesoBBDD: " + e.getClass() + " - " + e.getMessage() + " - " + e.getErrorCode());
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			LOGGER.error("Error SQLException AccesoBBDD: " + ex.getClass() + " - " + ex.getMessage());
		}
	}
	

	public Connection getConnection(){
		return this.conn;
	}
	
	public static synchronized AccesoBBDD getInstance() throws SQLException 
	{
		if (accesoBD == null) 
		{
			accesoBD = new AccesoBBDD(true);
		}
		
		return accesoBD;
	}

	
	private void conectarBBDD() throws SQLException 
	{
		// Se registra el Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		// Conexión a la BBDD de MySQL
		conn = DriverManager.getConnection(CxDatosBBDD.URLBBDD, CxDatosBBDD.USERBBDD, CxDatosBBDD.PASSWORDBBDD);
	}


	public Statement getStmt() throws SQLException 
	{
		Statement stmt = null;
		
		try
		{
			stmt = conn.createStatement();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			LOGGER.error("ERROR SQLException getStmt(): " + e.getMessage() + " - " + e.getErrorCode() + " - " + e.getSQLState());
			
			throw e;
		}
			
		return stmt;
	}

	public PreparedStatement getPstmt(String consulta){
		try {
			return conn.prepareStatement(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet leerBD(PreparedStatement pstmt, ArrayList<String> parameters) throws SQLException 
	{
		try
		{
			int i=1;
			for(String s: parameters){
				pstmt.setString(i, s);
				i++;
			}
			
			//Se ejecuta la SELECT
			ResultSet rset = pstmt.executeQuery();
			
			
			return rset;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			LOGGER.error("ERROR SQLException leerBD(): " + e.getMessage() + " - " + e.getErrorCode() + " - " + e.getSQLState());
			
			throw e;
		}
	}
	public int insertBD(PreparedStatement pstmt, ArrayList<String> parameters) throws SQLException 
	{
		try
		{
			int i=1;
			for(String s: parameters){
				pstmt.setString(i, s);
				i++;
			}
			//Se ejecuta la SELECT
			int rset = pstmt.executeUpdate();
			
			return rset;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			LOGGER.error("ERROR SQLException leerBD(): " + e.getMessage() + " - " + e.getErrorCode() + " - " + e.getSQLState());
			
			throw e;
		}
	}

	public void closeInsertBD(Statement stmt) throws SQLException 
	{
		
		if (stmt != null)
		{
			stmt.close();
		}
	}
	
	public void closeLeerBD(PreparedStatement stmt, ResultSet rset) throws SQLException 
	{
		if (rset != null)
		{
			rset.close();
		}
		
		if (stmt != null)
		{
			stmt.close();
		}
	}

	public void closeRSet(ResultSet rset) throws SQLException 
	{
		if (rset != null)
		{
			rset.close();
		}
	}
	

	public void close() throws SQLException 
	{
		if (conn != null && !conn.isClosed()) 
		{
			conn.commit();
			conn.close();
			
			accesoBD = null;
		}
	}
}

