package edu.neumont.csc380.hello.service.crud;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/profile")
public interface ProfileService {


	@GET
	@Path("")
	String getYourMom();
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	Response getProfile(@PathParam("id") int id);
	
	@POST
	@Path("/{id}")
	String updateProfile(@PathParam("id") int id);
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	String postProfile();
	
	@DELETE
	@Path("/delete/{id}")
	String deleteProfile(@PathParam("id") int id);
	
}
