package br.com.jonatan.controller;

import java.util.Date;
import java.util.List;






import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jonatan.domain.Cliente;
import br.com.jonatan.domain.TipoPessoa;
import br.com.jonatan.service.ClienteService;
import br.com.jonatan.util.ListasUtil;

@ManagedBean
@ViewScoped
public class CadastrarBean {
	private Cliente cliente;
	private ClienteService service;
	private List<String> listaEstados;
	private TipoPessoa tipoPessoa;
	
	public CadastrarBean() {
		this.cliente = new Cliente();
		this.service = new ClienteService();
	}
	
	
	public void Salvando(){
		this.service.Salvar(this.cliente);
	}
	
	public void Excluindo(){
		this.service.Excluir(this.cliente);
	}


	public void Inicializar(){
		listaEstados = ListasUtil.Estados();
	}
	
	@SuppressWarnings("static-access")
	public TipoPessoa[] getTipos(){
		return tipoPessoa.values();
	}
	
	
	
	public Date getDataAtual(){
		Date data = new Date();
		return data;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<String> getListaEstados() {
		return listaEstados;
	}


	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
}