package teste;

import br.com.jonatan.util.HibernateUtil;

public class Teste {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		System.out.println("aff");

	}

}
