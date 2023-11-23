package com.cliente.servicios;

import javax.naming.InitialContext;
import com.servidor.beans.RolBeanRemote;
import com.servidor.entidades.Rol;

public class ServiceRol {


	private static RolBeanRemote getService() {
		try {
			RolBeanRemote rolBean = (RolBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/RolBean!com.servidor.beans.RolBeanRemote");
			return rolBean;
		} catch (Exception e) {
			return null;
		}
	}


	public static Rol buscarRol(Long rol) {
		try {
			var rolBean = getService();
			return rolBean.buscarRol(rol);
		} catch (Exception e) {
			return null;
		}
	}
}
