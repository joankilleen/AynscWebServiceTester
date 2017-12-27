package com.killeen.asynctesterclient;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncITest {
	private static final Logger LOG = LoggerFactory.getLogger(AsyncITest.class);
	Client client = null;
	@Before
	public void setUp() throws Exception {
		client = ClientBuilder.newClient();
	}

	@After
	public void tearDown() throws Exception {
		client.close();
	}

	@Test
	public void asyncTest() {
		for (int i=10; i>0; i--){
			callFuture("http://localhost:8080/AsyncTester/rest/async");
		}
	}
	
	
	public void callFuture(String resourceURI){
		Client client = ClientBuilder.newClient();
		try {
			System.out.println("starting test client...");		

			Future<String> future1 = client.target(resourceURI)
					.request()
					.async()
					.get(new Callback());
			System.out.println(LocalTime.now()+ " Future returned..." );
			
		} finally{
			
			;
		}
		
	}

}
