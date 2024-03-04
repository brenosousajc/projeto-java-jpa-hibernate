package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Telefone {

	@Id
	@Column(name = "ID_TELEFONE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ddd;
	private String numero;
	@ManyToOne
	@JoinColumn(name = "cpf")
	private Pessoa pessoa;
	
	public Telefone() {}
	
	public Telefone( String ddd, String numero, Pessoa pessoa) {
		
		this.ddd = ddd;
		this.numero = numero;
		this.pessoa = pessoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", ddd=" + ddd + ", numero=" + numero + "]";
	}
	
	
}
