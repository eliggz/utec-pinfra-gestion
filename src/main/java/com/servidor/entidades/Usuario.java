package com.servidor.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the USUARIOS database table.
 *
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOS_IDUSUARIO_GENERATOR", sequenceName="USUARIOS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOS_IDUSUARIO_GENERATOR")
	@Column(name="ID_USUARIO")
	private long idUsuario;

	private String apellido1;

	private String apellido2;

	private String documento;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(name="MAIL_INSTITUCIONAL")
	private String mailInstitucional;

	@Column(name="MAIL_PERSONAL")
	private String mailPersonal;

	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;

	private String nombre1;

	private String nombre2;

	private String password;

	private String telefono;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="ID_CIUDAD")
	private Ciudad ciudad;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="ID_DEPTO")
	private Departamento departamento;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;

	//bi-directional many-to-one association to Itr
	@ManyToOne
	@JoinColumn(name="ID_ITR")
	private Itr itr;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol rol;

	//bi-directional many-to-one association to UsuarioAnalista
	@OneToMany(mappedBy="usuario")
	private List<UsuarioAnalista> usuarioAnalistas;

	//bi-directional many-to-one association to UsuarioEstudiante
	@OneToMany(mappedBy="usuario")
	private List<UsuarioEstudiante> usuarioEstudiantes;

	//bi-directional many-to-one association to UsuarioTutor
	@OneToMany(mappedBy="usuario")
	private List<UsuarioTutor> usuarioTutors;

	public Usuario() {
	}

	public Usuario(String apellido1, String apellido2, String documento, Date fechaNacimiento, String mailInstitucional,
			String mailPersonal, String nombreUsuario, String nombre1, String nombre2, String password, String telefono,
			Ciudad ciudad, Departamento departamento, Estado estado, Itr itr, Rol rol) {
		super();
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.mailInstitucional = mailInstitucional;
		this.mailPersonal = mailPersonal;
		this.nombreUsuario = nombreUsuario;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.password = password;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.estado = estado;
		this.itr = itr;
		this.rol = rol;
	}



	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getMailInstitucional() {
		return this.mailInstitucional;
	}

	public void setMailInstitucional(String mailInstitucional) {
		this.mailInstitucional = mailInstitucional;
	}

	public String getMailPersonal() {
		return this.mailPersonal;
	}

	public void setMailPersonal(String mailPersonal) {
		this.mailPersonal = mailPersonal;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre1() {
		return this.nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Itr getItr() {
		return this.itr;
	}

	public void setItr(Itr itr) {
		this.itr = itr;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<UsuarioAnalista> getUsuarioAnalistas() {
		return this.usuarioAnalistas;
	}

	public void setUsuarioAnalistas(List<UsuarioAnalista> usuarioAnalistas) {
		this.usuarioAnalistas = usuarioAnalistas;
	}

	public UsuarioAnalista addUsuarioAnalista(UsuarioAnalista usuarioAnalista) {
		getUsuarioAnalistas().add(usuarioAnalista);
		usuarioAnalista.setUsuario(this);

		return usuarioAnalista;
	}

	public UsuarioAnalista removeUsuarioAnalista(UsuarioAnalista usuarioAnalista) {
		getUsuarioAnalistas().remove(usuarioAnalista);
		usuarioAnalista.setUsuario(null);

		return usuarioAnalista;
	}

	public List<UsuarioEstudiante> getUsuarioEstudiantes() {
		return this.usuarioEstudiantes;
	}

	public void setUsuarioEstudiantes(List<UsuarioEstudiante> usuarioEstudiantes) {
		this.usuarioEstudiantes = usuarioEstudiantes;
	}

	public UsuarioEstudiante addUsuarioEstudiante(UsuarioEstudiante usuarioEstudiante) {
		getUsuarioEstudiantes().add(usuarioEstudiante);
		usuarioEstudiante.setUsuario(this);

		return usuarioEstudiante;
	}

	public UsuarioEstudiante removeUsuarioEstudiante(UsuarioEstudiante usuarioEstudiante) {
		getUsuarioEstudiantes().remove(usuarioEstudiante);
		usuarioEstudiante.setUsuario(null);

		return usuarioEstudiante;
	}

	public List<UsuarioTutor> getUsuarioTutors() {
		return this.usuarioTutors;
	}

	public void setUsuarioTutors(List<UsuarioTutor> usuarioTutors) {
		this.usuarioTutors = usuarioTutors;
	}

	public UsuarioTutor addUsuarioTutor(UsuarioTutor usuarioTutor) {
		getUsuarioTutors().add(usuarioTutor);
		usuarioTutor.setUsuario(this);

		return usuarioTutor;
	}

	public UsuarioTutor removeUsuarioTutor(UsuarioTutor usuarioTutor) {
		getUsuarioTutors().remove(usuarioTutor);
		usuarioTutor.setUsuario(null);

		return usuarioTutor;
	}

}