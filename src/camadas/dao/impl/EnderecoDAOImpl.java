package dao.impl;

import java.util.List;

//import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.EnderecoDAO;
import model.Endereco;
import model.util.JpaUtil;

public class EnderecoDAOImpl implements EnderecoDAO {

	private EntityManager em;
	private EntityTransaction et;
	
	@Override
	public void salvar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(endereco);
			et.commit();			
		}
		catch(Exception e) {
			if(em.isOpen()) {
				et.rollback();
			} System.out.println("Erro na transação salvar Endereço");		
		}
		finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void alterar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManager();
			et =  em.getTransaction();
			et.begin();
			em.merge(endereco);
			et.commit();
		}
		catch(Exception e) {
			if(em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro de Transação alterar Endereço");
		}
		finally {
			if (em.isOpen()) {
				em.close();
			}
		}	
	}

	@Override
	public void remover(int id) {
		try {
			this.em = JpaUtil.getEntityManager();		
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Endereco.class, id)); //o remover precisa de um objeto gerenciado, por isso deve-se usar o find
			et.commit();
		}
		catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na Transação remover Endereço");
		}
		finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public Endereco pesquisar(int id) {
		Endereco endereco = new Endereco();
		try {
			this.em = JpaUtil.getEntityManager();
			return em.find(Endereco.class, id);
		}
		catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na transação de pesquisa");
		}
		finally {
			if(em.isOpen()) {
				em.close();
			}
		}
		return endereco;
	}

	@Override
	public List<Endereco> listarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Endereco e order by e.id");
		List<Endereco>listaEndereco = query.getResultList();
		em.close();
		return listaEndereco;
	}
	

}
