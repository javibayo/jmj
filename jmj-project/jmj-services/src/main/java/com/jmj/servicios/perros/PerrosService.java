package com.jmj.servicios.perros;

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


@Path("/perro/{a}")
public class PerrosService {
	
	 @GET
	 @Produces("application/json")
	 public Response doIt(@PathParam("a") String a, String b) {


		  
//		 	ArrayList<AnuncioO> anuncios=dbAnuncio.getAnuncio(Integer.parseInt(a));
//			String json=gson.toJson(anuncios);
		   String json="devolviendo perro "+a;
		   
			ResponseBuilder builder = new ResponseBuilderImpl();
		       builder.type(MediaType.APPLICATION_JSON);
		       builder.entity(json);
		       return builder.build();
			
			//return Response.ok(obj, MediaType.APPLICATION_JSON).build();
		};
	   
	   private static Logger logger = Logger.getLogger(PerrosService.class);
	   public static void main(String args[]){
		   
		   PerrosService s=new PerrosService();
		   s.doIt("1", "2");
		   logger.debug("Terminando main");
	   }
}

