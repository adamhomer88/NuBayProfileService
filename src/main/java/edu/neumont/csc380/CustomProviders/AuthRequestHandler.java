package edu.neumont.csc380.CustomProviders;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;

@Provider
public class AuthRequestHandler implements RequestHandler{

	public Response handleRequest(Message arg0, ClassResourceInfo arg1) {
		String method = (String) arg0.get(arg0.HTTP_REQUEST_METHOD);
		if(method.equals("PUT") || method.equals("DELETE"))
		{
			System.out.println("put method ran");
		}
		System.out.println("Authorized");
		return null;
	}

}
