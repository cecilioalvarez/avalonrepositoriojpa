package es.avalon.repositorios.jpa.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import org.junit.Test;

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

}
