package com.servidor.beans;

import javax.ejb.Remote;

import com.servidor.entidades.Estado;
import com.servidor.execption.ServiciosException;


@Remote
public interface EstadoBeanRemote {

	Estado buscarEstado(Long id) throws ServiciosException;

}
