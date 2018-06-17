package br.com.jonatan.service;

import java.util.List;

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
	
	public List<Cliente> pegandoListaCompleta(){
		return this.repositorio.ListaCompleta();
	}
	
	public Cliente BuscandoPorCodigo(Long id){
		return this.repositorio.BuscarCliente(id);
	}
}




