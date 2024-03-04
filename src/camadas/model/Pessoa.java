package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pessoa{
	
	@Id
	private String cpf;
	
	private int idade;
	
	private String sexo;
	
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_ENDERECO", referencedColumnName = "ID_ENDERECO")
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUMERO_CONTA", referencedColumnName = "NUMERO")
	private Conta conta;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	
	public Pessoa(String cpf, int idade, String sexo, String nome, Endereco endereco, Conta conta, List<Telefone> telefones) {
		
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
		this.nome = nome;
		this.endereco = endereco;
		this.conta = conta;
		this.telefones = telefones;
	}
	
	public Pessoa () {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	@Override
	public String toString() {
		return "Pessoa [cpf = " + cpf + ", idade = " + idade + ", sexo = " + sexo + ", nome = " + nome + ", endereco = "
				+ endereco + ", conta = " + conta + "]";
	}
	
}
