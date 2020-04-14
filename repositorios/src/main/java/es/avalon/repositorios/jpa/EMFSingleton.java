package es.avalon.repositorios.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {

	private static EntityManagerFactory entityManagerFactory = null;

	public static EntityManagerFactory getInstance() {

		if (entityManagerFactory == null) {

			entityManagerFactory = Persistence.createEntityManagerFactory("UnidadBiblioteca");
		}
		return entityManagerFactory;
	}
}
