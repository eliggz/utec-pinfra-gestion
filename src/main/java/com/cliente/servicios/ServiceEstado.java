package com.cliente.servicios;

import java.util.List;

import javax.naming.InitialContext;

import com.servidor.beans.EstadoBeanRemote;
import com.servidor.beans.ItrBeanRemote;
import com.servidor.entidades.Estado;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Usuario;

public class ServiceEstado {

	
	private static EstadoBeanRemote getService() {
		try {
			EstadoBeanRemote estadoBean = (EstadoBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/EstadoBean!com.servidor.beans.EstadoBeanRemote");
			return estadoBean;
		} catch (Exception e) {
			return null;
		}
	}

	public static void asignarEstadoUsuario(Usuario usuario, Long estado) {
		try {
			var estadoBean = getService();
			Estado e = estadoBean.buscarEstado(estado);
			usuario.setEstado(e);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void asignarEstadoItr(Itr itr, Long estado) {
		try {
			var estadoBean = getService();
			Estado e = estadoBean.buscarEstado(estado);
			itr.setEstado(e);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
