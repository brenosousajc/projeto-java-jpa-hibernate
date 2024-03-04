package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.PessoaDAO;
import model.Conta;
import model.Pessoa;
import model.util.JpaUtil;

public class PessoaDAOImpl implements PessoaDAO {
	
	private EntityManager em;
	private EntityTransaction et; //aqui essa variável irá receber a getTransaction()
//variáveis declaradas dos tipos EntityManager e EntityTransaction e logo serão inicializadas

	@Override
	public void salvar(Pessoa pessoa) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(pessoa);
			et.commit();
			
		}
		catch(Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
		} 
		finally {
			 if(em.isOpen()) {
				 em.close();
			 }
		}
		
	}

	@Override
	public void alterar(Pessoa pessoa) {
		try {
			this.em = JpaUtil.getEntityManager();
			et =  em.getTransaction();
			et.begin();
			em.merge(pessoa);
			et.commit();
		}
		catch(Exception e) {
			if(em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro de Transação");
		}
		finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public void remover(String cpf) {
		try {
			this.em = JpaUtil.getEntityManager();		
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Conta.class, cpf)); //o remover precisa de um objeto gerenciado, por isso deve-se usar o find
			et.commit();
		}
		catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na Transação");
		}
		finally {
			if (em.isOpen()) {
				em.close();
			}
		}	
	}

	@Override
	public Pessoa pesquisar(String cpf) {
		Pessoa pessoa = new Pessoa();
		try {
			this.em = JpaUtil.getEntityManager();
			return em.find(Pessoa.class, cpf);
		}
		catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na transação de pesquisar");
		}
		finally {
			if(em.isOpen()) {
				em.close();
			}
		}
		return pessoa;
	}

	@Override
	public List<Pessoa> listarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Pessoa e");
		List<Pessoa> listaPessoas = query.getResultList();
		em.close();
		return listaPessoas;
	}

}
