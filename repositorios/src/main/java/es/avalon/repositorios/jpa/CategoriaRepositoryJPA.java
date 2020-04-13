package es.avalon.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.avalon.dominio.Categoria;
import es.avalon.dominio.Libro;
import es.avalon.repositorios.CategoriaRepository;

public class CategoriaRepositoryJPA implements CategoriaRepository{


	EntityManagerFactory emf;
	EntityManager em;

	public CategoriaRepositoryJPA() {

		emf = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		em=emf.createEntityManager();
	}
	
	public Categoria buscarPorNombre(String nombre) {
		
		return em.find(Categoria.class, nombre);
	}
	
	
	public List<Categoria> buscarTodos() {

		TypedQuery<Categoria> consulta = em.createQuery("select c from Categoria c", Categoria.class);
		return consulta.getResultList();		
	}

}
