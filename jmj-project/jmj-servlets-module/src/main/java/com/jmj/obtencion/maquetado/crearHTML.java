package com.jmj.obtencion.maquetado;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang3.StringEscapeUtils;

import com.jmj.beans.AnuncioO;
import com.jmj.obtencion.utils.AccesoBBDD;
import com.jmj.obtencion.utils.AccesoFicheros;
import com.jmj.obtencion.utils.Configuration;


public class crearHTML {

	/**
	 * @param args
	 */
	private static String seccion=new Configuration().getConfig("anuncios.seccion");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static void createhtml(String nombre, ArrayList<AnuncioO> elementos){
		
		StringBuffer strb=new StringBuffer();
		
		Iterator i = elementos.iterator();
		
		AnuncioO a=null;
		while(i.hasNext()){
			a=(AnuncioO)i.next();
			
			//AccesoBBDD.insertaAnuncioBBDD(a);
			
			String[] categ=tratarCategoria(a.getCategoria());
			
			strb.append("<div class=\"post\">");
			strb.append("<h2 class=\"title\"><a href=\"#\">").append(categ[0]).append("</a></h2>");
			strb.append("<p class=\"meta\"><span class=\"date\"><strong>").append(a.getAno()).append("</strong></span><span class=\"posted\">Posted from <a href=\"#\">").append(categ[1]).append("</a></span></p>");
			strb.append("<div style=\"clear: both;\">&nbsp;</div>");
			strb.append("<div class=\"entry\">");
			strb.append("<p>").append(toEncoding(a.getTexto())).append("</p>");
			strb.append("<p class=\"links\"><a href=\"#\">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\">Comments</a></p>");
			strb.append("</div>");
			strb.append("</div>");
		}
		
		
		
		AccesoFicheros.escribeEnFichero("C:\\xampp\\htdocs\\Negocio\\templates\\Blog.html",strb.toString());
	}
	


private static String[] tratarCategoria(String categoria) {
		int posicionLast=categoria.lastIndexOf("(");
		String[] retorno=new String[2];
		if(posicionLast!=-1){
			retorno[0]=categoria.substring(0,posicionLast);
			retorno[1]=categoria.substring(posicionLast+1,categoria.length()-1);
		}else{
			retorno[0]=categoria;
			retorno[1]="";
		}
		
		return retorno;
	}

	public static String toEncoding(String texto){
		System.out.println(StringEscapeUtils.escapeHtml4(texto));
		return StringEscapeUtils.escapeHtml4(texto);
	}

}
