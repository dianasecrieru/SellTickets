package app;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.core.Application;

import service.EventService;
import service.TicketService;
import service.UserService;

@WebServlet("/servletApp")
public class App extends Application {

	private Set<Class<?>> classes = new HashSet<>();

	public App() {
		classes.add(EventService.class);
		classes.add(TicketService.class);
		classes.add(UserService.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}
