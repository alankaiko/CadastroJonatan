package br.com.jonatan.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jonatan.domain.Cliente;
import br.com.jonatan.service.ClienteService;


@ManagedBean
@ViewScoped
public class ConsultaBean {
	private List<Cliente> listaClientes;
	private ClienteService service;
	
	public ConsultaBean() {
		this.service = new ClienteService();
	}

	
	public void pegaLista(){
		this.listaClientes = this.service.pegandoListaCompleta();
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	

}
