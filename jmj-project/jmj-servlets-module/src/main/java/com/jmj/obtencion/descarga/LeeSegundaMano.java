package com.jmj.obtencion.descarga;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.jmj.obtencion.utils.AccesoFicheros;
import com.jmj.obtencion.utils.AccesoWeb;
import com.jmj.obtencion.utils.Configuration;

/*Clase que lee milanuncios*/
public class LeeSegundaMano {

	/**
	 * @param args
	 */
	
	private Configuration config=new Configuration();
	private String seccion=null;
	private String web=null;
	private String separador=null;
	private String DIRBASE = null;
	
	private Logger logger = Logger.getLogger(getClass());
	
	public LeeSegundaMano(){
		seccion = config.getConfig("anuncios.seccion");
		web = config.getConfig("anuncios.web");
		separador = config.getConfig("anuncios.separador.url");
		DIRBASE = config.getConfig("anuncios.dirbase");
	}
	
	public void init() {
		// TODO Auto-generated method stub
		logger.debug("Iniciando descarga de recursos de:"+web+seccion);
		try{
			
			BufferedReader in2 = AccesoWeb.getDatosWeb(web+seccion+"/");
	        
			logger.debug("Creando fichero" + seccion + "NET");
			String nombreFichero=DIRBASE+seccion+"/pagina"+seccion+"NET"+".info";
	        AccesoFicheros.escribeFichero(nombreFichero,  in2);
	        
	        in2.close();
	        String urlToSend = web+seccion+separador;
			for(int i=1; i<3;i++){
				
				BufferedReader in = AccesoWeb.getDatosWeb(urlToSend+i);
		        
				logger.debug("Creando fichero" + Integer.toString(i));
				nombreFichero=DIRBASE+seccion+"/pagina"+Integer.toString(i)+".info";
		        AccesoFicheros.escribeFichero(nombreFichero,  in);
		        
		        in.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.debug("Finalizando descarga de recursos de:"+web+seccion);
	}
	
	
	
	

}
