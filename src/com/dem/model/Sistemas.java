package com.dem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "system")
public class Sistemas extends Abstract{
	private Integer id;
	private String descripcion;
	private String host;
	private String port;
	private String username;
	private String password;
	private String dbname;
	private String schemas;
	
	@Id
	@Column(name = "id_system")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "des_system", length = 40, unique = true)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Column(name = "host",length = 20, unique = false)
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	@Column(name = "port",length = 5, unique = false)
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	@Column(name = "username",length = 15, unique = false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password",length = 20, unique = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "dbname",length = 15, unique = true)
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	@Column(name = "schemas",length = 15, unique = false)
	public String getSchemas() {
		return schemas;
	}
	public void setSchemas(String schemas) {
		this.schemas = schemas;
	}
}
