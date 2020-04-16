package es.avalon.repositorios.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import es.avalon.dominio.Categoria;
import es.avalon.repositorios.CategoriaRepository;

public class CategoriaRepositoryJPA implements CategoriaRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Categoria buscarPorNombre(String nombre) {
		
		return em.find(Categoria.class,  nombre);
	}

}
