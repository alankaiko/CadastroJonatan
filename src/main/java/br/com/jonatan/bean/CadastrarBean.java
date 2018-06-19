package br.com.jonatan.bean;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.jonatan.domain.Cliente;
import br.com.jonatan.domain.TipoPessoa;
import br.com.jonatan.service.ClienteService;
import br.com.jonatan.util.ListasUtil;

@ManagedBean
@ViewScoped
public class CadastrarBean {
	private List<String> listaEstados;
	private Cliente cliente;
	private ClienteService service;
	private TipoPessoa tipoPessoa;
	private Long id;

	public CadastrarBean() {
		this.cliente = new Cliente();
		this.service = new ClienteService();
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/CadastroClientes/paginas/consulta.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Inicializar() {
		listaEstados = ListasUtil.Estados();
	}

	public Date getDataAtual() {
		Date data = new Date();
		return data;
	}
	
	public void Salvando(){
		this.service.Salvar(this.cliente);
	}
	
	
	public void CarregarUsuarioEditar(){
		if(this.id != null){
			this.cliente = service.BuscandoPorCodigo(this.id);
		}
	}
	
	
	@SuppressWarnings("static-access")
	public TipoPessoa[] getTipos(){
		return tipoPessoa.values();
	}
	
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public List<String> getListaEstados() {
		return listaEstados;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}
}
