package es.avalon.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.avalon.dominio.Libro;
import es.avalon.repositorios.LibroRepository;

public class LibroRepositoryJPA implements LibroRepository {

	
	public List<Libro> buscarTodos() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);

		List<Libro> lista = consulta.getResultList();

		return lista;
	}

	
	public Libro buscarPorISBN(String isbn) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		EntityManager em = emf.createEntityManager();

		return em.find(Libro.class, isbn);
	}

	
	public Libro buscarPorTitulo(String titulo) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.titulo=:titulo", Libro.class);
		consulta.setParameter("titulo", titulo);
		Libro libro = consulta.getSingleResult();

		return libro;
	}

	
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub

	}


	public void salvar(Libro libro) {
		// TODO Auto-generated method stub

	}

	
	public void borrar(Libro libro) {
		// TODO Auto-generated method stub

	}

}
