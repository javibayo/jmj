package com.jmj.servicios.noticias;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.jmj.beans.Noticia;



public class NoticiasService {
	
	 @GET
	 @Produces("application/json")
	 @Path("/noticia/{a}")
	 public Response getNoticia(@PathParam("a") String a, String b) {


		  
//		 	ArrayList<AnuncioO> anuncios=dbAnuncio.getAnuncio(Integer.parseInt(a));
//			String json=gson.toJson(anuncios);
		 
		 	
		   Noticia noticia=new Noticia();
		   
		   noticia.setCategoria("Caza mayor");
		   	noticia.setCodNoticia("noticia1");
			noticia.setTitulo("Así va la temporada de monterías");
			noticia.setResumen("Poco falta para llegar al ecuador de la campaña montera y podemos afirmar que ésta, en líneas generales, está respondiendo incluso mejor de lo esperado, con venados y jabalíes -también gamos y muflones- dando muchas satisfacciones a los cazadores.");
			noticia.setDescripcion("Poco falta para llegar al ecuador de la campaña montera y podemos afirmar que ésta, en líneas generales, está respondiendo incluso mejor de lo esperado, con venados y jabalíes -también gamos y muflones- dando muchas satisfacciones a los cazadores.<br><br>Y eso que llevamos poco más de un mes cazando en algunas autonomías –dos a lo sumo en las comunidades autónomas más madrugadoras a la hora de desvedar la caza mayor-, y eso que en este tiempo lo normal es que se falle más de la cuenta desde los puestos porque el personal aún no ha afinado la puntería, y eso que las semanas transcurridas no son las mejores para las rehalas porque aún no han adquirido el punto idóneo de forma física para batir las manchas en las mejores condiciones, y eso que en las primeras citas serranas los cochinos, sobre todos los macarenos o navajeros, flojearon algo en los tapetes de reses por no encontrarse aún fijados en las querencias propias de las fechas en las que nos encontrábamos debido al mucho calor padecido aún en muchos de nuestros montes, y eso...<br><br>Pues bien, a pesar de todo, la temporada de monterías ha ido consumiendo jornadas de caza y los resultados han ido respondiendo a lo que se esperaba antes del desvede general, incluso en algunos casos por encima de lo esperado.<br><br>Si bien los jabalíes no estuvieron a la altura de las circunstancias en las citas inaugurales por diversos motivos (no encontrarse aún en las manchas a montear a principios del ejercicio, demasiada densidad de cervuno en muchos cazaderos que acaba desfondando a los perros de rehala, canes aún lejos de su mejor versión a la hora de cazar los cochinos, etc.), poco a poco fueron recobrando su papel principal en esta modalidad venatoria y protagonizando lustrosos tapices cochineros.<br><br>Respecto al venado, bien desde el arranque hasta ahora. Lógicamente, mayor número y calidad en fincas cercadas, pero incluso en abierto, si ha disfrutado de alimento y tranquilidad, esta especie ha cumplido con creces, tanto machos como hembras, cazándose muchas de estas últimas como medida de gestión en la mayoría de monterías con presencia de cervuno.<br><br>También los gamos y los muflones han tenido un papel destacado en numerosos cazaderos en este primer tercio de la campaña de monterías, con capturas abultadas y bastantes trofeos homologables en muchos casos.<br><br>El lado malo<br><br>Sin embargo, no podemos olvidar que ésta, como otras temporadas anteriores, se encuentra enmarcada en un contexto de profunda crisis económica y cinegética, de ahí que todo lo anterior no es que esté alejado de la realidad, sino que se refiere a las monterías que sí han tenido lugar, no a aquéllas que han sido suspendidas por falta de contratación de los puestos, o a aquéllas que no han aparecido en los calendarios de las orgánicas por falta de acuerdos con los propietarios de los terrenos, etc.<br><br>Los precios de los puestos y de las acciones completas han vuelto a bajar considerablemente este año (se estima que un 20%), pero aun así hay un amplio sector de cazadores para el que los mismos siguen siendo inalcanzables, de forma que para poder montear esperan a las ofertas de última hora o a hacerse con algunos de los puestos con los que ahora se estila pagar a las rehalas, las cuales lo están pasando muy mal para mantenerse en la brecha venatoria porque a sus propietarios les cuesta cada vez más mantenerlas y esos puestos con los que se les paga a muchas no son tan fáciles de vender. Esto ha llevado a no pocos rehaleros, tanto buenos como regulares y malos, a tirar la toalla.<br><br>Para finalizar<br><br>Sólo cabe esperar que, de aquí a que termine el curso montero, sobre todo en el inicio del nuevo año, este manifiesto desequilibrio entre el buen momento que disfrutan nuestros cotos y fincas y el malo que padecen bastantes aficionados tienda a reducirse para que podamos afirmar, al hacer balance de esta temporada de monterías 2013-14, que hemos vivido una de las mejores campañas de los últimos tiempos en todos los sentidos.");
			noticia.setLugar("España");
			noticia.setUsTexto("Texto: José María García / Fotos: Shutterstock, Alberto Aníbal-Álvarez y Archivo");
			noticia.setSubcat(null);
			noticia.setSubsubcat(null);
			Gson gson = new Gson();
			String jsonNoticia=gson.toJson(noticia);
			System.out.println("Con path en metodo:"+jsonNoticia);
			ResponseBuilder builder = new ResponseBuilderImpl();
		       builder.type(MediaType.APPLICATION_JSON);
		       builder.entity(jsonNoticia);
		       return builder.build();
			
			//return Response.ok(obj, MediaType.APPLICATION_JSON).build();
		};
		
		@GET
		 @Produces("application/json")
		 @Path("/allNoticias/")
		 public Response getAllNoticias() {


			  
//			 	ArrayList<AnuncioO> anuncios=dbAnuncio.getAnuncio(Integer.parseInt(a));
//				String json=gson.toJson(anuncios);
			 
			ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
			 	for(int i=0;i<10;i++){
				 	Noticia noticia=new Noticia();
				   
				   	noticia.setCategoria("Caza mayor");
				   	noticia.setCodNoticia("noticia1"+i);
					noticia.setTitulo("Así va la temporada de monterías");
					noticia.setResumen("Poco falta para llegar al ecuador de la campaña montera y podemos afirmar que ésta, en líneas generales, está respondiendo incluso mejor de lo esperado, con venados y jabalíes -también gamos y muflones- dando muchas satisfacciones a los cazadores.");
					noticia.setDescripcion("Poco falta para llegar al ecuador de la campaña montera y podemos afirmar que ésta, en líneas generales, está respondiendo incluso mejor de lo esperado, con venados y jabalíes -también gamos y muflones- dando muchas satisfacciones a los cazadores.<br><br>Y eso que llevamos poco más de un mes cazando en algunas autonomías –dos a lo sumo en las comunidades autónomas más madrugadoras a la hora de desvedar la caza mayor-, y eso que en este tiempo lo normal es que se falle más de la cuenta desde los puestos porque el personal aún no ha afinado la puntería, y eso que las semanas transcurridas no son las mejores para las rehalas porque aún no han adquirido el punto idóneo de forma física para batir las manchas en las mejores condiciones, y eso que en las primeras citas serranas los cochinos, sobre todos los macarenos o navajeros, flojearon algo en los tapetes de reses por no encontrarse aún fijados en las querencias propias de las fechas en las que nos encontrábamos debido al mucho calor padecido aún en muchos de nuestros montes, y eso...<br><br>Pues bien, a pesar de todo, la temporada de monterías ha ido consumiendo jornadas de caza y los resultados han ido respondiendo a lo que se esperaba antes del desvede general, incluso en algunos casos por encima de lo esperado.<br><br>Si bien los jabalíes no estuvieron a la altura de las circunstancias en las citas inaugurales por diversos motivos (no encontrarse aún en las manchas a montear a principios del ejercicio, demasiada densidad de cervuno en muchos cazaderos que acaba desfondando a los perros de rehala, canes aún lejos de su mejor versión a la hora de cazar los cochinos, etc.), poco a poco fueron recobrando su papel principal en esta modalidad venatoria y protagonizando lustrosos tapices cochineros.<br><br>Respecto al venado, bien desde el arranque hasta ahora. Lógicamente, mayor número y calidad en fincas cercadas, pero incluso en abierto, si ha disfrutado de alimento y tranquilidad, esta especie ha cumplido con creces, tanto machos como hembras, cazándose muchas de estas últimas como medida de gestión en la mayoría de monterías con presencia de cervuno.<br><br>También los gamos y los muflones han tenido un papel destacado en numerosos cazaderos en este primer tercio de la campaña de monterías, con capturas abultadas y bastantes trofeos homologables en muchos casos.<br><br>El lado malo<br><br>Sin embargo, no podemos olvidar que ésta, como otras temporadas anteriores, se encuentra enmarcada en un contexto de profunda crisis económica y cinegética, de ahí que todo lo anterior no es que esté alejado de la realidad, sino que se refiere a las monterías que sí han tenido lugar, no a aquéllas que han sido suspendidas por falta de contratación de los puestos, o a aquéllas que no han aparecido en los calendarios de las orgánicas por falta de acuerdos con los propietarios de los terrenos, etc.<br><br>Los precios de los puestos y de las acciones completas han vuelto a bajar considerablemente este año (se estima que un 20%), pero aun así hay un amplio sector de cazadores para el que los mismos siguen siendo inalcanzables, de forma que para poder montear esperan a las ofertas de última hora o a hacerse con algunos de los puestos con los que ahora se estila pagar a las rehalas, las cuales lo están pasando muy mal para mantenerse en la brecha venatoria porque a sus propietarios les cuesta cada vez más mantenerlas y esos puestos con los que se les paga a muchas no son tan fáciles de vender. Esto ha llevado a no pocos rehaleros, tanto buenos como regulares y malos, a tirar la toalla.<br><br>Para finalizar<br><br>Sólo cabe esperar que, de aquí a que termine el curso montero, sobre todo en el inicio del nuevo año, este manifiesto desequilibrio entre el buen momento que disfrutan nuestros cotos y fincas y el malo que padecen bastantes aficionados tienda a reducirse para que podamos afirmar, al hacer balance de esta temporada de monterías 2013-14, que hemos vivido una de las mejores campañas de los últimos tiempos en todos los sentidos.");
					noticia.setLugar("España");
					noticia.setUsTexto("Texto: José María García / Fotos: Shutterstock, Alberto Aníbal-Álvarez y Archivo");
					noticia.setSubcat(null);
					noticia.setSubsubcat(null);
					listaNoticias.add(noticia);
			 	}
				Gson gson = new Gson();
				String jsonNoticia=gson.toJson(listaNoticias);
				System.out.println("Con path en metodo:"+jsonNoticia);
				ResponseBuilder builder = new ResponseBuilderImpl();
			       builder.type(MediaType.APPLICATION_JSON);
			       builder.entity(jsonNoticia);
			       return builder.build();
				
			};
	   
	   private static Logger logger = Logger.getLogger(NoticiasService.class);
	   public static void main(String args[]){
		   
		   NoticiasService s=new NoticiasService();
		   s.getNoticia("1", "2");
		   logger.debug("Terminando main");
	   }
	   
	   	 @POST
		 @Produces("application/json")
	   	 @Consumes("application/json")
		 @Path("/addNoticia/")
		 public Response addNoticia(Noticia n) {
	   		System.out.println("n noticia:"+n);
	   		Noticia noticia=new Noticia();
			   
   		 	noticia.setCategoria("Caza mayor");
		   	noticia.setCodNoticia("noticia1");
			noticia.setTitulo("Así va la temporada de monterías");
			noticia.setResumen("Poco falta para llegar al ecuador de la campaña montera y podemos afirmar que ésta, en líneas generales, está respondiendo incluso mejor de lo esperado, con venados y jabalíes -también gamos y muflones- dando muchas satisfacciones a los cazadores.");
			noticia.setDescripcion("Poco falta para llegar al ecuador de la campaña montera y podemos afirmar que ésta, en líneas generales, está respondiendo incluso mejor de lo esperado, con venados y jabalíes -también gamos y muflones- dando muchas satisfacciones a los cazadores.<br><br>Y eso que llevamos poco más de un mes cazando en algunas autonomías –dos a lo sumo en las comunidades autónomas más madrugadoras a la hora de desvedar la caza mayor-, y eso que en este tiempo lo normal es que se falle más de la cuenta desde los puestos porque el personal aún no ha afinado la puntería, y eso que las semanas transcurridas no son las mejores para las rehalas porque aún no han adquirido el punto idóneo de forma física para batir las manchas en las mejores condiciones, y eso que en las primeras citas serranas los cochinos, sobre todos los macarenos o navajeros, flojearon algo en los tapetes de reses por no encontrarse aún fijados en las querencias propias de las fechas en las que nos encontrábamos debido al mucho calor padecido aún en muchos de nuestros montes, y eso...<br><br>Pues bien, a pesar de todo, la temporada de monterías ha ido consumiendo jornadas de caza y los resultados han ido respondiendo a lo que se esperaba antes del desvede general, incluso en algunos casos por encima de lo esperado.<br><br>Si bien los jabalíes no estuvieron a la altura de las circunstancias en las citas inaugurales por diversos motivos (no encontrarse aún en las manchas a montear a principios del ejercicio, demasiada densidad de cervuno en muchos cazaderos que acaba desfondando a los perros de rehala, canes aún lejos de su mejor versión a la hora de cazar los cochinos, etc.), poco a poco fueron recobrando su papel principal en esta modalidad venatoria y protagonizando lustrosos tapices cochineros.<br><br>Respecto al venado, bien desde el arranque hasta ahora. Lógicamente, mayor número y calidad en fincas cercadas, pero incluso en abierto, si ha disfrutado de alimento y tranquilidad, esta especie ha cumplido con creces, tanto machos como hembras, cazándose muchas de estas últimas como medida de gestión en la mayoría de monterías con presencia de cervuno.<br><br>También los gamos y los muflones han tenido un papel destacado en numerosos cazaderos en este primer tercio de la campaña de monterías, con capturas abultadas y bastantes trofeos homologables en muchos casos.<br><br>El lado malo<br><br>Sin embargo, no podemos olvidar que ésta, como otras temporadas anteriores, se encuentra enmarcada en un contexto de profunda crisis económica y cinegética, de ahí que todo lo anterior no es que esté alejado de la realidad, sino que se refiere a las monterías que sí han tenido lugar, no a aquéllas que han sido suspendidas por falta de contratación de los puestos, o a aquéllas que no han aparecido en los calendarios de las orgánicas por falta de acuerdos con los propietarios de los terrenos, etc.<br><br>Los precios de los puestos y de las acciones completas han vuelto a bajar considerablemente este año (se estima que un 20%), pero aun así hay un amplio sector de cazadores para el que los mismos siguen siendo inalcanzables, de forma que para poder montear esperan a las ofertas de última hora o a hacerse con algunos de los puestos con los que ahora se estila pagar a las rehalas, las cuales lo están pasando muy mal para mantenerse en la brecha venatoria porque a sus propietarios les cuesta cada vez más mantenerlas y esos puestos con los que se les paga a muchas no son tan fáciles de vender. Esto ha llevado a no pocos rehaleros, tanto buenos como regulares y malos, a tirar la toalla.<br><br>Para finalizar<br><br>Sólo cabe esperar que, de aquí a que termine el curso montero, sobre todo en el inicio del nuevo año, este manifiesto desequilibrio entre el buen momento que disfrutan nuestros cotos y fincas y el malo que padecen bastantes aficionados tienda a reducirse para que podamos afirmar, al hacer balance de esta temporada de monterías 2013-14, que hemos vivido una de las mejores campañas de los últimos tiempos en todos los sentidos.");
			noticia.setLugar("España");
			noticia.setUsTexto("Texto: José María García / Fotos: Shutterstock, Alberto Aníbal-Álvarez y Archivo");
			noticia.setSubcat(null);
			noticia.setSubsubcat(null);
			Gson gson = new Gson();
			int resultado=1;
			//TODO aniadir llamada a servicio de inserción.
			
			String jsonNoticia=gson.toJson(resultado);
			System.out.println("Segunda noticia:"+jsonNoticia);
			ResponseBuilder builder = new ResponseBuilderImpl();
		       builder.type(MediaType.APPLICATION_JSON);
		       builder.entity(jsonNoticia);
		       return builder.build();	
	   			
	   	
	   	}
}

