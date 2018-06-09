package br.com.jonatan.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.jonatan.domain.Cliente;
import br.com.jonatan.util.HibernateUtil;

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
			System.out.println("erro ao executar metodo Salvar do ClienteRepository");
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
			System.out.println("erro ao executar metodo Excluir do ClienteRepository");
		}finally{
			sessao.close();
		}
	}
	
	
}
