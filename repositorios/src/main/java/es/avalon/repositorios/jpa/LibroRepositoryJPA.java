package es.avalon.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.avalon.dominio.Libro;
import es.avalon.repositorios.LibroRepository;

public class LibroRepositoryJPA implements LibroRepository {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void salvar(Libro libro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Libro libro) {
		// TODO Auto-generated method stub

	}

}