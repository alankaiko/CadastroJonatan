package br.com.jonatan.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.jonatan.domain.Cliente;
import br.com.jonatan.util.HibernateUtil;
import br.com.jonatan.util.Mensagem;

public class ClienteRepository {
	Session sessao;
	Transaction transacao = null;
	
	public void Salvar(Cliente cliente){
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(cliente);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null)
				transacao.rollback();
			
			e.printStackTrace();
			Mensagem.mensagemError("erro ao executar metodo Salvar do ClienteRepository");
		}finally{
			sessao.close();
		}
	}
	
	public void Excluir(Cliente cliente){
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(cliente);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null)
				transacao.rollback();
			
			e.printStackTrace();
			Mensagem.mensagemError("erro ao executar metodo Excluir do ClienteRepository");
		}finally{
			sessao.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Cliente> ListaCompleta(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Cliente> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Cliente.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
	
	public Cliente BuscarCliente(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Cliente.buscarPorCodigo");
			consulta.setLong("id", id);
			cliente = (Cliente) consulta.uniqueResult();
		} catch (RuntimeException e) {
			Mensagem.mensagemError("Erro ao executar metodo BuscarCliente");
			throw e;			
		}finally{
			sessao.close();
		}
		
		return cliente;
	}
		
	
}














