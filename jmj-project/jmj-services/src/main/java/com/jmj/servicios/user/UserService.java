package com.jmj.servicios.user;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.jmj.beans.AnuncioO;
import com.jmj.bbdd.AccesoBBDD;


@Path("/user/{a}")
public class UserService {
	
	 @GET
	 @Produces("application/json")
	 public Response doIt(@PathParam("a") String a, String b) {

		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 logger.debug("con password de  root");
		 
	  		 	
//		 	boolean anuncios=dbAnuncio.getUsuario(a);

		   String json="{devolviendo user "+a+"}";
			
			ResponseBuilder builder = new ResponseBuilderImpl();
		       builder.type(MediaType.APPLICATION_JSON);
		       builder.entity(json);
		       return builder.build();
			
			//return Response.ok(obj, MediaType.APPLICATION_JSON).build();
		};
	   
	   private static Logger logger = Logger.getLogger(UserService.class);
	   public static void main(String args[]){
		   
		   UserService s=new UserService();
		   s.doIt("1", "2");
		   logger.debug("Terminando main");
	   }
}

