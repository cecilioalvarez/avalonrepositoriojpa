package es.avalon.repositorios;

import es.avalon.dominio.Categoria;

public interface CategoriaRepository {
	
	Categoria buscarPotNombre(String nombre);

}
