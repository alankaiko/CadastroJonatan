package br.com.jonatan.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.jonatan.domain.Cliente;
import br.com.jonatan.service.ClienteService;
import br.com.jonatan.util.Mensagem;


@ManagedBean
@ViewScoped
public class ConsultaBean {
	private List<Cliente> listaClientes;
	private ClienteService service;
	private Cliente clienteSelecionado;
	
	public ConsultaBean() {
		this.service = new ClienteService();
	}

	
	public void pegaLista(){
		this.listaClientes = this.service.pegandoListaCompleta();
	}
	
	public void excluir(){
		try {
			this.service.Excluir(this.clienteSelecionado);
			
			Mensagem.mensagemInfo("Cliente "+ this.clienteSelecionado.getNome()+ " Excluído com Sucesso");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/CadastroClientes/paginas/consulta.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
}
