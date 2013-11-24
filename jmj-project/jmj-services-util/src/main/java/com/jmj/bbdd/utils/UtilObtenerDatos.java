package com.jmj.bbdd.utils;

public class UtilObtenerDatos {
	
/*	public static void compruebaDatosAltauser (String peticion, TLEXdatosEntrada datosEntrada) throws Throwable
	{
		String aplicacion = datosEntrada.getAplicacionID();
		Trace.trace(Trace.Information,"aplicacion ID =" +aplicacion);
		// Se recupera el valor del campo causeID
		String causeID = TLEXUtilsTPVA.getValorEtiquetaEnXML(TLEXCxTPVA.CAUSEID, peticion);
		// Si el campo no viene informado a la entrada del servlet, se lee de configuración:
		if(causeID== null || "".equals(causeID))
		{
			causeID=TLEXUtilsTPVA.leeProperties(TLEXCxTPVA.CFG_CAUSEID,aplicacion);
		}
		Trace.trace(Trace.Information,"CauseID = "+causeID);	
		datosEntrada.setCauseID(causeID);		
		
		
		String currency = TLEXUtilsTPVA.getValorEtiquetaEnXML(TLEXCxTPVA.CURRENCY, peticion);	
		if(currency== null || "".equals(currency))
		{
			currency=TLEXUtilsTPVA.leeProperties(TLEXCxTPVA.CFG_CURRENCY, aplicacion);
		}
		Trace.trace(Trace.Information,"currency = "+currency);		
	}
*/
}
