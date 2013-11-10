package com.jmj.obtencion;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.jmj.beans.AnuncioO;
import com.jmj.obtencion.descarga.LeeSegundaMano;
import com.jmj.obtencion.maquetado.ParteAnuncios;
import com.jmj.obtencion.maquetado.crearHTML;
import com.jmj.obtencion.publicacion.crearGSON;
import com.jmj.obtencion.utils.Configuration;


/*Clase que obtiene los anuncios*/
public class EjecutaProceso {

	/**
	 * @param args
	 */
	private static Logger logger = Logger.getLogger(EjecutaProceso.class);
	private static String web=new Configuration().getConfig("anuncios.web");
	
	public static void main(String[] args) {
		logger.debug("Iniciando proceso");
		LeeSegundaMano lector=new LeeSegundaMano();
		lector.init();
		
		/*ParteAnuncios troceador = new ParteAnuncios();
		ArrayList anuncios = new ArrayList<AnuncioO>();
		for(int i=1;i<2;i++){
			anuncios.addAll(troceador.troceaPagina(Integer.toString(i), web));
		}*/
		
		//Se crea un html de prueba
		//crearHTML.createhtml("0", anuncios);
		//crearGSON.generateJson("0",anuncios);
		
	}

}
