package com.servidor.entidades;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the USUARIO_ESTUDIANTE database table.
 *
 */
@Entity
@Table(name = "USUARIO_ESTUDIANTE")
@NamedQuery(name = "UsuarioEstudiante.findAll", query = "SELECT u FROM UsuarioEstudiante u")
public class UsuarioEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USUARIO_ESTUDIANTE_IDESTUDIANTE_GENERATOR", sequenceName = "ESTUDIANTES_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_ESTUDIANTE_IDESTUDIANTE_GENERATOR")
	@Column(name = "ID_ESTUDIANTE")
	private long idEstudiante;

	private int generacion;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	public UsuarioEstudiante() {
	}

	public long getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getGeneracion() {
		return this.generacion;
	}

	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}