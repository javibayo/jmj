package com.jmj.obtencion.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

public class AccesoFicheros {

	private static Configuration config=new Configuration();
	private static String DIRBASE = config.getConfig("anuncios.dirbase");
	private static String seccion = config.getConfig("anuncios.seccion");
	private static Logger logger = Logger.getLogger(AccesoFicheros.class);
		
	public static void escribeFichero(String nombre, BufferedReader in){
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        logger.info("Escribiendo fichero:"+nombre);
        try
        {
        	fichero = new FileWriter(nombre);
            pw = new PrintWriter(fichero);
            String inputLine;
            StringBuffer strb=new StringBuffer();
	        while ((inputLine = in.readLine()) != null){
	        	strb.append(inputLine);
	 	    }
	 	    StringBuffer newStringBuffer = new StringBuffer(strb.toString().replaceAll("><", ">\n<").replaceAll("        ", "\n").replaceAll("    ", "\n"));  
	 	    pw.println(newStringBuffer.toString());  
        } catch (Exception e) {
        	logger.error("Escribiendo fichero:"+nombre);
        	e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
        	   logger.error("Cerrando fichero:"+nombre);
        	   e2.printStackTrace();
           }
        }
		
	}

	public static void escribeFicheroConDirectorio(String nombre,String seccion,String pagina, StringBuffer anuncio){
		
		FileWriter fichero = null;
	    PrintWriter pw = null;
	    try
	    {
	    	File folder = new File(DIRBASE+seccion+"/pagina"+pagina);
	    	logger.debug("Creando directorio:"+DIRBASE+seccion+"/pagina"+pagina);
	    	if (!folder.exists()) {
	    		
	    		folder.mkdir();
	    	}
	    	logger.debug("Escribiendo fichero:"+DIRBASE+seccion+"/pagina"+pagina+"/anuncio"+nombre+".info");
	        fichero = new FileWriter(DIRBASE+seccion+"/pagina"+pagina+"/anuncio"+nombre+".info");
	        
	        StringBuffer newStringBuffer = new StringBuffer(anuncio.toString().replaceAll("><", ">\n<"));  
	      
	        pw = new PrintWriter(fichero);
	        String inputLine;
	        pw.println(newStringBuffer.toString());
	
	    } catch (Exception e) {
	    	logger.error("Escribiendo fichero:"+DIRBASE+seccion+"/pagina"+pagina+"/anuncio"+nombre+".info");
	    	e.printStackTrace();
	    } finally {
	       try {
	       // Nuevamente aprovechamos el finally para 
	       // asegurarnos que se cierra el fichero.
	       if (null != fichero)
	          fichero.close();
	       } catch (Exception e2) {
	    	  logger.error("Cerrando fichero:"+DIRBASE+seccion+"/pagina"+pagina+"/anuncio"+nombre+".info");
	          e2.printStackTrace();
	       }
	    }
		
	}
	
	public static void escribeEnFichero(String nombre, String html){
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
        	logger.debug("Escribiendo fichero:"+nombre);
        	fichero = new FileWriter(nombre);
            pw = new PrintWriter(fichero);
             pw.println(html.toString());  

        } catch (Exception e) {
        	logger.error("Escribiendo fichero:"+nombre);
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
        	   logger.error("cerrando fichero:"+nombre);
              e2.printStackTrace();
           }
        }
		
	}
}


