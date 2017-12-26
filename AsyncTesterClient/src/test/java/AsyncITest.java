/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


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
        get("http://localhost:8080/async/rest/test").then().statusCode(200);
      
    }
    
    @Test
    public void reallyAssync() {
        get("http://localhost:8080/async/rest/async").then().statusCode(200);
      
    }
}
