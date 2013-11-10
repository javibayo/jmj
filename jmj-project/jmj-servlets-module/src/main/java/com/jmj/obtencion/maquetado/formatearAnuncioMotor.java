package com.jmj.obtencion.maquetado;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.jmj.beans.AnuncioO;
import com.jmj.obtencion.utils.Configuration;


public class formatearAnuncioMotor {

	/**
	 * @param args
	 */
	
	public formatearAnuncioMotor(){
		
		
	}
	
	private static String seccion=new Configuration().getConfig("anuncios.seccion");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leeFicheroAnuncio("1","1","http://www.milanuncios.com");
	}
	public static AnuncioO  leeFicheroAnuncio(String pagina,String anuncio,String urlActual){
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      ArrayList<AnuncioO> a=new ArrayList<AnuncioO>();
	      AnuncioO an=new AnuncioO("", "", "", "", "", "", "", "");
	      String accion="";
	      String categoria="";
	      String anunciante="";
	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File ("c:/"+seccion+"/pagina"+pagina+"consalto/anuncio"+anuncio+".info");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         
	         StringBuffer strb=new StringBuffer();
	         
	         
	         boolean tratandoBloque=false;
	         int tipoBloque=0;
	         int contadorDivsInternos=0;
	         while((linea=br.readLine())!=null){
	        	 //System.out.println(linea);
	            if(!tratandoBloque){
		            if(linea.startsWith("<div class=x3>")){
		            	int longitudCorte="<div class=x3>".length();
		            	String comienzoAccion=linea.substring(longitudCorte);
		            	int posicionCorteFin=comienzoAccion.lastIndexOf("</div>");
		            	accion=comienzoAccion.substring(0,posicionCorteFin);
		            }
		            if(linea.startsWith("<div class=x4>")){
		            	int longitudCorte="<div class=x4>".length();
		            	String comienzoAccion=linea.substring(longitudCorte);
		            	int posicionCorteFin=comienzoAccion.lastIndexOf("</div>");
		            	categoria=comienzoAccion.substring(0,posicionCorteFin);
		            }
		            if(linea.startsWith("<div class=x6")){
		            	tratandoBloque=true;
		            	tipoBloque=1;
		            	strb.append(linea);
		            }
		            if(linea.startsWith("<div class=x7")){
		            	tratandoBloque=true;
		            	tipoBloque=2;
		            	strb.append(linea);
		            }
	            }else{
	            	if(linea.indexOf("<td class=")!=-1 && !(linea.startsWith("<td class=gas>")||linea.startsWith("<td class=prg>")||linea.startsWith("<td class=prp>")||linea.startsWith("<td class=ano>")||linea.startsWith("<td class=die>")||linea.startsWith("<td class=kms>"))){
	            		System.out.println(linea);
	            	}
	            	
	            	strb.append(linea);
	            	if(tipoBloque==1){
	            		if(linea.indexOf("<div")!=-1)
	            		{
	            			contadorDivsInternos++;
	            		}
	            		if(linea.indexOf("</div>")!=-1 && contadorDivsInternos==0){
			            	//fin bloque anunciante
	            			anunciante=trataBloqueAnunciante(strb.toString());
	            			tipoBloque=0;
	            			tratandoBloque=false;
	            			strb.delete(0, strb.length());
			            }else if(linea.indexOf("</div>")!=-1){
			            	contadorDivsInternos--;
			            }
	            		
	            	}
	            	if(tipoBloque==2){
	            		if(linea.indexOf("<div")!=-1)
	            		{
	            			contadorDivsInternos++;
	            		}
	            		if(linea.indexOf("</div>")!=-1 && contadorDivsInternos==0){
			            	//fin bloque anuncio
	            			StringBuffer newStringBuffer = new StringBuffer(strb.toString().replaceAll("><", ">\n<"));  
	            			an=trataBloqueAnuncio(newStringBuffer.toString(),urlActual);
	            			tipoBloque=0;
	            			tratandoBloque=false;
	            			strb.delete(0, strb.length());
	            			contadorDivsInternos=0;
			            }else if(linea.indexOf("</div>")!=-1){
			            	contadorDivsInternos--;
			            }
	            		
	            	}
	            }
	         }
	         System.out.println(accion);
	         System.out.println(categoria);
	         System.out.println(anunciante);
	         System.out.println(an);
	         
	         
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	      an.setAnunciante(anunciante);
	      an.setAccion(accion);
	      an.setCategoria(categoria);
	      return an;
	}
	private static AnuncioO trataBloqueAnuncio(String anuncio,String urlActual) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(anuncio,"\n");
		String texto="";
		String url="";
		String titulo="";
		String prp="";
		String ano="";
		String carburante="";
		String kms="";
		String prg="";
		while(tokens.hasMoreTokens()){
			String linea=tokens.nextToken();
			 if(linea.startsWith("<span class=tx>")){
	            	int longitudCorte="<span class=tx>".length();
	            	String comienzoAccion=linea.substring(longitudCorte);
	            	int posicionCorteFin=comienzoAccion.lastIndexOf("</span>");
	            	texto=comienzoAccion.substring(0,posicionCorteFin);
	         }
			 if(linea.indexOf("class=cti>")!=-1){
			    	String comienzoAccion=linea.substring(linea.lastIndexOf("class=cti>")+"class=cti>".length());
			    	int posicionCorteFin=comienzoAccion.lastIndexOf("</a>");
			    	titulo=comienzoAccion.substring(0,posicionCorteFin);
			}
			if(linea.indexOf("class=cti>")!=-1){
		    	String comienzoAccion=linea.substring(0,linea.lastIndexOf("\" class=cti>"));
		    	int posicionCorteFin=comienzoAccion.lastIndexOf("</a>");
		    	url=urlActual+comienzoAccion.substring("<a href=\"".length());
			}
			 if(linea.startsWith("<td class=prp>")){
	            	int longitudCorte="<td class=prp>".length();
	            	String comienzoAccion=linea.substring(longitudCorte);
	            	int posicionCorteFin=comienzoAccion.lastIndexOf("</td>");
	            	if(posicionCorteFin!=-1)
	            		prp=comienzoAccion.substring(0,posicionCorteFin);
	         }
			 if(linea.startsWith("<td class=prg>")){
	            	int longitudCorte="<td class=prg>".length();
	            	String comienzoAccion=linea.substring(longitudCorte);
	            	int posicionCorteFin=comienzoAccion.lastIndexOf("</td>");
	            	if(posicionCorteFin!=-1)
	            		prp=comienzoAccion.substring(0,posicionCorteFin);
	         }
			 if(linea.startsWith("<td class=ano>")){
	            	int longitudCorte="<td class=ano>".length();
	            	String comienzoAccion=linea.substring(longitudCorte);
	            	int posicionCorteFin=comienzoAccion.lastIndexOf("</td>");
	            	if(posicionCorteFin!=-1)	
	            		ano=comienzoAccion.substring(0,posicionCorteFin);
	         }
			 if(linea.startsWith("<td class=die>")||linea.startsWith("<td class=gas>")){
	            	int longitudCorte="<td class=".length();
	            	String comienzoAccion=linea.substring(longitudCorte);
	            	int posicionCorteFin=comienzoAccion.lastIndexOf(">");
	            	if(posicionCorteFin!=-1)
	            		carburante=comienzoAccion.substring(0,posicionCorteFin);
	         }
			 if(linea.startsWith("<td class=kms>")){
	            	int longitudCorte="<td class=kms>".length();
	            	String comienzoAccion=linea.substring(longitudCorte);
	            	int posicionCorteFin=comienzoAccion.lastIndexOf("</td>");
	            	if(posicionCorteFin!=-1)
	            			kms=comienzoAccion.substring(0,posicionCorteFin);
	         }
			
		}
		AnuncioO an=new AnuncioO(texto, url, titulo, prp, ano, carburante, kms, prg);
		
		return an;
	}
	private static String trataBloqueAnunciante(String anunciante) {
		// TODO Auto-generated method stub
		String retorno="";
		if(anunciante.indexOf("<a")!=-1){
	    	String comienzoAccion=anunciante.substring(anunciante.lastIndexOf("\">")+2);
	    	int posicionCorteFin=comienzoAccion.lastIndexOf("</a>");
	    	retorno=comienzoAccion.substring(0,posicionCorteFin);
		}else{
			int longitudCorte="<div class=x6>".length();
        	String comienzoAccion=anunciante.substring(longitudCorte);
        	int posicionCorteFin=comienzoAccion.lastIndexOf("</div>");
        	retorno=comienzoAccion.substring(0,posicionCorteFin);
		}
		return retorno;
	}
}
