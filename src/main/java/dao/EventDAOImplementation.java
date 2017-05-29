package dao;

import java.util.List;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Event;

@Default
public class EventDAOImplementation implements EventDAO {

	@Inject
	private EntityManager em;

	@Override
	public Event findById(Long id) {
		return em.find(Event.class, id);
	}

	@Override
	public void delete(Event event) {
		em.getTransaction().begin();
		em.remove(event);
		em.getTransaction().commit();
	}

	@Override
	public Event save(Event event) {
		em.getTransaction().begin();
		Event event1 = em.merge(event);
		em.getTransaction().commit();
		return event1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAll() {
		return em.createQuery("SELECT even FROM Event even").getResultList();
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
