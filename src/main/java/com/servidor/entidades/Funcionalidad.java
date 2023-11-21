package com.servidor.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the FUNCIONALIDAD database table.
 *
 */
@Entity
@NamedQuery(name="Funcionalidad.findAll", query="SELECT f FROM Funcionalidad f")
public class Funcionalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FUNCIONALIDAD_IDFUNCIONALIDAD_GENERATOR", sequenceName="FUNCIONALIDAD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FUNCIONALIDAD_IDFUNCIONALIDAD_GENERATOR")
	@Column(name="ID_FUNCIONALIDAD")
	private long idFuncionalidad;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to RolFuncion
	@OneToMany(mappedBy="funcionalidad")
	private List<RolFuncion> rolFuncions;

	public Funcionalidad() {
	}

	public long getIdFuncionalidad() {
		return this.idFuncionalidad;
	}

	public void setIdFuncionalidad(long idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RolFuncion> getRolFuncions() {
		return this.rolFuncions;
	}

	public void setRolFuncions(List<RolFuncion> rolFuncions) {
		this.rolFuncions = rolFuncions;
	}

	public RolFuncion addRolFuncion(RolFuncion rolFuncion) {
		getRolFuncions().add(rolFuncion);
		rolFuncion.setFuncionalidad(this);

		return rolFuncion;
	}

	public RolFuncion removeRolFuncion(RolFuncion rolFuncion) {
		getRolFuncions().remove(rolFuncion);
		rolFuncion.setFuncionalidad(null);

		return rolFuncion;
	}

}