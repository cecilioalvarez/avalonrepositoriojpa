package es.avalon.repositorios.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.avalon.dominio.Categoria;
import es.avalon.repositorios.CategoriaRepository;
@Repository
public class CategoriaRepositoryJPA implements CategoriaRepository{


	@PersistenceContext
	EntityManager em=null;
	
	@Override
	public Categoria buscarPorNombre(String nombre) {
		
		return em.find(Categoria.class, nombre);
	}

}
