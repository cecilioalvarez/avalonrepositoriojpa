package es.avalon.repositorios.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.avalon.dominio.Categoria;
import es.avalon.repositorios.CategoriaRepository;

public class CategoriaRepositoryJPA implements CategoriaRepository{


	EntityManagerFactory emf;
	EntityManager em;

	public CategoriaRepositoryJPA() {

		em=emf.createEntityManager();
	}
	
	@Override
	public Categoria buscarPorNombre(String nombre) {
		
		return em.find(Categoria.class, nombre);
	}

}