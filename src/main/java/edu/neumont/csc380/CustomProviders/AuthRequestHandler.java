package edu.neumont.csc380.CustomProviders;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;

import edu.neumont.csc380.ExceptionManagement.forbidden.ForbiddenException;
import edu.neumont.csc380.ExceptionManagement.unauthorized.UnauthorizedException;

@Provider
public class AuthRequestHandler implements RequestHandler{

	public Response handleRequest(Message arg0, ClassResourceInfo arg1) {
		String method = (String) arg0.get(Message.HTTP_REQUEST_METHOD);
		if(method.equals("PUT") || method.equals("DELETE"))
		{
			String token = getAuthToken(arg0);
			
		}
		System.out.println("Authorized User");
		return null;
	}

	private String getAuthToken(Message arg0) {
		TreeMap stuff = (TreeMap)arg0.get(Message.PROTOCOL_HEADERS);
		ArrayList<String> morestuff = (ArrayList<String>) stuff.get("Authorization");
		return morestuff.get(0);
	}

	private Response authenticateRequest(String token) {
		boolean isAuthenticated = false;
		if(token != null && token.equals("serverPassword")){ isAuthenticated = true; }
		else if(token != null)
		{
			//authenticate user
			//if not authenticated return forbidden
		}
		else
		{
			
			//authenticateUserUsingAuthClient
		}
		return null;
	}

}
