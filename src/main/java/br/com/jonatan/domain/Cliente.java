package br.com.jonatan.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Table
@Entity
@NamedQueries({
	@NamedQuery(name="Cliente.listar", query="SELECT cliente FROM Cliente cliente order by id"),
	@NamedQuery(name="Cliente.buscarPorCodigo", query="SELECT cliente FROM Cliente cliente WHERE cliente.id = :id")
})
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String documentoId;
	private Date dataCadastro;
	private Date dataNasc;
	private String numeroIdentificacao;
	private TipoPessoa tipo;
	private Contato contato;
	private Endereco endereco;
	
	public Cliente() {
		nome= new String();
		documentoId= new String();
		numeroIdentificacao= new String();
		contato = new Contato();
		endereco = new Endereco();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable=false, unique=true, length=100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable = false, unique=true, length = 14)
	public String getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(String documentoId) {
		this.documentoId = documentoId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Temporal(TemporalType.DATE)
	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Column(unique=true, length=15)
	public String getNumeroIdentificacao() {
		return numeroIdentificacao;
	}

	public void setNumeroIdentificacao(String numeroIdentificacao) {
		this.numeroIdentificacao = numeroIdentificacao;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_contato_id", referencedColumnName = "id")
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_endereco_id", referencedColumnName = "id")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	
	public TipoPessoa getTipo() {
		return tipo;
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
			.append(", tipo=")
			.append(tipo)
			.append(", contato=")
			.append(contato)
			.append(", endereco=")
			.append(endereco)
			.append("]");
		return builder.toString();
	}

	
	
	
}
