package com.jmj.beans;

public class AnuncioO {
	

	private String texto="";
	private String url="";
	private String titulo="";
	private String accion="";
	private String categoria="";
	private String anunciante="";
	private String prp="";
	private String id="";
	private String ano="";
	private String carburante="";
	private String kms="";
	private String prg="";
	
	public AnuncioO(){
		
	}
	
	public AnuncioO(String texto2, String url2, String titulo2, String prp2,
			String ano2, String carburante, String kms, String prg) {
		// TODO Auto-generated constructor stub
		this.setTexto(texto2);
		this.setUrl(url2);
		this.setTitulo(titulo2);
		this.setPrp(prp2);
		this.setAno(ano2);
		this.setCarburante(carburante);
		this.setKms(kms);
		this.setPrg(prg);
	}
	
	public String getKms() {
		return kms;
	}
	public void setKms(String kms) {
		this.kms = kms;
	}
	public String getPrg() {
		return prg;
	}
	public void setPrg(String prg) {
		this.prg = prg;
	}
	
	public String getCarburante() {
		return carburante;
	}
	public void setCarburante(String carburante) {
		this.carburante = carburante;
	}
	
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrp() {
		return prp;
	}
	public void setPrp(String prp) {
		this.prp = prp;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getAnunciante() {
		return anunciante;
	}
	public void setAnunciante(String anunciante) {
		this.anunciante = anunciante;
	}
	
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String toString(){
		return "\n\ttitulo: "+titulo+" \n\turl: "+url+" \n\ttexto:"+texto+"\n\tprp:"+prp+"\n\tano:"+ano+"\n\tid:"+id+"\n";
	}
	
}
