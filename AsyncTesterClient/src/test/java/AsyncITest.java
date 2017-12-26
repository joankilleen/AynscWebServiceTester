/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;;



/**
 *
 * @author Joan
 */
public class AsyncITest {
    
    public AsyncITest() {
    }
    
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
    public void simple() {
        //get("http://localhost:8080/AsyncTester/rest/test").then().statusCode(200);
    	Client client = ClientBuilder.newClient();

    	Future<Response> future1 = client.target("http://localhost:8080/AsyncTester/rest/async")
    	                                 .request()
    	                                 .async().get();

    	

    	// block until complete
    	Response res1 = null;
		try {
			res1 = future1.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String result1 = res1.readEntity(String.class);
    }
    
    
}
