package com.killeen.asynctesterclient;

import java.time.LocalTime;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	public Main() {
		// TODO Auto-generated constructor stub
	}
	public void test(String resourceURI){
		Client client = ClientBuilder.newClient();
		try {
			System.out.println("starting test client...");		

			Future<String> future1 = client.target(resourceURI)
					.request()
					.async()
					.get(new Callback());
			System.out.println(LocalTime.now()+ " Future returned...");
			
		} finally{
			
			//client.close();
		}
		
	}

	public static void main(String[] args) {
		Main main = new Main();
		for (int i=100; i>0; i--){
			main.test("http://localhost:8080/AsyncTester/rest/async");
		}

	}

}
