package edu.neumont.csc380.hello.service.crud;
import java.util.HashMap;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

import edu.neumont.csc380.ProfileWebService.model.ContactInformation;
import edu.neumont.csc380.ProfileWebService.model.Profile;

@Service("ProfileService")
public class ProfileImplementation implements ProfileService {
	
	HashMap<Integer, Profile> OurTestPersons = new HashMap<Integer, Profile>();
	
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

	public String updateProfile(int id) {
		
		return "updating profile " + id;
	}

	public String postProfile() {
		
		return "posting profile";
	}

	public String deleteProfile(int id) {
		
		return "delete profile";
	}	
}
