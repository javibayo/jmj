package com.jmj.obtencion.maquetado;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.jmj.beans.AnuncioO;
import com.jmj.obtencion.EjecutaProceso;
import com.jmj.obtencion.descarga.LeeSegundaMano;
import com.jmj.obtencion.utils.AccesoFicheros;
import com.jmj.obtencion.utils.Configuration;

/*Clase que trocea la páginas leidas*/
public class ParteAnuncios {

	/**
	 * @param args
	 */
	
	private static String seccion=null;
	private static String DIRBASE=null;
	private static String web=null;
	
	private static Logger logger = Logger.getLogger(ParteAnuncios.class);
	
	public ParteAnuncios(){
		seccion=new Configuration().getConfig("anuncios.seccion");
		DIRBASE=new Configuration().getConfig("anuncios.dirbase");
		web=new Configuration().getConfig("anuncios.web");
	}
	
	public static void main(String[] args) {
		ParteAnuncios troceador = new ParteAnuncios();
		troceador.troceaPagina(Integer.toString(1), web);
	}
	
	public ArrayList troceaPagina(String pagina,String urlActual){
		File archivo = null;
		File archivo2 = null;
	    FileReader fr2 = null;
	    BufferedReader br2 = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    ArrayList retorno = null;
	    try {
	         archivo = new File (DIRBASE+seccion+"/pagina"+pagina+".info");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         int anuncio=0;
	         StringBuffer strb=new StringBuffer();
	         ArrayList a=new ArrayList<AnuncioO>();
	         while((linea=br.readLine())!=null){
	            strb.append(linea);
	            
	            if(linea.equals("<div class=x2>")){
	            	
	            	 AccesoFicheros.escribeFicheroConDirectorio(Integer.toString(anuncio), seccion, pagina+"consalto", strb);
	            	 logger.debug("***************************************************************************************");
	            	 a.add(FormatearAnuncio.formateaAnuncio(pagina+"consalto", Integer.toString(anuncio), urlActual));
	            	 logger.debug("***************************************************************************************");
	            	
	            	anuncio++;
	            	strb.delete(0, strb.length());
	            }
	         }
	         
	         logger.debug("Hay "+anuncio+" por pagina");
	         retorno = a;
	      }
	      catch(Exception e){
	    	 logger.debug("Partiendo anuncios de la pagina"+pagina);
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }  
	            if( null != fr2 ){   
		               fr2.close();     
		            }  
	         }catch (Exception e2){ 
	        	 logger.debug("Cerrando anuncios de la pagina"+pagina);
	            e2.printStackTrace();
	         }
	      }
	    return retorno;
	}	
}
