package com.jmj.servicios.bbdd;

import java.util.ArrayList;

import com.jmj.beans.AnuncioO;

public interface AccesoBBDD {

		public ArrayList<AnuncioO> getAnuncio(int anuncio);
		
		public boolean getUsuario(String usuario);
}
