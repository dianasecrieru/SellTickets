package dao;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Ticket;

@Default
public class TicketDAOImplementation implements TicketDAO {

	@Inject
	private EntityManager em;

	@Override
	public Ticket findById(Long id) {
		return em.find(Ticket.class, id);
	}

	@Override
	public void delete(Ticket ticket) {
		em.getTransaction().begin();
		em.remove(ticket);
		em.getTransaction().commit();
	}

	@Override
	public Ticket save(Ticket ticket) {
		em.getTransaction().begin();
		Ticket ticket1 = em.merge(ticket);
		em.getTransaction().commit();
		return ticket1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAll() {
		return em.createQuery("SELECT tick FROM Ticket tick").getResultList();
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
