package dao;

import java.util.List;

import model.Event;

public interface EventDAO {

	public Event findById(Long id);

	public void delete(Event event);

	public Event save(Event event);

	List<Event> findAll();

}
