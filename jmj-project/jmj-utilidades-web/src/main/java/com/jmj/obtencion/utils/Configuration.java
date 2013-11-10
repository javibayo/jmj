package com.jmj.obtencion.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private static Properties configProp = new Properties();
	public  void loadProps1() {
	        InputStream in = this.getClass().getResourceAsStream("/anuncios.properties");
	        try {
	            configProp.load(in);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public String getConfig(String key){
		loadProps1();
		return configProp.getProperty(key);
	}
}
