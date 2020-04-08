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
		
		emf=Persistence.createEntityManagerFactory("UnidadBiblioteca");
		em=emf.createEntityManager();
	}

	@Override
	public List<Libro> buscarTodos() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);

		List<Libro> lista = consulta.getResultList();

		return lista;
	}

	@Override
	public Libro buscarPorISBN(String isbn) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		EntityManager em = emf.createEntityManager();

		return em.find(Libro.class, isbn);
	}

	@Override
	public Libro buscarPorTitulo(String titulo) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.titulo=:titulo", Libro.class);
		consulta.setParameter("titulo", titulo);
		Libro libro = consulta.getSingleResult();

		return libro;
	}

	@Override
	public void insertar(Libro libro) {
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(libro);
		et.commit();

	}

	@Override
	public void salvar(Libro libro) {
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(libro);
		et.commit();

	}

	@Override
	public void borrar(Libro libro) {
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		Libro libroBorrar=em.merge(libro);
		em.remove(libro);
		et.commit();


	}

}
