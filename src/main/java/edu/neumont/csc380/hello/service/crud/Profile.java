package edu.neumont.csc380.hello.service.crud;
import java.util.HashMap;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import edu.neumont.csc380.ProfileWebService.model.ContactInformation;
import edu.neumont.csc380.ProfileWebService.model.Person;

@Service("ProfileService")
public class Profile implements ProfileService {
	
	HashMap<Integer, Person> OurTestPerson = new HashMap<Integer, Person>();
	
	public Profile(){
		Initialize();
	}
	
	public void Initialize(){
		Person person = new Person();
		person.setId(1);
		person.setFirstName("MyName is Your Mom");
		person.setLastName("Not quite your mom's last name");
		person.setUsername("thedrunkmonkey33");
		ContactInformation conactinfo = new ContactInformation();
		conactinfo.setAddress("4242 wallabee way");
		conactinfo.setEmail("thedrunkenmonkey33@yourmom.com");
		conactinfo.setPhone("555-poop");
		person.setContactInformation(conactinfo);
		OurTestPerson.put(person.getId(), person);
	}
	
	
	public Response getProfile(int id) {
		Gson gson = new Gson();
		String json = gson.toJson(OurTestPerson.get(id));
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
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

	public String getYourMom() {
		
		return "Your mom was called";
	}

	
}
