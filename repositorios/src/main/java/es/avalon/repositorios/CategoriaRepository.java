package es.avalon.repositorios;

import java.util.List;

import es.avalon.dominio.Categoria;

public interface CategoriaRepository {

	Categoria buscarPorNombre(String nombre);

	List<Categoria> buscarTodos();
}
