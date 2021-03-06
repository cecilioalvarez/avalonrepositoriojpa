package es.avalon.repositorios;

import java.util.List;

import es.avalon.dominio.Libro;

public interface LibroRepository {

	List<Libro> buscarTodos();
	List<Libro> buscarTodosOrdenadosPorTitulo();
	List<Libro> buscarTodosOrdenadosPorAutor();

	Libro buscarPorISBN(String isbn);

	Libro buscarPorTitulo(String titulo);

	void insertar(Libro libro);

	void salvar(Libro libro);

	void borrar(Libro libro);

}