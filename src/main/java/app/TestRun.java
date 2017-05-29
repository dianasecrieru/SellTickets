package app;

import javax.persistence.EntityManager;

import dao.EntityManagerUtility;
import dao.EventDAOImplementation;

public class TestRun {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtility.getEntityManagerFactory().createEntityManager();
		EventDAOImplementation eventDao = new EventDAOImplementation();
		eventDao.setEntityManager(em);
	}

}
