package com.servidor.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the ROL_FUNCION database table.
 *
 */
@Entity
@Table(name="ROL_FUNCION")
@NamedQuery(name="RolFuncion.findAll", query="SELECT r FROM RolFuncion r")
public class RolFuncion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_FUNCION_IDROLFUNCION_GENERATOR", sequenceName="ROL_FUNCION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_FUNCION_IDROLFUNCION_GENERATOR")
	@Column(name="ID_ROL_FUNCION")
	private long idRolFuncion;

	@Column(name="ID_ESTADO")
	private BigDecimal idEstado;

	//bi-directional many-to-one association to Funcionalidad
	@ManyToOne
	@JoinColumn(name="ID_FUNCIONALIDAD")
	private Funcionalidad funcionalidad;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol rol;

	public RolFuncion() {
	}

	public long getIdRolFuncion() {
		return this.idRolFuncion;
	}

	public void setIdRolFuncion(long idRolFuncion) {
		this.idRolFuncion = idRolFuncion;
	}

	public BigDecimal getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(BigDecimal idEstado) {
		this.idEstado = idEstado;
	}

	public Funcionalidad getFuncionalidad() {
		return this.funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}