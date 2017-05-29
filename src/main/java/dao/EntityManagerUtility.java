package dao;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {

	private static EntityManagerFactory instance;

	@Produces
	public static synchronized EntityManagerFactory getEntityManagerFactory() {
		if (instance == null) {
			instance = Persistence.createEntityManagerFactory("sellTicketPU");
		}
		return instance;
	}

	@Produces
	public EntityManager produceEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}

	public void destroy(@Disposes EntityManagerFactory factory) {
		factory.close();
	}
}
