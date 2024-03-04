package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.util.JpaUtil;

import dao.ContaDAO;
import dao.EnderecoDAO;
import dao.impl.ContaDAOImpl;
import dao.impl.EnderecoDAOImpl;
import dao.impl.PessoaDAOImpl;
import model.Conta;
import model.Endereco;
import model.Pessoa;
import model.Telefone;
//import model.util.Conexao;

public class Principal {

	public static void main(String[] args) {
		
		
		
//		EntityManager em = JpaUtil.getEntityManager();
//		EntityTransaction et = em.getTransaction();
//		et.begin();
//		em.close();
		
		
		Endereco enderecoPessoa = new Endereco();
		enderecoPessoa.setRua("Rua da Lama");
		enderecoPessoa.setNumero(100);
		enderecoPessoa.setComplemento("Apto");
		
		Conta contaPessoa = new Conta();
		contaPessoa.setNumero(1007);
		contaPessoa.setSaldo(500);
		contaPessoa.setLimite(600);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("02315487566");
		pessoa.setIdade(35);
		pessoa.setNome("Pedro José");
		
		Telefone tel1 = new Telefone("81", "988287405", pessoa);
		Telefone tel2 = new Telefone("81", "976455870", pessoa);
		Telefone tel3 = new Telefone("81", "999553251", pessoa);
		Telefone tel4 = new Telefone("81", "988183818", pessoa);
		
		List<Telefone> listaTelefones = new ArrayList<>();
		listaTelefones.add(tel1);
		listaTelefones.add(tel2);
		listaTelefones.add(tel3);
		listaTelefones.add(tel4);
		
		pessoa.setConta(contaPessoa);
		pessoa.setEndereco(enderecoPessoa);
		pessoa.setTelefones(listaTelefones);
		
		
		

		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
