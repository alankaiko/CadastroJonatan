package br.com.jonatan.service;

import br.com.jonatan.domain.Cliente;
import br.com.jonatan.repository.ClienteRepository;

public class ClienteService {
	ClienteRepository repositorio;
	
	public ClienteService() {
		repositorio = new ClienteRepository();
	}
	
	public void Salvar(Cliente cliente){
		this.repositorio.Salvar(cliente);
	}
	
	public void Excluir(Cliente cliente){
		this.repositorio.Excluir(cliente);
	}
	
}




