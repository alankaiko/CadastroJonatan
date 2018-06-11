package br.com.jonatan.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jonatan.domain.Cliente;
import br.com.jonatan.service.ClienteService;

@ManagedBean
@ViewScoped
public class ClienteController {
	private Cliente cliente;
	private ClienteService service;
	
	public ClienteController() {
		this.cliente = new Cliente();
		this.service = new ClienteService();
	}
	
	
	public void Salvando(Cliente cliente){
		this.service.Salvar(this.cliente);
	}
	
	public void Excluindo(Cliente cliente){
		this.service.Excluir(this.cliente);
	}


	
	
	
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
}
