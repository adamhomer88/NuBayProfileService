package edu.neumont.csc380.hello.service.crud;
import java.util.HashMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.springframework.stereotype.Service;

import edu.neumont.csc380.ProfileWebService.model.ContactInformation;
import edu.neumont.csc380.ProfileWebService.model.Profile;

@Service("ProfileService")
public class ProfileImplementation implements ProfileService {
	
	HashMap<Integer, Profile> OurTestPersons = new HashMap<Integer, Profile>();
	
	String password = "drunkenmonkey";
	
	
	public ProfileImplementation(){
		Initialize();
	}
	
	public void Initialize(){
		Profile person = new Profile();
		person.setId(1);
		person.setFirstName("MyName is Your Mom");
		person.setLastName("Not quite your mom's last name");
		person.setUsername("thedrunkmonkey33");
		ContactInformation conactinfo = new ContactInformation();
		conactinfo.setAddress("4242 wallabee way");
		conactinfo.setEmail("thedrunkenmonkey33@yourmom.com");
		conactinfo.setPhone("555-poop");
		person.setContactInformation(conactinfo);
		OurTestPersons.put(person.getId(), person);
	}
	
	
	public Response getProfile(int id) {
		Profile requestedProfile = OurTestPersons.get(id);
		if(requestedProfile == null)
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.ok(requestedProfile, "application/json").build();
	}

	public Response updateProfile(int id, Profile profile) throws InvalidInputException {
		System.out.println(profile.getId());
		if(profile.getId()!= 0 && id != profile.getId())
			throw new InvalidInputException("The Id passed in the JSON does not match the ID in the path URL");
		if(OurTestPersons.containsKey(id)){
			profile.setId(id);
			OurTestPersons.put(id, profile);
		}
		else
			return Response.notModified().build();
		return Response.ok(profile, "application/json").build();
	}

	public Response postProfile(Profile profile) throws InvalidInputException{
		profile.setId((OurTestPersons.size()+1));
		if(profile.getPassword() ==null || profile.getUsername() == null)
			throw new InvalidInputException();
		OurTestPersons.put(profile.getId(), profile);
		return Response.ok(profile, "application/json").build();
	}

	public Response deleteProfile(int id) {
		Profile removedProfile = null;
		if(OurTestPersons.containsKey(id)){
			removedProfile = OurTestPersons.remove(id);
		}
		else
			return Response.status(Status.NOT_FOUND).build();
		return Response.ok(removedProfile).build();
	}
}
