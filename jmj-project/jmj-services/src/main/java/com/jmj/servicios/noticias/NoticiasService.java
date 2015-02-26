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
			noticia.setTitulo("As� va la temporada de monter�as");
			noticia.setResumen("Poco falta para llegar al ecuador de la campa�a montera y podemos afirmar que �sta, en l�neas generales, est� respondiendo incluso mejor de lo esperado, con venados y jabal�es -tambi�n gamos y muflones- dando muchas satisfacciones a los cazadores.");
			noticia.setDescripcion("Poco falta para llegar al ecuador de la campa�a montera y podemos afirmar que �sta, en l�neas generales, est� respondiendo incluso mejor de lo esperado, con venados y jabal�es -tambi�n gamos y muflones- dando muchas satisfacciones a los cazadores.<br><br>Y eso que llevamos poco m�s de un mes cazando en algunas autonom�as �dos a lo sumo en las comunidades aut�nomas m�s madrugadoras a la hora de desvedar la caza mayor-, y eso que en este tiempo lo normal es que se falle m�s de la cuenta desde los puestos porque el personal a�n no ha afinado la punter�a, y eso que las semanas transcurridas no son las mejores para las rehalas porque a�n no han adquirido el punto id�neo de forma f�sica para batir las manchas en las mejores condiciones, y eso que en las primeras citas serranas los cochinos, sobre todos los macarenos o navajeros, flojearon algo en los tapetes de reses por no encontrarse a�n fijados en las querencias propias de las fechas en las que nos encontr�bamos debido al mucho calor padecido a�n en muchos de nuestros montes, y eso...<br><br>Pues bien, a pesar de todo, la temporada de monter�as ha ido consumiendo jornadas de caza y los resultados han ido respondiendo a lo que se esperaba antes del desvede general, incluso en algunos casos por encima de lo esperado.<br><br>Si bien los jabal�es no estuvieron a la altura de las circunstancias en las citas inaugurales por diversos motivos (no encontrarse a�n en las manchas a montear a principios del ejercicio, demasiada densidad de cervuno en muchos cazaderos que acaba desfondando a los perros de rehala, canes a�n lejos de su mejor versi�n a la hora de cazar los cochinos, etc.), poco a poco fueron recobrando su papel principal en esta modalidad venatoria y protagonizando lustrosos tapices cochineros.<br><br>Respecto al venado, bien desde el arranque hasta ahora. L�gicamente, mayor n�mero y calidad en fincas cercadas, pero incluso en abierto, si ha disfrutado de alimento y tranquilidad, esta especie ha cumplido con creces, tanto machos como hembras, caz�ndose muchas de estas �ltimas como medida de gesti�n en la mayor�a de monter�as con presencia de cervuno.<br><br>Tambi�n los gamos y los muflones han tenido un papel destacado en numerosos cazaderos en este primer tercio de la campa�a de monter�as, con capturas abultadas y bastantes trofeos homologables en muchos casos.<br><br>El lado malo<br><br>Sin embargo, no podemos olvidar que �sta, como otras temporadas anteriores, se encuentra enmarcada en un contexto de profunda crisis econ�mica y cineg�tica, de ah� que todo lo anterior no es que est� alejado de la realidad, sino que se refiere a las monter�as que s� han tenido lugar, no a aqu�llas que han sido suspendidas por falta de contrataci�n de los puestos, o a aqu�llas que no han aparecido en los calendarios de las org�nicas por falta de acuerdos con los propietarios de los terrenos, etc.<br><br>Los precios de los puestos y de las acciones completas han vuelto a bajar considerablemente este a�o (se estima que un 20%), pero aun as� hay un amplio sector de cazadores para el que los mismos siguen siendo inalcanzables, de forma que para poder montear esperan a las ofertas de �ltima hora o a hacerse con algunos de los puestos con los que ahora se estila pagar a las rehalas, las cuales lo est�n pasando muy mal para mantenerse en la brecha venatoria porque a sus propietarios les cuesta cada vez m�s mantenerlas y esos puestos con los que se les paga a muchas no son tan f�ciles de vender. Esto ha llevado a no pocos rehaleros, tanto buenos como regulares y malos, a tirar la toalla.<br><br>Para finalizar<br><br>S�lo cabe esperar que, de aqu� a que termine el curso montero, sobre todo en el inicio del nuevo a�o, este manifiesto desequilibrio entre el buen momento que disfrutan nuestros cotos y fincas y el malo que padecen bastantes aficionados tienda a reducirse para que podamos afirmar, al hacer balance de esta temporada de monter�as 2013-14, que hemos vivido una de las mejores campa�as de los �ltimos tiempos en todos los sentidos.");
			noticia.setLugar("Espa�a");
			noticia.setUsTexto("Texto: Jos� Mar�a Garc�a / Fotos: Shutterstock, Alberto An�bal-�lvarez y Archivo");
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
					noticia.setTitulo("As� va la temporada de monter�as");
					noticia.setResumen("Poco falta para llegar al ecuador de la campa�a montera y podemos afirmar que �sta, en l�neas generales, est� respondiendo incluso mejor de lo esperado, con venados y jabal�es -tambi�n gamos y muflones- dando muchas satisfacciones a los cazadores.");
					noticia.setDescripcion("Poco falta para llegar al ecuador de la campa�a montera y podemos afirmar que �sta, en l�neas generales, est� respondiendo incluso mejor de lo esperado, con venados y jabal�es -tambi�n gamos y muflones- dando muchas satisfacciones a los cazadores.<br><br>Y eso que llevamos poco m�s de un mes cazando en algunas autonom�as �dos a lo sumo en las comunidades aut�nomas m�s madrugadoras a la hora de desvedar la caza mayor-, y eso que en este tiempo lo normal es que se falle m�s de la cuenta desde los puestos porque el personal a�n no ha afinado la punter�a, y eso que las semanas transcurridas no son las mejores para las rehalas porque a�n no han adquirido el punto id�neo de forma f�sica para batir las manchas en las mejores condiciones, y eso que en las primeras citas serranas los cochinos, sobre todos los macarenos o navajeros, flojearon algo en los tapetes de reses por no encontrarse a�n fijados en las querencias propias de las fechas en las que nos encontr�bamos debido al mucho calor padecido a�n en muchos de nuestros montes, y eso...<br><br>Pues bien, a pesar de todo, la temporada de monter�as ha ido consumiendo jornadas de caza y los resultados han ido respondiendo a lo que se esperaba antes del desvede general, incluso en algunos casos por encima de lo esperado.<br><br>Si bien los jabal�es no estuvieron a la altura de las circunstancias en las citas inaugurales por diversos motivos (no encontrarse a�n en las manchas a montear a principios del ejercicio, demasiada densidad de cervuno en muchos cazaderos que acaba desfondando a los perros de rehala, canes a�n lejos de su mejor versi�n a la hora de cazar los cochinos, etc.), poco a poco fueron recobrando su papel principal en esta modalidad venatoria y protagonizando lustrosos tapices cochineros.<br><br>Respecto al venado, bien desde el arranque hasta ahora. L�gicamente, mayor n�mero y calidad en fincas cercadas, pero incluso en abierto, si ha disfrutado de alimento y tranquilidad, esta especie ha cumplido con creces, tanto machos como hembras, caz�ndose muchas de estas �ltimas como medida de gesti�n en la mayor�a de monter�as con presencia de cervuno.<br><br>Tambi�n los gamos y los muflones han tenido un papel destacado en numerosos cazaderos en este primer tercio de la campa�a de monter�as, con capturas abultadas y bastantes trofeos homologables en muchos casos.<br><br>El lado malo<br><br>Sin embargo, no podemos olvidar que �sta, como otras temporadas anteriores, se encuentra enmarcada en un contexto de profunda crisis econ�mica y cineg�tica, de ah� que todo lo anterior no es que est� alejado de la realidad, sino que se refiere a las monter�as que s� han tenido lugar, no a aqu�llas que han sido suspendidas por falta de contrataci�n de los puestos, o a aqu�llas que no han aparecido en los calendarios de las org�nicas por falta de acuerdos con los propietarios de los terrenos, etc.<br><br>Los precios de los puestos y de las acciones completas han vuelto a bajar considerablemente este a�o (se estima que un 20%), pero aun as� hay un amplio sector de cazadores para el que los mismos siguen siendo inalcanzables, de forma que para poder montear esperan a las ofertas de �ltima hora o a hacerse con algunos de los puestos con los que ahora se estila pagar a las rehalas, las cuales lo est�n pasando muy mal para mantenerse en la brecha venatoria porque a sus propietarios les cuesta cada vez m�s mantenerlas y esos puestos con los que se les paga a muchas no son tan f�ciles de vender. Esto ha llevado a no pocos rehaleros, tanto buenos como regulares y malos, a tirar la toalla.<br><br>Para finalizar<br><br>S�lo cabe esperar que, de aqu� a que termine el curso montero, sobre todo en el inicio del nuevo a�o, este manifiesto desequilibrio entre el buen momento que disfrutan nuestros cotos y fincas y el malo que padecen bastantes aficionados tienda a reducirse para que podamos afirmar, al hacer balance de esta temporada de monter�as 2013-14, que hemos vivido una de las mejores campa�as de los �ltimos tiempos en todos los sentidos.");
					noticia.setLugar("Espa�a");
					noticia.setUsTexto("Texto: Jos� Mar�a Garc�a / Fotos: Shutterstock, Alberto An�bal-�lvarez y Archivo");
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
			noticia.setTitulo("As� va la temporada de monter�as");
			noticia.setResumen("Poco falta para llegar al ecuador de la campa�a montera y podemos afirmar que �sta, en l�neas generales, est� respondiendo incluso mejor de lo esperado, con venados y jabal�es -tambi�n gamos y muflones- dando muchas satisfacciones a los cazadores.");
			noticia.setDescripcion("Poco falta para llegar al ecuador de la campa�a montera y podemos afirmar que �sta, en l�neas generales, est� respondiendo incluso mejor de lo esperado, con venados y jabal�es -tambi�n gamos y muflones- dando muchas satisfacciones a los cazadores.<br><br>Y eso que llevamos poco m�s de un mes cazando en algunas autonom�as �dos a lo sumo en las comunidades aut�nomas m�s madrugadoras a la hora de desvedar la caza mayor-, y eso que en este tiempo lo normal es que se falle m�s de la cuenta desde los puestos porque el personal a�n no ha afinado la punter�a, y eso que las semanas transcurridas no son las mejores para las rehalas porque a�n no han adquirido el punto id�neo de forma f�sica para batir las manchas en las mejores condiciones, y eso que en las primeras citas serranas los cochinos, sobre todos los macarenos o navajeros, flojearon algo en los tapetes de reses por no encontrarse a�n fijados en las querencias propias de las fechas en las que nos encontr�bamos debido al mucho calor padecido a�n en muchos de nuestros montes, y eso...<br><br>Pues bien, a pesar de todo, la temporada de monter�as ha ido consumiendo jornadas de caza y los resultados han ido respondiendo a lo que se esperaba antes del desvede general, incluso en algunos casos por encima de lo esperado.<br><br>Si bien los jabal�es no estuvieron a la altura de las circunstancias en las citas inaugurales por diversos motivos (no encontrarse a�n en las manchas a montear a principios del ejercicio, demasiada densidad de cervuno en muchos cazaderos que acaba desfondando a los perros de rehala, canes a�n lejos de su mejor versi�n a la hora de cazar los cochinos, etc.), poco a poco fueron recobrando su papel principal en esta modalidad venatoria y protagonizando lustrosos tapices cochineros.<br><br>Respecto al venado, bien desde el arranque hasta ahora. L�gicamente, mayor n�mero y calidad en fincas cercadas, pero incluso en abierto, si ha disfrutado de alimento y tranquilidad, esta especie ha cumplido con creces, tanto machos como hembras, caz�ndose muchas de estas �ltimas como medida de gesti�n en la mayor�a de monter�as con presencia de cervuno.<br><br>Tambi�n los gamos y los muflones han tenido un papel destacado en numerosos cazaderos en este primer tercio de la campa�a de monter�as, con capturas abultadas y bastantes trofeos homologables en muchos casos.<br><br>El lado malo<br><br>Sin embargo, no podemos olvidar que �sta, como otras temporadas anteriores, se encuentra enmarcada en un contexto de profunda crisis econ�mica y cineg�tica, de ah� que todo lo anterior no es que est� alejado de la realidad, sino que se refiere a las monter�as que s� han tenido lugar, no a aqu�llas que han sido suspendidas por falta de contrataci�n de los puestos, o a aqu�llas que no han aparecido en los calendarios de las org�nicas por falta de acuerdos con los propietarios de los terrenos, etc.<br><br>Los precios de los puestos y de las acciones completas han vuelto a bajar considerablemente este a�o (se estima que un 20%), pero aun as� hay un amplio sector de cazadores para el que los mismos siguen siendo inalcanzables, de forma que para poder montear esperan a las ofertas de �ltima hora o a hacerse con algunos de los puestos con los que ahora se estila pagar a las rehalas, las cuales lo est�n pasando muy mal para mantenerse en la brecha venatoria porque a sus propietarios les cuesta cada vez m�s mantenerlas y esos puestos con los que se les paga a muchas no son tan f�ciles de vender. Esto ha llevado a no pocos rehaleros, tanto buenos como regulares y malos, a tirar la toalla.<br><br>Para finalizar<br><br>S�lo cabe esperar que, de aqu� a que termine el curso montero, sobre todo en el inicio del nuevo a�o, este manifiesto desequilibrio entre el buen momento que disfrutan nuestros cotos y fincas y el malo que padecen bastantes aficionados tienda a reducirse para que podamos afirmar, al hacer balance de esta temporada de monter�as 2013-14, que hemos vivido una de las mejores campa�as de los �ltimos tiempos en todos los sentidos.");
			noticia.setLugar("Espa�a");
			noticia.setUsTexto("Texto: Jos� Mar�a Garc�a / Fotos: Shutterstock, Alberto An�bal-�lvarez y Archivo");
			noticia.setSubcat(null);
			noticia.setSubsubcat(null);
			Gson gson = new Gson();
			int resultado=1;
			//TODO aniadir llamada a servicio de inserci�n.
			
			String jsonNoticia=gson.toJson(resultado);
			System.out.println("Segunda noticia:"+jsonNoticia);
			ResponseBuilder builder = new ResponseBuilderImpl();
		       builder.type(MediaType.APPLICATION_JSON);
		       builder.entity(jsonNoticia);
		       return builder.build();	
	   			
	   	
	   	}
}

