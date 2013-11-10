package com.jmj.obtencion.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class AccesoWeb {

	private static Logger logger = Logger.getLogger(AccesoWeb.class);
	
	public static BufferedReader getDatosWeb(String url){
		BufferedReader in = null;
		try {
			logger.debug("Enviando peticion a:"+url);
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        } catch (MalformedURLException e) {
        	logger.error("Enviando peticion a:"+url);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Enviando peticion a:"+url);
			e.printStackTrace();
		}
		return in;
	}
}
