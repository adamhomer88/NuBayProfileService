package edu.neumont.csc380.hello.service.crud;
import org.springframework.stereotype.Service;

@Service("ProfileService")
public class Profile implements ProfileService {

	public String getProfile(String id) {
		
		return "getting profile " + id;
	}

	public String updateProfile(String id) {
		
		return "updating profile " + id;
	}

	public String postProfile() {
		
		return "posting profile";
	}

	public String deleteProfile(String id) {
		
		return "delete profile";
	}

	public String getYourMom() {
		
		return "Your mom was called";
	}

	
}
