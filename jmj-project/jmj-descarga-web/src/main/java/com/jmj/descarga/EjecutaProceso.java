package com.jmj.descarga;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.jmj.beans.AnuncioO;
import com.jmj.obtencion.utils.Configuration;

public class EjecutaProceso {

	private static Logger logger = Logger.getLogger(EjecutaProceso.class);
	private static String web=new Configuration().getConfig("anuncios.web");
	
	public static void main(String[] args) {
		logger.error("Iniciando proceso");
		Lector lector=new Lector();
		Troceador troceador = new Troceador();
		StringBuffer stb=new StringBuffer();
		for(int i=1; i<3;i++){
			//lector.init(i);
			//troceador.troceaPagina(Integer.toString(i), web);
			for(int j=2; j<3;j++){
				AnuncioO an=MaquetadorCaza.formateaAnuncio(i, Integer.toString(j), web);
				System.out.println(an.getAnunciante());
				Gson gson = new Gson();
				stb.append(gson.toJson(an)).append("\n");
			}
		}
		
		logger.error("Anuncios:"+stb.toString());
		
		
		
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
