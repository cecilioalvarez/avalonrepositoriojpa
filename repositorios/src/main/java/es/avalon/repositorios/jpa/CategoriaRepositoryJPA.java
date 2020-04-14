package es.avalon.repositorios.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import es.avalon.dominio.Categoria;
import es.avalon.repositorios.CategoriaRepository;

public class CategoriaRepositoryJPA implements CategoriaRepository {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	public CategoriaRepositoryJPA() {

		entityManagerFactory = EMFSingleton.getInstance();
		entityManager = entityManagerFactory.createEntityManager();
	}

	public Categoria buscarPorNombre(String nombre) {

		return entityManager.find(Categoria.class, nombre);
	}

	public List<Categoria> buscarTodos() {

		TypedQuery<Categoria> consulta = entityManager.createQuery("select c from Categoria c", Categoria.class);
		return consulta.getResultList();
	}

}
