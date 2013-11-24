package com.jmj.bbdd.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;

import com.jmj.bbdd.AccesoBBDD;
import com.jmj.beans.Usuario;
import com.jmj.constantes.CxDatosBBDD;






public class ServUsuarios {
	
	//TODO: Quitar el static de estos métodos.
	//TODO: Servicio de notificar por mail
	
	private static final Logger LOGGER = Logger.getLogger(AccesoBBDD.class);
	
	/**
	 * Servicio que permite consultar las provincias para mostrar en la pantalla de registro de usuario
	 */
	@SuppressWarnings("finally")
	public static ArrayList getProvincias()
	{
		ArrayList provincias = null;
		String selectProvincias = CxDatosBBDD.PROVINCIAS;
		
		LOGGER.debug("Query que se va a ejecutar: "+selectProvincias);
		
		try{
					
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(selectProvincias);
			
			ArrayList<String> arrL=new ArrayList<String>();
			
			ResultSet rsetCONtexto = AccesoBBDD.getInstance().leerBD(stmtCONtexto, arrL);
			
	   		if(rsetCONtexto!=null)
	   		{
	   			provincias = new ArrayList();
	   			
	   			while(rsetCONtexto.next())
	   			{
		   				provincias.add(rsetCONtexto.getString(CxDatosBBDD.PROVIN));
	   			}
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeLeerBD(stmtCONtexto, rsetCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al recuperar las provincias: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return provincias;
		}
}
	
	/**
	 * Servicio que permite consultar las localidades conocida la provincia
	 */
	@SuppressWarnings("finally")
	public static ArrayList getLocalidades(String provincia)
	{
		ArrayList localidades = null;
		String selectLocalidades = CxDatosBBDD.LOCALIDADES;
		
		LOGGER.debug("Query que se va a ejecutar: "+selectLocalidades);
		
		ArrayList<String> arrL=new ArrayList<String>();
		
		arrL.add(provincia);
		
		try{
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(selectLocalidades);
			ResultSet rsetCONtexto = AccesoBBDD.getInstance().leerBD(stmtCONtexto, arrL);
			
	   		if(rsetCONtexto!=null)
	   		{
	   			localidades = new ArrayList();
	   			
	   			while(rsetCONtexto.next())
	   			{
	   				localidades.add(rsetCONtexto.getString(CxDatosBBDD.LOCALIDAD));
	   			}
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeLeerBD(stmtCONtexto, rsetCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al recuperar las localidades: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return localidades;
		}
}
	
	/**
	 * Servicio que permite registrar a un usuario.
	 */
	public static boolean newUser(Usuario datosUsuario)
	{
		//Comprobamos previamente si existe el usuario dado de alta en la BBDD
		boolean resultado=existUser(datosUsuario.getEmail());
		if(resultado==false)
		{
			//Si no existe, generamos la clave de activación para el usuario
			generaClave(datosUsuario);
			
			// Y lo registramos 
			resultado= setNewUser(datosUsuario);
		}
		return resultado;
	}
	
	/**
	 * Servicio que genera la clave de activación del usuario.
	 */
	public static void generaClave(Usuario datosUsuario)
	{
		String clave= "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while (i < 30){
		char c = (char)r.nextInt(255);
		if ( (c <= '0' && c >='9') || (c <='A' && c >='Z') ){
			clave += c;
		i ++;
		}
		}	
		datosUsuario.setClaveAct(clave);
	}
	
	/**
	 * Servicio que comprueba si el usuario existe o no (vale para la opción Olvidé contraseña)
	 */
	@SuppressWarnings("finally")
	public static boolean existUser(String usuario)
	{
		boolean resultado = false;
		String selectLogon = CxDatosBBDD.LOGON2;
		
		LOGGER.debug("Query que se va a ejecutar: "+selectLogon);
		
		try{

			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(usuario);
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(selectLogon);
			ResultSet rsetCONtexto = AccesoBBDD.getInstance().leerBD(stmtCONtexto, arrL);
			
	   		if(rsetCONtexto!=null)
	   		{
	   			while(rsetCONtexto.next())
	   			{
	   				if(rsetCONtexto.getInt(1)==1)
	   				{
	   					LOGGER.info("El usuario está dado de alta en la aplicación"); 
	   					resultado=true;
	   				}
	   				else{
	   					LOGGER.info("El usuario no se ha logado correctamente");
	   				}
	
	   			}
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeLeerBD(stmtCONtexto,rsetCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al realizar el logon del usuario: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
}
	
	
	/**
	 * Servicio que permite dar de alta a un nuevo usuario.
	 */
	@SuppressWarnings("finally")
	public static boolean setNewUser(Usuario datosUsuario)
	{
		boolean resultado = false;
		
		
		String InsertUser= CxDatosBBDD.INSERTUSER1;

		LOGGER.debug("Query que se va a ejecutar: "+InsertUser);
		
		
		ArrayList<String> arrL=new ArrayList<String>();
		
		arrL.add(datosUsuario.getEmail());
		arrL.add(datosUsuario.getPassword());
		arrL.add(datosUsuario.getNombre());
		arrL.add(datosUsuario.getApellido1());
		arrL.add(datosUsuario.getApellido2());
		arrL.add(datosUsuario.getFecNacimiento());
		arrL.add(datosUsuario.getSexo());
		arrL.add(datosUsuario.getDirecc());
		arrL.add(datosUsuario.getCodPostal());
		arrL.add(datosUsuario.getCiudad());
		arrL.add(datosUsuario.getProvincia());
		arrL.add(datosUsuario.getTelefono());
		arrL.add(datosUsuario.getClaveAct());
		
		try{
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(InsertUser);
			
		    int resBBDD = AccesoBBDD.getInstance().insertBD(stmtCONtexto, arrL);
		    
	   		if(resBBDD==1)
	   		{
	   				LOGGER.info("Se ha hecho correctamente el alta del usuario"); 
	   				resultado=true;
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeInsertBD(stmtCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al dar de alta a un nuevo usuario: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
}
	
	/**
	 * Servicio que permite realizar el logon de un usuario que está dado de alta previamente en la aplicación
	 */
	@SuppressWarnings("finally")
	public static boolean setLogon(String usuario, String password)
	{
		boolean resultado = false;
		String selectLogon = CxDatosBBDD.LOGON1;
		
		LOGGER.debug("Query que se va a ejecutar: "+selectLogon);
		
		try{
			
			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(usuario);
			arrL.add(password);
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(selectLogon);
			ResultSet rsetCONtexto = AccesoBBDD.getInstance().leerBD(stmtCONtexto, arrL);
			
	   		if(rsetCONtexto!=null)
	   		{
	   			while(rsetCONtexto.next())
	   			{
	   				if(rsetCONtexto.getInt(1)==1)
	   				{
	   					LOGGER.info("El usuario está dado de alta en la aplicación"); 
	   					resultado=true;
	   				}
	   				else{
	   					LOGGER.info("El usuario no se ha logado correctamente");
	   				}
	
	   			}
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeLeerBD(stmtCONtexto,rsetCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al realizar el logon del usuario: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
}
	
	/**
	 * Servicio que permite actualizar la password (si previamente la ha olvidado). Se invoca cuando el usuario solicite la contraseña porque la ha olvidado.
	 * 
	 */
	@SuppressWarnings("finally")
	public static boolean setPassword(String usuario, String password)
	{
		boolean resultado = false;
		String updatePassword=CxDatosBBDD.PASSW1;
		
		LOGGER.debug("Query que se va a ejecutar: "+updatePassword);
		
		try{
			
			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(password);
			arrL.add(usuario);
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(updatePassword);
			int resBBDD = AccesoBBDD.getInstance().insertBD(stmtCONtexto, arrL);
			
	   		if(resBBDD==1)
	   		{
	   				LOGGER.info("Se ha hecho correctamente el update en BBDD"); 
	   				resultado=true;
	   		}
			

			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeInsertBD(stmtCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al obtener el password del usuario: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
	}
	
	/**
	 * Servicio que permite consultar el detalle de un usuario
	 */
	@SuppressWarnings("finally")
	public static Usuario getUserInfo(Usuario usuario)
	{
		ArrayList infoUsuario = null;
		String selectInfo= CxDatosBBDD.INFOUSUARIO;
		
		LOGGER.debug("Query que se va a ejecutar: "+selectInfo);
		
		try{
			
			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(usuario.getEmail());
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(selectInfo);
			ResultSet rsetCONtexto = AccesoBBDD.getInstance().leerBD(stmtCONtexto, arrL);
			
	   		if(rsetCONtexto!=null)
	   		{
	   			infoUsuario = new ArrayList();
	   			
	   			while(rsetCONtexto.next())
	   			{
	   				usuario.setNombre(rsetCONtexto.getString(CxDatosBBDD.NOMBRE));
	   				usuario.setApellido1(rsetCONtexto.getString(CxDatosBBDD.APELLIDO1));
	   				usuario.setApellido2(rsetCONtexto.getString(CxDatosBBDD.APELLIDO2));
	   				usuario.setFecNacimiento(rsetCONtexto.getString(CxDatosBBDD.FEC_NACIM));
	   				usuario.setSexo(rsetCONtexto.getString(CxDatosBBDD.XTI_SEXO));
	   				usuario.setDirecc(rsetCONtexto.getString(CxDatosBBDD.DES_DIRECC));
	   				usuario.setCodPostal(rsetCONtexto.getString(CxDatosBBDD.COD_POSTAL));
	   				usuario.setProvincia(rsetCONtexto.getString(CxDatosBBDD.PROVIN));
	   				usuario.setCiudad(rsetCONtexto.getString(CxDatosBBDD.LOCALIDAD));
	   				usuario.setTelefono(rsetCONtexto.getString(CxDatosBBDD.COD_NUMTLF));

	   			}
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeLeerBD(stmtCONtexto,rsetCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al realizar el logon del usuario: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return usuario;
		}
}
	/**
	 * Servicio que permite actualizar la password (si previamente la ha olvidado). Se invoca cuando el usuario solicite la contraseña porque la ha olvidado.
	 * 
	 */
	@SuppressWarnings("finally")
	public static boolean setUserInfo(Usuario usuario)
	{
		boolean resultado = false;
		String updateUserInfo=CxDatosBBDD.UPDINFO1;
		
		LOGGER.debug("Query que se va a ejecutar: "+updateUserInfo);
		
		try{
			
			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(usuario.getNombre());
			arrL.add(usuario.getApellido1());
			arrL.add(usuario.getApellido2());
			arrL.add(usuario.getFecNacimiento());
			arrL.add(usuario.getSexo());
			arrL.add(usuario.getDirecc());
			arrL.add(usuario.getCodPostal());
			arrL.add(usuario.getCiudad());
			arrL.add(usuario.getProvincia());
			arrL.add(usuario.getTelefono());
			arrL.add(usuario.getEmail());
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(updateUserInfo);
			int resBBDD = AccesoBBDD.getInstance().insertBD(stmtCONtexto, arrL);
			
	   		if(resBBDD==1)
	   		{
	   				LOGGER.info("Se ha hecho correctamente el update en BBDD"); 
	   				resultado=true;
	   		}
			

			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeInsertBD(stmtCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al obtener el password del usuario: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
	}
	
	/**
	 * Servicio que permite validar que la clave para que el usuario active su cuenta en la web es correcta (servicio a ejecutar tras clicar sobre el enlace del mail
	 * 
	 */
	@SuppressWarnings("finally")
	public static boolean activarUser(String clave, String mail)
	{
		boolean resultado = false;
		if(isClaveUser (clave, mail))
		{
			setEstadoUser(mail,"A");
		}
		
		return resultado;
}
	
	/**
	 * Servicio que permite validar que la clave para que el usuario active su cuenta en la web es correcta (servicio a ejecutar tras clicar sobre el enlace del mail
	 * 
	 */
	@SuppressWarnings("finally")
	public static boolean isClaveUser(String clave, String mail)
	{
		boolean resultado = false;
		String CountUserInfo=CxDatosBBDD.VALIDARCLAVE;
		
		LOGGER.debug("Query que se va a ejecutar: "+CountUserInfo);
		
		try{
			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(mail);
			arrL.add(clave);
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(CountUserInfo);
			ResultSet rsetCONtexto = AccesoBBDD.getInstance().leerBD(stmtCONtexto, arrL);
			
	   		if(rsetCONtexto!=null)
	   		{
	   			while(rsetCONtexto.next())
	   			{
	   				if(rsetCONtexto.getInt(1)==1)
	   				{
	   					LOGGER.info("La clave de activación es válida"); 
	   					resultado=true;
	   				}
	   				else{
	   					LOGGER.info("La clave es inválida");
	   				}
	
	   			}
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeLeerBD(stmtCONtexto,rsetCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al realizar el logon del usuario: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
}	
	/**
	 * Servicio que permite activar el estado del usuario	 
	 * 
	 */
	@SuppressWarnings("finally")
	public static boolean setEstadoUser(String usuario, String estado)
	{
		boolean resultado = false;
		String updateEstado=CxDatosBBDD.ESTADOUSER;
		
		LOGGER.debug("Query que se va a ejecutar: "+updateEstado);
		
		try{
			
			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(estado);
			arrL.add(usuario);
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(updateEstado);
			int resBBDD = AccesoBBDD.getInstance().insertBD(stmtCONtexto, arrL);
			
	   		if(resBBDD==1)
	   		{
	   				LOGGER.info("Se ha hecho correctamente el update del estado del user en BBDD"); 
	   				resultado=true;
	   		}
			

			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeInsertBD(stmtCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al actualizar el estado del usuario: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
	}
		
}