package es.avalon.repositorios.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.avalon.dominio.Categoria;

public class CategoriaRepositoryJPA {
	EntityManagerFactory emf;
	EntityManager em;

	public CategoriaRepositoryJPA() {

		emf = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		em=emf.createEntityManager();
	}
	
	public Categoria buscarPorNombre(String nombre) {
		
		return em.find(Categoria.class, nombre);
	}

}
