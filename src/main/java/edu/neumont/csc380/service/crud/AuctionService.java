package edu.neumont.csc380.service.crud;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import edu.neumont.csc380.ProfileWebService.model.Auction;
import edu.neumont.csc380.ProfileWebService.model.CreateAuction;

@Path("/item")
@Consumes("application/json")
@Produces("application/json")
public interface AuctionService {
	
	@GET
	@Path("/{id}")
	Response getAuction(@PathParam("id") int id);
	
	@PUT
	@Path("/{id}")
	Response updateAuction(@PathParam("id") int id, Auction profile) throws InvalidInputException;
	
	@POST
	@Path("/create")
	Response postAuction(CreateAuction auction) throws InvalidInputException;
	
	@DELETE
	@Path("/{id}")
	Response deleteAuction(@PathParam("id") int id) throws InvalidInputException;
	
	@GET
	@Path("/{id}/bid")
	Response bidAuction(@PathParam("id") int id);
	
}
