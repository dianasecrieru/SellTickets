package service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.EventDAO;
import model.Event;

@Path("/event")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventService {

	private EventDAO eventDao;

	@GET
	@Path("/{id}")
	public Event getEvent(@PathParam("id") Long identifier) {
		return eventDao.findById(identifier);
	}

	@GET
	@Path("/list_events")
	public List<Event> getEvents() {
		return eventDao.findAll();
	}

	@Inject
	public void setEventDao(EventDAO eventDao) {
		this.eventDao = eventDao;
	}

}
