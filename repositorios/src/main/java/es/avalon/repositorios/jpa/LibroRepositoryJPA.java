package es.avalon.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.avalon.dominio.Libro;
import es.avalon.repositorios.LibroRepository;

@Repository
public class LibroRepositoryJPA implements LibroRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Libro> buscarTodos() {

		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);

		return consulta.getResultList();
	}
	
	public List<Libro> buscarTodosOrdenadosPorTitulo() {

		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l order by l.titulo", Libro.class);

		return consulta.getResultList();
	}
	
	public List<Libro> buscarTodosOrdenadosPorAutor() {

		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l order by l.autor", Libro.class);

		return consulta.getResultList();
	}

	public Libro buscarPorISBN(String isbn) {
		return em.find(Libro.class, isbn);
	}

	public Libro buscarPorTitulo(String titulo) {
		
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.titulo=:titulo", Libro.class);
		consulta.setParameter("titulo", titulo);		
		return consulta.getSingleResult();
	}
	
	@Transactional
	public void insertar(Libro libro) {

		em.persist(libro);		
	}

	@Transactional
	public void salvar(Libro libro) {

		em.merge(libro);
	}

	@Transactional
	public void borrar(Libro libro) {
	
		//Libro libroBorrar=em.find(Libro.class,libro.getIsbn());
		Libro libroBorrar=em.merge(libro);
		em.remove(libroBorrar);

	}


}
