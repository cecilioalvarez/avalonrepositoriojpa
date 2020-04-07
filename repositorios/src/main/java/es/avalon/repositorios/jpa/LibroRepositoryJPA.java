package es.avalon.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.avalon.dominio.Libro;
import es.avalon.repositorios.LibroRepository;

public class LibroRepositoryJPA implements LibroRepository {

	EntityManagerFactory emf;
	EntityManager em;

	public LibroRepositoryJPA() {

		emf = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		em = emf.createEntityManager();
	}

	@Override
	public List<Libro> buscarTodos() {

		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);

		return consulta.getResultList();
	}

	@Override
	public Libro buscarPorISBN(String isbn) {

		return em.find(Libro.class, isbn);
	}

	@Override
	public Libro buscarPorTitulo(String titulo) {

		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.titulo=:titulo", Libro.class);
		consulta.setParameter("titulo", titulo);

		return consulta.getSingleResult();
	}

	@Override
	public void insertar(Libro libro) {

		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(libro);
		t.commit();

	}

	@Override
	public void salvar(Libro libro) {

		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(libro);
		t.commit();

	}

	@Override
	public void borrar(Libro libro) {

		EntityTransaction t = em.getTransaction();
		t.begin();
		// Libro libroBorrar)em.merge(libro);
		Libro libroBorrar = em.find(Libro.class, libro.getIsbn());
		em.remove(libroBorrar);
		t.commit();
	}

}
