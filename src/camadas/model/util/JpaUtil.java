package model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.bytebuddy.implementation.attribute.FieldAttributeAppender.Factory;

public class JpaUtil { //equivalente a classe conexao do jdbc (eu acho =)
	
	//EntityManagerFactory é responsável por criar e gerenciar instâncias de EntityManager.
	//É uma fábrica de EntityManager, ou seja, é usada para criar EntityManager quando necessário.
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaProject");
	
	/**
	 * Metodo responsavel, por retornar um entityManager
	 * @return EntityManager
	 */
	public static EntityManager getEntityManager() { //esse método está estático para poder ser chamado sem precisar instanciar um objeto.
		return factory.createEntityManager(); 
	//ele consegue retornar factory.createEntityManager mesmo ele estando fora das chaves do método pq ele está static
	// o método static só pode retornar variável/atributo se o mesmo tbm for static ?	
	}
	
	public static void closeEntityManager() {
		factory.close();
	}
	

	
}
