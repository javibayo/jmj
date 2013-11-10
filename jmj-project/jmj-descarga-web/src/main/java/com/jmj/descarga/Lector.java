package com.jmj.descarga;

import java.io.BufferedReader;

import org.apache.log4j.Logger;

import com.jmj.obtencion.utils.AccesoFicheros;
import com.jmj.obtencion.utils.AccesoWeb;
import com.jmj.obtencion.utils.Configuration;

public class Lector {

	private Configuration config=new Configuration();
	private String seccion=null;
	private String web=null;
	private String separador=null;
	private String DIRBASE = null;
	
	private Logger logger = Logger.getLogger(getClass());
	
	public Lector(){
		seccion = config.getConfig("anuncios.seccion");
		web = config.getConfig("anuncios.web");
		separador = config.getConfig("anuncios.separador.url");
		DIRBASE = config.getConfig("anuncios.dirbase");
	}
	
	public void init(int i) {
		logger.debug("Iniciando descarga de recursos de:"+web+seccion);
		try{
			String nombreFichero="";
	        String urlToSend = web+seccion+separador;
			
			BufferedReader in = AccesoWeb.getDatosWeb(urlToSend+i);
	        logger.debug("Creando fichero" + Integer.toString(i));
			nombreFichero=DIRBASE+seccion+"/pagina"+Integer.toString(i)+".info";
	        AccesoFicheros.escribeFichero(nombreFichero,  in);
	        in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.debug("Finalizando descarga de recursos de:"+web+seccion);
	}
}
