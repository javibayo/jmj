package com.jmj.servicios.bbdd;

import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.jmj.beans.AnuncioO;
import com.jmj.obtencion.utils.Configuration;


public class AccesoBBDDImpl implements AccesoBBDD {

	private static String web=new Configuration().getConfig("anuncios.web");
	 private static Logger logger = Logger.getLogger(AccesoBBDDImpl.class);
	
	
	private EntityManagerFactory entityManagerFactory;
	
	public AccesoBBDDImpl(){
		
		try {
			logger.debug("Creando entitymanagerFactory");
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			logger.error("ERROR: Creando entitymanagerFactory");
			e.printStackTrace();
		}
		
	}
	
	private void setUp() throws Exception {
	    entityManagerFactory = Persistence.createEntityManagerFactory( "manager1" );
	}
	
	public ArrayList<AnuncioO> getAnuncio(int anuncio) {
		// TODO Auto-generated method stub
		
		
		return new ArrayList();
	}
	
	
	public boolean getUsuario(String usuario) {
		
		return false;
	}
	
	
	
}
