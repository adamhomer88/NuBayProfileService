package edu.neumont.csc380.service.crud;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.springframework.stereotype.Service;

import edu.neumont.csc380.Resources;
import edu.neumont.csc380.ProfileWebService.model.Auction;
import edu.neumont.csc380.ProfileWebService.model.CreateAuction;
import edu.neumont.csc380.ProfileWebService.model.ProfileInformation;

@Service("ProfileService")
public class AuctionImplementation implements AuctionService {
	
	HashMap<Integer, Auction> OurTestAuctions = new HashMap<Integer, Auction>();
	
	String password = "drunkenmonkey";
	
	
	public AuctionImplementation(){
		Initialize();
	}
	
	public void Initialize(){
//		Auction person = new Auction();
//		person.setId(1);
//		person.setFirstName("MyName is Your Mom");
//		person.setLastName("Not quite your mom's last name");
//		person.setUsername("thedrunkmonkey33");
//		ProfileInformation conactinfo = new ProfileInformation();
//		conactinfo.setAddress("4242 wallabee way");
//		conactinfo.setEmail("thedrunkenmonkey33@yourmom.com");
//		conactinfo.setPhone("555-poop");
//		person.setContactInformation(conactinfo);
//		OurTestAuctions.put(person.getId(), person);
	}
	
	
	public Response getAuction(int id) {
		Auction requestedAuction = OurTestAuctions.get(id);
		if(requestedAuction == null)
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.ok(requestedAuction, "application/json").build();
	}

	public Response updateAuction(int id, Auction auction) throws InvalidInputException {
		System.out.println(auction.getId());
		if(auction.getId()!= 0 && id != auction.getId())
			throw new InvalidInputException("The Id passed in the JSON does not match the ID in the path URL");
		if(OurTestAuctions.containsKey(id)){
			auction.setId(id);
			OurTestAuctions.put(id, auction);
		}
		else
			return Response.notModified().build();
		return Response.ok(auction, "application/json").build();
	}

	public Response postAuction(CreateAuction createAuction) throws InvalidInputException{
		Auction auction = new Auction();
		int id = OurTestAuctions.size()+1;
		auction.setId(id);
		if(createAuction.getOwnerId() < 0 || createAuction.getName() == null)
			throw new InvalidInputException();
		auction.setName(createAuction.getName());
		auction.setDescription(createAuction.getDescription());
		Date startDate = createAuction.getStartDate();
		if(startDate == null){
			startDate = Calendar.getInstance().getTime();
		}
		auction.setStartDate(startDate);
		Date endDate = createAuction.getEndDate();
		if(endDate == null){
			endDate = new Date(startDate.getTime() + 604800000);
		}
		if(endDate.before(startDate)){
			throw new InvalidInputException();
		}
		auction.setEndDate(endDate);
		ProfileInformation owner = new ProfileInformation();
		owner.setId(createAuction.getOwnerId());
		owner.setDetails(Resources.serverLocation + ":7075/ProfileService/rest/profile/" + createAuction.getOwnerId());
		auction.setOwner(owner);
		auction.setStatus(Auction.Status.READY);
		double startBid = createAuction.getStartingBid();
		if(startBid == 0){
			startBid = 1;
		}
		auction.setHighestBid(startBid);
		auction.setEdit(Resources.serverLocation + ":7077/item/" + auction.getId());
		OurTestAuctions.put(auction.getId(), auction);
		return Response.ok(auction, "application/json").build();
	}

	public Response deleteAuction(int id) {
		Auction removedProfile = null;
		if(OurTestAuctions.containsKey(id)){
			removedProfile = OurTestAuctions.remove(id);
		}
		else
			return Response.status(Status.NOT_FOUND).build();
		return Response.ok(removedProfile).build();
	}

	public Response bidAuction(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
