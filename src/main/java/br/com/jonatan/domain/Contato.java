package br.com.jonatan.domain;

import java.io.Serializable;

public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String fixo;
	private String celular;
	private String email;
	
	public Contato() {
		fixo = new String();
		celular = new String();
		email = new String();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contato [id=")
			.append(id).append(", fixo=")
			.append(fixo)
			.append(", celular=")
			.append(celular)
			.append(", email=")
			.append(email)
			.append("]");
		return builder.toString();
	}
	
	
}
