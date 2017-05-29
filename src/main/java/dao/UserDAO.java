package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	public User findById(Long id);

	public User findByUsername(String username);

	public void delete(User user);

	public User save(User author);

	List<User> findAll();

}
