package com.cliente.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import com.servidor.beans.ItrBeanRemote;
import com.servidor.beans.UsuarioBeanRemote;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Usuario;

public class ServiceItr {



private static ItrBeanRemote getService() {
	try {
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
				.doLookup("ejb:/Proyecto-PInfra/ItrBean!com.servidor.beans.ItrBeanRemote");
		return itrBean;
	} catch (Exception e) {
		return null;
	}
}

public static Itr crearItr(Itr itr) {
	try {
		var itrBean = getService();
		return itrBean.crearItr(itr);
	} catch (Exception e) {
		return null;
	}
}
public static Itr actualizarItr(Itr itr) {
	try {
		var itrBean = getService();
		return itrBean.actualizarItr(itr);
	} catch (Exception e) {
		return null;
	}
}

public static Itr eliminarItr(Itr itr) {
	try {
		var itrBean = getService();
		return itrBean.bajaLogicaItr(itr.getIdItr());
	} catch (Exception e) {
		return null;
	}
}

public static Itr buscarItr(Long itr) {
	try {
		var itrBean = getService();
		return itrBean.buscarItr(itr);
	} catch (Exception e) {
		return null;
	}
}

public static Itr encontrarItrPorNombre(String nombre) {
	
	try {
		var itrBean = getService();
		Itr itr = itrBean.buscarItr(itrBean.obtenerIdPorNombre(nombre.toUpperCase()));

	return itr;
	
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("No se encontó la itr por nombre");
		return null;
	}
}

public static List<Itr> listarTodasLasItr() {
	try {
		var itrBean = getService();
		return itrBean.listarItr() ;
	} catch (Exception e) {
		return null;
	}
}
public static List<Itr> listarTodasLasItrValidas() {
	try {
		var itrBean = getService();
		return itrBean.listarItrValidadas() ;
	} catch (Exception e) {
		return null;
	}
}
public static List<Itr> listarTodasLasItrNoValidas() {
	try {
		var itrBean = getService();
		return itrBean.listarItrNoValidadas() ;
	} catch (Exception e) {
		return null;
	}
}


}