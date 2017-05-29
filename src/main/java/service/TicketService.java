package service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.TicketDAO;
import model.Ticket;

@Path("/ticket")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TicketService {

	private TicketDAO ticketDao;

	@GET
	@Path("/ticket_details/{id}")
	public Ticket getTicket(@PathParam("id") Long identifier) {
		return ticketDao.findById(identifier);
	}

	@POST
	@Path("/buy_ticket")
	public Response save(Ticket ticket) {
		return Response.ok(ticketDao.save(ticket)).build();
	}

	@DELETE
	@Path("/cancel_ticket/{id}")
	public Response cancel(@PathParam("id") Long identifier) {
		Ticket ticket=ticketDao.findById(identifier);
		ticketDao.delete(ticket);
		return Response.ok().build();
	}

	@Inject
	public void setCustomerDao(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}

}
