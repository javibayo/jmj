package com.jmj.bbdd.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.jmj.bbdd.AccesoBBDD;
import com.jmj.beans.Noticia;
import com.jmj.constantes.CxDatosBBDD;




public class ServNoticias {
	
	//TODO: Quitar el static de estos métodos.
	//TODO: Servicio de notificar por mail
	
	private static final Logger LOGGER = Logger.getLogger(AccesoBBDD.class);
	
	/**
	 * Servicio que permite dar de alta una nueva noticia. Por defecto se da de alta inactiva
	 */
	public static boolean newNoticia(Noticia datosNoticia)
	{
		boolean resultado = false;
		
		String InsertUser= CxDatosBBDD.INSERTNOTICIA;

		LOGGER.debug("Query que se va a ejecutar: "+InsertUser);
		
		
		ArrayList<String> arrL=new ArrayList<String>();
		
		arrL.add(datosNoticia.getTitulo());
		arrL.add(datosNoticia.getResumen());
		arrL.add(datosNoticia.getDescripcion());
		arrL.add(datosNoticia.getLugar());
		arrL.add(datosNoticia.getUsTexto());
		
		// Se comprueba si viene informada la categoría a la que va a pertenecer la noticia. Si no vienen todos los campos informados
		// por defecto será 0,0,0
		if(datosNoticia.getCategoria()!=null && !"".equals(datosNoticia.getCategoria()) &&
			datosNoticia.getSubcat()!=null && !"".equals(datosNoticia.getSubcat()) &&
			datosNoticia.getSubsubcat()!=null && !"".equals(datosNoticia.getSubsubcat()))
			{
				arrL.add(datosNoticia.getCategoria());
				arrL.add(datosNoticia.getSubcat());
				arrL.add(datosNoticia.getSubsubcat());
			}
		else
		{
			//Valores por defecto:
			arrL.add(CxDatosBBDD.CATEG_DEFECTO);
			arrL.add(CxDatosBBDD.SUBCATEG_DEFECTO);
			arrL.add(CxDatosBBDD.SUBSUBCATEG_DEFECTO);
		}
		arrL.add(datosNoticia.getUsuario());
		
		try{
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(InsertUser);
			
		    int resBBDD = AccesoBBDD.getInstance().insertBD(stmtCONtexto, arrL);
		    
	   		if(resBBDD==1)
	   		{
	   				LOGGER.info("Se ha dado correctamente de alta la noticia"); 
	   				resultado=true;
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeInsertBD(stmtCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al dar de alta la noticia: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
	}
	
	
	/**
	 * Servicio que permite actualizar el estado de una noticia. Podrá activarla o cancelarla
	 */
	@SuppressWarnings("finally")
	public static boolean setEstadoNoticia(String estado, String codNoticia)
	{
		boolean resultado = false;
		String updateEstado=CxDatosBBDD.ESTADO_NOTICIA;
		
		LOGGER.debug("Query que se va a ejecutar: "+updateEstado);
		
		try{
			
			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(estado);
			arrL.add(codNoticia);
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(updateEstado);
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
           LOGGER.error("Se ha producido un error al actualizar el estado de la noticia: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
	}
	
	/**
	 * Servicio que permite actualizar la categoría, subcategoría y subsubcategoría de una noticia.
	 */
	@SuppressWarnings("finally")
	public static boolean setCategoria(Noticia datosNoticia)
	{
		
		//Query actualizar estado categoria de noticia
		
		boolean resultado = false;
		String updateCateg=CxDatosBBDD.CATEG_NOTICIA;
		
		LOGGER.debug("Query que se va a ejecutar: "+updateCateg);
		
		try{
			
			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(datosNoticia.getCategoria());
			arrL.add(datosNoticia.getSubcat());
			arrL.add(datosNoticia.getSubsubcat());
			arrL.add(datosNoticia.getCodNoticia());
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(updateCateg);
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
           LOGGER.error("Se ha producido un error al actualizar la categoría de la noticia: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return resultado;
		}
	}
	
	/**
	 * Servicio que permite consultar las noticias por categoría, subcategoría o subsubcategoría.
	 */
	
	public static ArrayList getNoticiasAll(String campoOrden, String tipoOrden)
	{
		return getNoticias(null, null, null, campoOrden, tipoOrden);
	}
	public static ArrayList getNoticiasCat1(String categoria,String campoOrden, String tipoOrden)
	{
		return getNoticias(categoria, null, null, campoOrden, tipoOrden);
	}
	public static ArrayList getNoticiasCat2(String categoria, String subCat, String campoOrden, String tipoOrden)
	{
		return getNoticias(categoria, subCat, null, campoOrden, tipoOrden);
	}
	
	@SuppressWarnings("finally")
	public static ArrayList getNoticias(String categoria, String subCat, String Subsubcat, String campoOrden, String tipoOrden)
	{
		ArrayList noticias = null;
		StringBuffer selectNoticias = null;
		selectNoticias.append(CxDatosBBDD.NOTICIAS1);
		
		String campo=campoOrden;
		
		//Se comprueba qué noticias son las que se quieren recuperar (por qué categoría, subcat...)
		if (categoria!=null && !"".equals(categoria))
		{
			if (subCat!=null && !"".equals(subCat))
			{
				 if(Subsubcat!=null && !"".equals(Subsubcat))
				 {
					selectNoticias.append(CxDatosBBDD.NOTICIAS_TODAS);
					selectNoticias.append(CxDatosBBDD.ORDERBY);
				 }
				 else
				 {
					 selectNoticias.append(CxDatosBBDD.NOTICIAS_2);
				 }
			
			}
			else 
			{
				selectNoticias.append(CxDatosBBDD.NOTICIAS_3);
			}
		}

		//Se recupera el campo por el que se quiere filtar. Si no viene informado, se tomará por defecto el campo COD_TITULO
		if (campoOrden==null || "".equals(campoOrden)) campo = CxDatosBBDD.COD_TITULO;
		selectNoticias.append(campo);
		
		//Se recupera el orden 
		
		if(tipoOrden!=null && tipoOrden.toUpperCase()=="DESC")
		{
			selectNoticias.append(CxDatosBBDD.DESC);
		}
		else
		{
			selectNoticias.append(CxDatosBBDD.ASC);
		}

		LOGGER.debug("Query que se va a ejecutar: "+selectNoticias.toString());
		
		try{
			Noticia noticiaAux = null;
					
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(selectNoticias.toString());
			
			ArrayList<String> arrL=new ArrayList<String>();
			
			ResultSet rsetCONtexto = AccesoBBDD.getInstance().leerBD(stmtCONtexto, arrL);
			
	   		if(rsetCONtexto!=null)
	   		{
	   			noticias = new ArrayList();
	   			
	   			while(rsetCONtexto.next())
	   			{
	   				noticiaAux.setTitulo(rsetCONtexto.getString(CxDatosBBDD.COD_TITULO));
	   				noticiaAux.setCodNoticia(rsetCONtexto.getString(CxDatosBBDD.COD_NOTICIA));
	   				noticiaAux.setResumen(rsetCONtexto.getString(CxDatosBBDD.DES_RESUMEN));
	   				noticiaAux.setLugar(rsetCONtexto.getString(CxDatosBBDD.COD_LUGAR));
	   				noticiaAux.setUsTexto(rsetCONtexto.getString(CxDatosBBDD.COD_USTEXTO));
	   				
	   				noticias.add(noticiaAux);
	   				
	   			}
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeLeerBD(stmtCONtexto, rsetCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al recuperar las noticias: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return noticias;
		}
}
	
	@SuppressWarnings("finally")
	public static Noticia getDetalleNoticia(Noticia noticia)
	{
		String selectDetalle=CxDatosBBDD.DETALLENOTICIA;
		
		LOGGER.debug("Query que se va a ejecutar: "+selectDetalle.toString());
		
		try{
			
			ArrayList<String> arrL=new ArrayList<String>();
			arrL.add(noticia.getCodNoticia());
			
			PreparedStatement stmtCONtexto = AccesoBBDD.getInstance().getPstmt(selectDetalle);
			ResultSet rsetCONtexto = AccesoBBDD.getInstance().leerBD(stmtCONtexto, arrL);

	   		if(rsetCONtexto!=null)
	   		{
	   			
	   			while(rsetCONtexto.next())
	   			{
	   				noticia.setTitulo(rsetCONtexto.getString(CxDatosBBDD.COD_TITULO));
	   				noticia.setCodNoticia(rsetCONtexto.getString(CxDatosBBDD.COD_NOTICIA));
	   				noticia.setResumen(rsetCONtexto.getString(CxDatosBBDD.DES_RESUMEN));
	   				noticia.setLugar(rsetCONtexto.getString(CxDatosBBDD.COD_LUGAR));
	   				noticia.setUsTexto(rsetCONtexto.getString(CxDatosBBDD.COD_USTEXTO));
	   				
	   				noticia.setDescripcion(rsetCONtexto.getString(CxDatosBBDD.DES_DESCRIP));
	   				noticia.setCategoria(rsetCONtexto.getString(CxDatosBBDD.XTI_CATEGOR));
	   				noticia.setSubcat(rsetCONtexto.getString(CxDatosBBDD.XTI_SUBCAT));
	   				noticia.setSubsubcat(rsetCONtexto.getString(CxDatosBBDD.XTI_SUBSUBCA));
	   				noticia.setUsuario(rsetCONtexto.getString(CxDatosBBDD.COD_USUARIO));
	   				noticia.setAudTimfmod(rsetCONtexto.getString(CxDatosBBDD.AUD_TIMFMOD));	
	   			}
	   		}
	
			// Cerramos conexion con BBDD para esta query
			AccesoBBDD.getInstance().closeLeerBD(stmtCONtexto, rsetCONtexto);	
		}
		catch (SQLException e) {			
           LOGGER.error("Se ha producido un error al recuperar las noticias: " + e.getMessage());
           LOGGER.error("e.getClass(): "+e.getClass());
		}
		finally{
			return noticia;
		}
}
		
	
	
	
	
	
	
	
	

		
}