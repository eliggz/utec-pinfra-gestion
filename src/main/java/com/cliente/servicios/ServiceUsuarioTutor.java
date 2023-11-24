package com.cliente.servicios;

import javax.naming.InitialContext;

import com.servidor.beans.UsuarioTutorBeanRemote;
import com.servidor.entidades.UsuarioTutor;

public class ServiceUsuarioTutor {

	
	private static UsuarioTutorBeanRemote getService() {
		try {
			UsuarioTutorBeanRemote usuarioBean = (UsuarioTutorBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/UsuarioTutorBean!com.servidor.beans.UsuarioTutorBeanRemote");
			return usuarioBean;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static UsuarioTutor crearUsuarioTutor(UsuarioTutor usuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.crearUsuarioTutor(usuario);
		} catch (Exception e) {
			return null;
		}
	}
}
