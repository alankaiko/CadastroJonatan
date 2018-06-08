package br.com.jonatan.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String documentoId;
	private Date dataCadastro;
	private Date dataNasc;
	private String numeroIdentificacao;
	
	private List<Contato> contato;
	private List<Endereco> endereco;
	
	public Cliente() {
		nome= new String();
		documentoId= new String();
		numeroIdentificacao= new String();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(String documentoId) {
		this.documentoId = documentoId;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getNumeroIdentificacao() {
		return numeroIdentificacao;
	}

	public void setNumeroIdentificacao(String numeroIdentificacao) {
		this.numeroIdentificacao = numeroIdentificacao;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
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
		Cliente other = (Cliente) obj;
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
		builder.append("Cliente [id=")
			.append(id)
			.append(", nome=")
			.append(nome)
			.append(", documentoId=")
			.append(documentoId)
			.append(", dataCadastro=")
			.append(dataCadastro)
			.append(", dataNasc=")
			.append(dataNasc)
			.append(", numeroIdentificacao=")
			.append(numeroIdentificacao)
			.append(", contato=")
			.append(contato)
			.append(", endereco=")
			.append(endereco)
			.append("]");
		return builder.toString();
	}
	
	
	
}
