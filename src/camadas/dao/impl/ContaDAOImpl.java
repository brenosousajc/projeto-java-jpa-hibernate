package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.ContaDAO;
import model.Conta;
import model.Pessoa;
import model.util.JpaUtil;

public class ContaDAOImpl implements ContaDAO {

	private EntityManager em;
	private EntityTransaction et;
	
	@Override
	public void salvar(Conta conta) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(conta);
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
	public void alterar(Conta conta) {
		try {
			this.em = JpaUtil.getEntityManager();
			et =  em.getTransaction();
			et.begin();
			em.merge(conta);
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
	public void remover(int numero) {
		try {
			this.em = JpaUtil.getEntityManager();		
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Conta.class, numero)); //o remover precisa de um objeto gerenciado, por isso deve-se usar o find
			et.commit();
		}catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na Transação");
		}finally {
			if (em.isOpen()) {
				em.close();
			}
		}		
	}

	@Override
	public Conta pesquisar(int numero) {
		
		Conta conta = new Conta();
		try {
			this.em = JpaUtil.getEntityManager();
			return em.find(Conta.class, numero);
		}catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na transação de pesquisa");
		}finally {
			if(em.isOpen()) {
				em.close();
			}
		}
		return conta;
	}

	@Override
	public List<Conta> listarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Conta e");
		List<Conta> listaConta = query.getResultList();
		em.close();
		return listaConta;
	}

}
