package es.avalon.repositorios.jpa.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	
		LibroRepository mirepositorio= new LibroRepositoryJPA();	
		assertThat(mirepositorio.buscarTodos().size(),greaterThanOrEqualTo(4));
		
	}
	
	@Test
	public void test_buscar_por_ISBN() {
		LibroRepository mirepositorio= new LibroRepositoryJPA();
		Libro libro = mirepositorio.buscarPorISBN("1AB");
		assertEquals("1AB", libro.getIsbn());
		assertEquals("Java", libro.getTitulo());
		assertEquals("cecilio", libro.getAutor());
		assertEquals(10, libro.getPrecio());

	}
	
	@Test
	public void test_buscar_por_titulo() {
		LibroRepository mirepositorio= new LibroRepositoryJPA();
		Libro libro = mirepositorio.buscarPorTitulo("html");
		assertEquals("3BC", libro.getIsbn());
		assertEquals("html", libro.getTitulo());
		assertEquals("gema", libro.getAutor());
		assertEquals(8, libro.getPrecio());
		

	}
	
}
