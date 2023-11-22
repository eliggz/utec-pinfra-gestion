package com.cliente.servicios;

import java.util.ArrayList;

import javax.naming.InitialContext;


import com.servidor.beans.UsuarioEstudianteBeanRemote;
import com.servidor.entidades.UsuarioEstudiante;

public class ServiceUsuarioEstudiante {

	
	private static UsuarioEstudianteBeanRemote getService() {
		try {
			UsuarioEstudianteBeanRemote usuarioEstudianteBean = (UsuarioEstudianteBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/UsuarioEstudianteBean!com.servidor.beans.UsuarioEstudianteBeanRemote");
			return usuarioEstudianteBean;
		} catch (Exception e) {
			return null;
		}
	}
	
	

	public static UsuarioEstudiante crearUsuarioEstudiante(UsuarioEstudiante usuario) {
		try {
			var usuarioEstudianteBean = getService();
			return usuarioEstudianteBean.crearUsuarioEstudiante(usuario);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void borrarUsuarioEstudiante(UsuarioEstudiante usuario) {
		try {
			var usuarioEstudianteBean = getService();
			usuarioEstudianteBean.borrarUsuarioEstudiante(usuario.getIdEstudiante() );
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	public static ArrayList<UsuarioEstudiante> listarTodosLosUsuarioEstudiantes() {
		try {
			var usuarioEstudianteBean = getService();
			return usuarioEstudianteBean.listarUsuariosEstudiantes();
		} catch (Exception e) {
			return null;
		}
	}
}
