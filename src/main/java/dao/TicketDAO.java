package dao;

import java.util.List;

import model.Ticket;

public interface TicketDAO {

	public Ticket findById(Long id);

	public void delete(Ticket ticket);

	public Ticket save(Ticket ticket);

	List<Ticket> findAll();
}
