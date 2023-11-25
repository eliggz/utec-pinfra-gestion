package com.servidor.entidades;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the USUARIO_TUTOR database table.
 *
 */
@Entity
@Table(name="USUARIO_TUTOR")
@NamedQuery(name="UsuarioTutor.findAll", query="SELECT u FROM UsuarioTutor u")
public class UsuarioTutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_TUTOR_IDTUTOR_GENERATOR", sequenceName="TUTORES_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_TUTOR_IDTUTOR_GENERATOR")
	@Column(name="ID_TUTOR")
	private long idTutor;

	private String area;

	private String rol;
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public UsuarioTutor() {
	}

	public long getIdTutor() {
		return this.idTutor;
	}

	public void setIdTutor(long idTutor) {
		this.idTutor = idTutor;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}