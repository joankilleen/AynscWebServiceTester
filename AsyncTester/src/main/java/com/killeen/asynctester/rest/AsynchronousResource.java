/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.killeen.asynctester.rest;

import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import javax.enterprise.concurrent.ManagedExecutorService;

@Path("/async")
public class AsynchronousResource {
	private static final Logger LOG = Logger.getLogger(AsynchronousResource.class.getName());
	@Resource
	ManagedExecutorService mes;

	@GET
	@Asynchronous
	public void asyncRestMethod(@Suspended final AsyncResponse asyncResponse) {
		String initialThread = Thread.currentThread().getName();
		
		LOG.info("reached async server method..." + initialThread);
		mes.execute(new Runnable() {
			@Override
			public void run() {
				String processingThread = Thread.currentThread().getName();
				LOG.info("Processing thread: " + processingThread);		
				final String respBody = UUID.randomUUID().toString();
				//Thread.sleep(5000);
				asyncResponse.resume(Response.ok(respBody).build());
			}
		});
        	

	}

	
}
