
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.killeen.asynctesterclient.Callback;

/**
 *
 * @author Joan
 */
public class AsyncITest {

	public AsyncITest() {
	}
	final Logger LOG = LoggerFactory.getLogger(AsyncITest.class);

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	@Test
	@Ignore
	public void simpleBlocking() throws InterruptedException, ExecutionException{
		Client client = ClientBuilder.newClient();

		Future<Response> future1 = client.target("http://localhost:8080/AsyncTester/rest/async")
				.request()
				.async()
				.get();

		// block until complete
		Response res1 = future1.get();
		
		String result1 = res1.readEntity(String.class);
		LOG.info("Async blocking result returned {}", result1);
		
	}
	
	@Test
	@Ignore
	public void usingCallback() throws InterruptedException, ExecutionException{
		Client client = ClientBuilder.newClient();
//
//		Future<String> future1 = client.target("http://localhost:8080/AsyncTester/rest/async")
//				.request()
//				.async()
//				.get(new Callback());
//		LOG.info("Future returned...{}", future1.toString());

		
		
	}

}
