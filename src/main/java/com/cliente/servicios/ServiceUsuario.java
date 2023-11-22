package com.cliente.servicios;

import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;

import com.servidor.beans.UsuarioBeanRemote;

import com.servidor.entidades.Estado;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Rol;
import com.servidor.entidades.Usuario;

public class ServiceUsuario {

	private static UsuarioBeanRemote getService() {
		try {
			UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/UsuarioBean!com.servidor.beans.UsuarioBeanRemote");
			return usuarioBean;
		} catch (Exception e) {
			return null;
		}
	}

	public static Usuario login(String nombreUsuario, String clave) {
		try {
			var usuarioBean = getService();
			Usuario usuarioEncontrado = new Usuario();

			if (nombreUsuario.equals("pepe.lopez") && clave.equals("123")) {
				return usuarioEncontrado;
			}
//			for (var aux : usuarioBean.listarUsuarios()) {
//				if (aux.getNombreUsuario().equals(nombreUsuario) && aux.getPassword().equals(clave)) {
//					usuarioEncontrado = aux;
//					break;
//				}
//			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	public static Usuario crearUsuario(Usuario usuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.crearUsuario(usuario);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void borrarUsuario(Usuario usuario) {
		try {
			var usuarioBean = getService();
			usuarioBean.borrarUsuario(usuario.getIdUsuario());
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	public static ArrayList<Usuario> listarTodosLosUsuarios() {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuarios();
		} catch (Exception e) {
			return null;
		}
	}

}
