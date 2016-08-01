package br.com.casadocodigo.loja.daos;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Produto;

@Repository
@Transactional
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Produto produto){
		manager.persist(produto);
	}
	
	public List<Produto> listar(){
		return manager.createQuery("select p from Produto p").getResultList();
	}
	
	public Produto find(int id){
		return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id", Produto.class).setParameter("id", id).getSingleResult();
	}
	
}
