package dao;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.User;

@Default
public class UserDAOImplementation implements UserDAO {

	@Inject
	private EntityManager em;

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByUsername(String username) {
		return em.find(User.class, username);
	}

	@Override
	public void delete(User user) {
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();

	}

	@Override
	public User save(User user) {
		em.getTransaction().begin();
		User user1 = em.merge(user);
		em.getTransaction().commit();
		return user1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return em.createQuery("SELECT us FROM User us").getResultList();
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
