package com.jmj.beans;

public class Noticia {
	private String codNoticia;
	private String titulo;
	private String resumen;
	private String descripcion;
	private String lugar;
	private String usTexto;
	private String categoria;
	private String subcat;
	private String subsubcat;
	private String estado;
	private String usuario;
	private String aud_timfmod;
	
	public void setCodNoticia(String codNoticia) {
		this.codNoticia = codNoticia;
	}
	public String getCodNoticia() {
		return codNoticia;
	}
	public  void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public  String getTitulo() {
		return titulo;
	}
	public  void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public  String getResumen() {
		return resumen;
	}
	public  void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public  String getDescripcion() {
		return descripcion;
	}
	public  void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public  String getLugar() {
		return lugar;
	}
	public void setUsTexto(String usTexto) {
		this.usTexto = usTexto;
	}
	public String getUsTexto() {
		return usTexto;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setSubcat(String subcat) {
		this.subcat = subcat;
	}
	public String getSubcat() {
		return subcat;
	}
	public void setSubsubcat(String subsubcat) {
		this.subsubcat = subsubcat;
	}
	public String getSubsubcat() {
		return subsubcat;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setAudTimfmod(String aud_timfmod) {
		this.aud_timfmod = aud_timfmod;
	}
	public String getAudTimfmod() {
		return aud_timfmod;
	}
}
