package com.jmj.constantes;

public interface CxDatosBBDD {
	
	public final static String USERBBDD ="root";	
	public final static String PASSWORDBBDD ="";
	public final static String URLBBDD ="jdbc:mysql://localhost:3306/jmj";
	

//	public final static String COMILLA = "'";
//	public final static String COMA = ",";
//	public final static String COMILLACOMA = "','";
//	public final static String PARENTESIS = "')";
//	public final static String IGUAL = "= '";
	
	// Nombre de las columnas de las tablas de la BBDD
	public final static String USUARIO="COD_USUARIO";
	public final static String PASSWORD="COD_PASSWORD";	
	public final static String NOMBRE="DES_NOMBRE";	
	public final static String APELLIDO1="DES_APELLI1";	
	public final static String APELLIDO2="DES_APELLI2";		
	public final static String FEC_NACIM="FEC_NACIM";		
	public final static String XTI_SEXO="XTI_SEXO";		
	public final static String DES_DIRECC="DES_DIRECC";	
	public final static String COD_POSTAL="COD_POSTAL";	
	public final static String PROVIN="DES_PROVIN";	
	public final static String LOCALIDAD="DES_LOCALID";	
	public final static String COD_NUMTLF="COD_NUMTLF";	
	
	public final static String COD_TITULO = "COD_TITULO";
	public final static String COD_NOTICIA = "COD_NOTICIA";
	public final static String DES_RESUMEN = "DES_RESUMEN";
	public final static String COD_LUGAR = "COD_LUGAR";
	public final static String COD_USTEXTO = "COD_USTEXTO";
	public final static String DES_DESCRIP = "DES_DESCRIP";
	public final static String XTI_CATEGOR = "XTI_CATEGOR";
	public final static String XTI_SUBCAT = "XTI_SUBCAT";
	public final static String XTI_SUBSUBCA = "XTI_SUBSUBCA";
	public final static String COD_USUARIO = "COD_USUARIO";
	public final static String AUD_TIMFMOD = "AUD_TIMFMOD";
	
	public final static String CATEG_DEFECTO="0";	
	public final static String SUBCATEG_DEFECTO="0";	
	public final static String SUBSUBCATEG_DEFECTO="0";	
	
	//Query select provincias
	public final static String PROVINCIAS = "SELECT DES_PROVIN FROM JMJ.TJMJPROV";
	public final static String LOCALIDADES = "SELECT DES_LOCALID FROM JMJ.TJMJLOCAL WHERE DES_PROVIN = ?";

	// Query Logon
	public final static String LOGON1 = "SELECT COUNT(*) FROM JMJ.TJMJUSER WHERE COD_USUARIO=? AND COD_PASSWORD = ?";
	
	public final static String LOGON2 = "SELECT COUNT(*) FROM JMJ.TJMJUSER WHERE COD_USUARIO=?";
	
	//Query actualizar contraseña
	
	public final static String PASSW1 = "UPDATE JMJ.TJMJUSER SET COD_PASSWORD = ? WHERE COD_USUARIO =?";
	
	//Query dar de alta nuevo usuario
	
	public final static String INSERTUSER1 ="INSERT INTO JMJ.TJMJUSER (COD_USUARIO, COD_PASSWORD, DES_NOMBRE, DES_APELLI1, DES_APELLI2, FEC_NACIM, XTI_SEXO, DES_DIRECC, COD_POSTAL, DES_LOCALID, DES_PROVIN, COD_NUMTLF, DES_CLAVEACT, XTI_ESTADO, AUD_TIMFMOD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,'P',CURRENT_TIMESTAMP)";
	
	//Query que permite consultar la info de un usuario
	
	public final static String INFOUSUARIO = "SELECT DES_NOMBRE, DES_APELLI1, DES_APELLI2, FEC_NACIM, XTI_SEXO, DES_DIRECC, COD_POSTAL, DES_LOCALID, DES_PROVIN, COD_NUMTLF FROM INTO JMJ.TJMJUSER WHERE COD_USUARIO =?";
	
	
	//Query que permite actualizar info del usuario
	
	public final static String UPDINFO1 = "UPDATE JMJ.TJMJUSER set DES_NOMBRE= ?,DES_APELLI1=?, DES_APELLI2=?, FEC_NACIM=?, XTI_SEXO=?, DES_DIRECC=?, COD_POSTAL=?, DES_LOCALID=?, DES_PROVIN=?, COD_NUMTLF=? where COD_USUARIO = ?";
	
	//Query validación clave
	
	public final static String VALIDARCLAVE = "SELECT COUNT(*) FROM JMJ.TJMJUSER WHERE COD_USUARIO=? AND DES_CLAVEACT=?";
	
	//Query actualizar estado
	
	public final static String ESTADOUSER = "UPDATE JMJ.TJMJUSER SET XTI_ESTADO = ? WHERE COD_USUARIO =?";
	
	//Query dar de alta nuevo usuario
	
	public final static String INSERTNOTICIA="INSERT INTO JMJ.TJMJNEWS (COD_TITULO, DES_RESUMEN, DES_DESCRIP, COD_LUGAR, COD_USTEXTO, XTI_CATEGOR, XTI_SUBCAT, XTI_SUBSUBCA, COD_USUARIO,XTI_ESTADO, AUD_TIMFMOD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,'1',CURRENT_TIMESTAMP)";
	
	//Query actualizar estado noticia
	
	public final static String ESTADO_NOTICIA = "UPDATE JMJ.TJMJNEWS SET XTI_ESTADO = ? WHERE COD_NOTICIA =?";
	
	//Query actualizar estado categoria de noticia
	
	public final static String CATEG_NOTICIA = "UPDATE JMJ.TJMJNEWS SET XTI_CATEGOR =?, XTI_SUBCAT=?, XTI_SUBSUBCA=? WHERE COD_NOTICIA =?";
	
	//Query select noticias1
	public final static String NOTICIAS1 = "SELECT COD_TITULO, COD_NOTICIA, DES_RESUMEN, COD_LUGAR, COD_USTEXTO FROM JMJ.TJMJNEWS WHERE XTI_ESTADO = '1'";
	public final static String NOTICIAS_TODAS = " AND XTI_CATEGOR = ? AND XTI_SUBCAT=? AND XTI_SUBSUBCA=? ORDER BY ";
	public final static String NOTICIAS_2 = " AND XTI_CATEGOR = ? AND XTI_SUBCAT=? ORDER BY ";
	public final static String NOTICIAS_3 = " AND XTI_CATEGOR = ? ORDER BY ";
	
	public final static String ASC = " ASC";
	public final static String DESC= " DESC";
	
	public final static String ORDERBY= " ORDER BY ";
	
	
	//Query select detalle de noticia
	public final static String DETALLENOTICIA="SELECT COD_TITULO, DES_RESUMEN, DES_DESCRIP, COD_LUGAR, COD_USTEXTO, XTI_CATEGOR, XTI_SUBCAT, XTI_SUBSUBCA, COD_USUARIO, AUD_TIMFMOD  FROM JMJ.TJMJNEWS WHERE XTI_ESTADO = '1' AND COD_NOTICIA =?";
	
}
