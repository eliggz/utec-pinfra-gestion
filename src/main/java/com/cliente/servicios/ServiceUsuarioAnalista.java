package com.cliente.servicios;

import javax.naming.InitialContext;

import com.servidor.beans.UsuarioAnalistaBeanRemote;
import com.servidor.beans.UsuarioBeanRemote;
import com.servidor.entidades.UsuarioAnalista;

public class ServiceUsuarioAnalista {
	
	
	
	private static UsuarioAnalistaBeanRemote getService() {
		try {
			UsuarioAnalistaBeanRemote usuarioBean = (UsuarioAnalistaBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/UsuarioAnalistaBean!com.servidor.beans.UsuarioAnalistaBeanRemote");
			return usuarioBean;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static UsuarioAnalista crearUsuarioAnalista(UsuarioAnalista usuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.crearUsuarioAnalista(usuario);
		} catch (Exception e) {
			return null;
		}
	}
}
