package com.jmj.beans;

public class Coche extends AnuncioO{

	public Coche(String texto2, String url2, String titulo2, String prp2,
			String ano2, String carburante, String kms, String prg) {
		super(texto2, url2, titulo2, prp2, ano2, carburante, kms, prg);
		// TODO Auto-generated constructor stub
	}

	private String prp="";
	private String prg="";
	private String ano="";
	private String carburante="";
	private String kms="";
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getKms() {
		return kms;
	}
	public void setKms(String kms) {
		this.kms = kms;
	}
	public String getPrp() {
		return prp;
	}
	public void setPrp(String prp) {
		this.prp = prp;
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
	
	public String toString(){
		return super.toString()+" \n\tprp:"+prp+" \n\tano:"+ano+" \n\tcarburante:"+carburante+" \n\tkms:"+kms+" \n\tprg:"+prg;
	}
}
