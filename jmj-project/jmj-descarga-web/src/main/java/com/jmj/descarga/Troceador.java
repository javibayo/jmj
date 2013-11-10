package com.jmj.descarga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.jmj.beans.AnuncioO;
import com.jmj.obtencion.utils.AccesoFicheros;
import com.jmj.obtencion.utils.Configuration;

public class Troceador {
	/**
	 * @param args
	 */
	
	private static String seccion=null;
	private static String DIRBASE=null;
	private static String web=null;
	
	private static Logger logger = Logger.getLogger(Troceador.class);
	
	public Troceador(){
		seccion=new Configuration().getConfig("anuncios.seccion");
		DIRBASE=new Configuration().getConfig("anuncios.dirbase");
		web=new Configuration().getConfig("anuncios.web");
	}
	
	public static void main(String[] args) {
		Troceador troceador = new Troceador();
		troceador.troceaPagina(Integer.toString(2), web);
	}
	
	public void troceaPagina(String pagina,String urlActual){
		File archivo = null;
		FileReader fr2 = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    try {
	         archivo = new File (DIRBASE+seccion+"/pagina"+pagina+".info");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         int anuncio=0;
	         StringBuffer strb=new StringBuffer();
	         
	         while((linea=br.readLine())!=null){
	            strb.append(linea);
	            
	            if(linea.equals("<div class=x2>")){
	            	
	            	AccesoFicheros.escribeFicheroConDirectorio(Integer.toString(anuncio), seccion, pagina, strb);
	            	anuncio++;
	            	strb.delete(0, strb.length());
	            }
	         }
	         
	         logger.debug("Hay "+anuncio+" por pagina");
	      }
	      catch(Exception e){
	    	 logger.debug("Partiendo anuncios de la pagina"+pagina);
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }  
	         }catch (Exception e2){ 
	        	 logger.debug("Cerrando anuncios de la pagina"+pagina);
	            e2.printStackTrace();
	         }
	      }
	}	
}
