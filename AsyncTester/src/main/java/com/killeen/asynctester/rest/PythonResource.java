package com.killeen.asynctester.rest;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("python")
public class PythonResource {
	private static final Logger LOG = Logger.getLogger(PythonResource.class.getName());
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response generateNullPointer() {
		LOG.info("Python Resource");
		try {
	 throw new NullPointerException();
		} catch (Exception e) {
		  PythonResult result = new PythonResult();
		  result.setStackTrace(e.toString());
		  return Response.serverError()
				 .type(MediaType.APPLICATION_JSON)
				 .entity(e)
				 .build();
		}
		
	}

}
