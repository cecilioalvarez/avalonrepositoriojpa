package es.avalon.repositorios.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import es.avalon.dominio.Libro;
import es.avalon.repositorios.LibroRepository;

public class LibroRepositoryJPA implements LibroRepository {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	public LibroRepositoryJPA() {

		entityManagerFactory = EMFSingleton.getInstance();
		entityManager = entityManagerFactory.createEntityManager();
	}

	public List<Libro> buscarTodos() {

		TypedQuery<Libro> consulta = entityManager.createQuery("select l from Libro l", Libro.class);
		return consulta.getResultList();
	}

	public Libro buscarPorISBN(String isbn) {
		return entityManager.find(Libro.class, isbn);
	}

	public Libro buscarPorTitulo(String titulo) {

		return entityManager.find(Libro.class, titulo);
	}

	public void insertar(Libro libro) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(libro);
		entityTransaction.commit();
	}

	public void salvar(Libro libro) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(libro);
			entityTransaction.commit();
		} catch (Exception e) {

			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public void borrar(Libro libro) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Libro libroBorrar = entityManager.merge(libro);
		entityManager.remove(libroBorrar);
		entityTransaction.commit();
	}

	public List<Libro> ordenarPorTitulo() {
		TypedQuery<Libro> consulta = entityManager.createQuery("select l from Libro l order by l.titulo", Libro.class);
		return consulta.getResultList();
	}

	public List<Libro> ordenarPorPrecio() {
		TypedQuery<Libro> consulta = entityManager.createQuery("select l from Libro l order by l.precio", Libro.class);
		return consulta.getResultList();
	}

}
