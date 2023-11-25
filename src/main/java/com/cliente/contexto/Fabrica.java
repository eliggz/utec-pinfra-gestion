package com.cliente.contexto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cliente.servicios.ServiceEstado;
import com.cliente.servicios.ServiceItr;
import com.cliente.servicios.ServiceUsuario;
import com.servidor.entidades.Estado;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Rol;
import com.servidor.entidades.Usuario;

public class Fabrica {
	private static Usuario usuarioLogueado;
	// Usuario logueado
	// mensajes de error
	// listas ya filtradas <- los activos, los no confirmados, etc

	public static List<Usuario> getListaDeUsuarios() {
		List<Usuario> listaDeUsuarios = ServiceUsuario.listarTodosLosUsuarios();
		return listaDeUsuarios;
	}

	public static void setUsuarioLogueado(Usuario usuario) {
		usuarioLogueado = usuario;
	}
	
	public static void setUsuarioLogueadoNull() {
		usuarioLogueado = null;
	}

	public static Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}
	
	public static List<Itr> getListaDeItrs(){
		 List<Itr> listaDeItrs = ServiceItr.listarTodasLasItr();
		return listaDeItrs;	
	}
	public static List<Itr> getListaDeItrsValidas(){
		List<Itr> listaDeItrs = ServiceItr.listarTodasLasItrValidas();
		return listaDeItrs;	
	}
	public static List<Itr> getListaDeItrsNoValidas(){
		List<Itr> listaDeItrs = ServiceItr.listarTodasLasItrNoValidas();
		return listaDeItrs;	
	}
	
	public static List<Estado> getListaDeEstados() {
		List<Estado> listaDeEstados = ServiceEstado.listarEstados();
		return listaDeEstados;
	}


}
