package com.servidor.beans;

import java.util.List;

import javax.ejb.Remote;

import com.servidor.entidades.Departamento;
import com.servidor.execption.ServiciosException;


@Remote
public interface DepartamentoBeanRemote {

	Departamento crearDepartamento(Departamento departamento) throws ServiciosException;

	Departamento actualizarDepartamento(Departamento departamento) throws ServiciosException;

	void borrarDepartamento(Long id) throws ServiciosException;

	List<Departamento> listarDepartamentos() throws ServiciosException;

	List<Departamento> listarDepartamentoFiltro(String nombre) throws ServiciosException;

	Departamento buscarDepartamento(Long id) throws ServiciosException;

}
