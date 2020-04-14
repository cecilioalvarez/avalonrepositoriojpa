package es.avalon.repositorios.jpa.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.avalon.dominio.Libro;
import es.avalon.repositorios.LibroRepository;
import es.avalon.repositorios.jpa.LibroRepositoryJPA;

public class LibroRepositoryJPATest {

	public LibroRepositoryJPATest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void test_buscar_todos() {

		LibroRepository mirepositorio = new LibroRepositoryJPA();
		assertThat(mirepositorio.buscarTodos().size(), greaterThanOrEqualTo(4));

	}

	@Test
	public void test_buscar_por_isbn() {

		LibroRepository mirepositorio = new LibroRepositoryJPA();
		Libro libro = mirepositorio.buscarPorISBN("2AC");
		assertEquals("2AC", libro.getIsbn());

	}

	@Test
	public void test_buscar_por_titulo() {

		LibroRepository mirepositorio = new LibroRepositoryJPA();
		Libro libro = mirepositorio.buscarPorTitulo("2AC");
		assertEquals("html", libro.getTitulo());

	}

	@Test
	public void test_borrar_libro() {

		LibroRepository mirepositorio = new LibroRepositoryJPA();
		Libro libro = new Libro("1AB");
		mirepositorio.borrar(libro);

	}

}
