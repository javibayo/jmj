package com.jmj.servicios.noticias;

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
import com.jmj.servicios.bbdd.AccesoBBDD;
import com.jmj.servicios.bbdd.AccesoBBDDImpl;


@Path("/anuncio/{a}")
public class AnunciosService {
	
	 @GET
	 @Produces("application/json")
	 public Response doIt(@PathParam("a") String a, String b) {


		   AccesoBBDD dbAnuncio = new AccesoBBDDImpl();
		   Gson gson = new Gson();
		 	ArrayList<AnuncioO> anuncios=dbAnuncio.getAnuncio(Integer.parseInt(a));
			String json=gson.toJson(anuncios);
			ResponseBuilder builder = new ResponseBuilderImpl();
		       builder.type(MediaType.APPLICATION_JSON);
		       builder.entity(json);
		       return builder.build();
			
			//return Response.ok(obj, MediaType.APPLICATION_JSON).build();
		};
	   
	   private static Logger logger = Logger.getLogger(AnunciosService.class);
	   public static void main(String args[]){
		   
		   AnunciosService s=new AnunciosService();
		   s.doIt("1", "2");
		   logger.debug("Terminando main");
	   }
}

