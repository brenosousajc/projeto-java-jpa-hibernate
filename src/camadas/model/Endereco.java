package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Endereco {

	
	@Id //AQUI é a CHAVE PRIMARIA DO BANCO
	@Column(name = "ID_ENDERECO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rua;
	private int numero;
	private String complemento;
	
	public Endereco () {
		
	}
	
	public Endereco(int id, String rua, int numero, String complemento) {
		
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "Endereco [id = " + id + ", rua = " + rua + ", numero = " + numero + ", complemento = " + complemento + "]";
	}
	
	
	
}
