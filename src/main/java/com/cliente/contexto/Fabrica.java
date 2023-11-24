package com.cliente.contexto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cliente.servicios.ServiceItr;
import com.servidor.entidades.Estado;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Rol;
import com.servidor.entidades.Usuario;

public class Fabrica {
	private static ArrayList<Usuario> listaDeUsuario = new ArrayList<>();
	private static Usuario usuarioLogueado;
	// Usuario logueado
	// mensajes de error
	// listas ya filtradas <- los activos, los no confirmados, etc

	public static ArrayList<Usuario> getListaDeUsuarios() {
		// Logica para cargar la lista
		Usuario usuario1 = new Usuario("Lopez", "Perez", "88888888", new Date(), "pepe.lopez@estudiantes.utec.edu.uy",
				"pepe@gmail.com", "pepe.lopez", "Pepe", "Manuel", "123", "099616546", "Treinta y Tres",
				"Treinta y Tres",
				new Estado(), new Itr(), new Rol());
		Usuario usuario2 = new Usuario("Lopez2", "Perez2", "88888888", new Date(), "pepe.lopez@estudiantes.utec.edu.uy",
				"pepe@gmail.com2", "pepe.lopez2", "Pepe", "Manuel", "123", "099616546", "Treinta y Tres",
				"Treinta y Tres", new Estado(), new Itr(), new Rol());
		Usuario usuario3 = new Usuario("Lopez3", "Perez3", "88888888", new Date(), "pepe.lopez@estudiantes.utec.edu.uy",
				"pepe@gmail.com3", "pepe.lope3z", "Pepe3", "Manuel", "123", "099616546", "Treinta y Tres",
				"Treinta y Tres", new Estado(), new Itr(), new Rol());
		listaDeUsuario.add(usuario1);
		listaDeUsuario.add(usuario2);
		listaDeUsuario.add(usuario3);

		return listaDeUsuario;
	}

	public static void setUsuarioLogueado(Usuario usuario) {
		usuarioLogueado = usuario;
	}

	public static Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}
	
	public static List<Itr> getListaDeItrs(){
		 List<Itr> listaDeItrs = ServiceItr.listarTodasLasItr();
		return listaDeItrs;	
	}

}
