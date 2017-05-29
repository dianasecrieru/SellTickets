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

import dao.UserDAO;
import model.User;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

	private UserDAO userDao;

	@GET
	@Path("/{id}")
	public User getUserById(@PathParam("id") Long identifier) {
		return userDao.findById(identifier);
	}

	@GET
	@Path("/{username}")
	public User getUserByUsername(@PathParam("username") String identifier) {
		return userDao.findByUsername(identifier);
	}

	@POST
	public Response save(User user) {
		return Response.ok(userDao.save(user)).build();
	}

	@DELETE
	@Path("/delete/{id}")
	public Response deleteUser(@PathParam("id") Long identifier) {
		User user = userDao.findById(identifier);
		userDao.delete(user);
		return Response.ok().build();
	}

	@Inject
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
}
